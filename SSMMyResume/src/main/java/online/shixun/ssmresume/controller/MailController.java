package online.shixun.ssmresume.controller;

import online.shixun.ssmresume.model.SendEmail;
import online.shixun.ssmresume.server.SendEmailServer;
import online.shixun.ssmresume.server.impl.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

/**
 * 邮件Controller类
 */
@Controller
@RequestMapping("/index")
public class MailController {
    @Autowired
    private SendEmailServer sendEmailServer;

    @Autowired
    @Qualifier("MailService")
    private MailService mailService;

    /**
     * 定位到index.jsp穿过servlet获取配置文件信息
     * @param locale
     * @param model
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String to_index(Locale locale, Model model){
        System.out.println("locale:"+locale);
        return "index";
    }

    //保存游客发送的信息

    /**
     * 数据库存档，发送邮件接收
     * @param sendEmail
     * @return
     *     /index/saveSendEmail
     */
    @PostMapping("saveSendEmail")
    public String saveSendEmail(@ModelAttribute SendEmail sendEmail){
        System.out.println(sendEmail);
        mailService.sendHtmlMail(sendEmail.getLookerEmail(),"简历返回信息",sendEmail.getLookerMessage());
        sendEmailServer.saveSendEmail(sendEmail);
        return "index";
    }
}