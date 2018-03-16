package online.shixun.ssmresume.controller;

import online.shixun.ssmresume.model.AboutMe;
import online.shixun.ssmresume.server.EducationDegreeServer;
import online.shixun.ssmresume.server.SkillServer;
import online.shixun.ssmresume.server.WorkingStatusServer;
import online.shixun.ssmresume.server.impl.AboutMeServerImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 个人信息Controller类
 */
@Controller
@RequestMapping("about")
public class AboutMeController {


    @Autowired
    private AboutMeServerImpl aboutMeServer;

    @Autowired
    private EducationDegreeServer educationDegreeServer;

    @Autowired
    private WorkingStatusServer workingStatusServer;

    @Autowired
    private SkillServer skillServer;

    //http://localhost:8080/about/index
    @RequestMapping(value = "index",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView index(ModelAndView mav, AboutMe aboutMe){

        System.out.println("------------->index");
        List<AboutMe> list= aboutMeServer.findAboutMe(1L);
        for (AboutMe aboutMes:list) {
            System.out.println(aboutMes);
        }

        mav.addObject("aboutMes",aboutMeServer.findAboutMe(1L));
        mav.addObject("skills",skillServer.findSkill());
        System.out.println(skillServer.findSkill());
        mav.setViewName("index");
        return mav;
    }


    /**
     * 编辑我的信息
     * @param mav
     * @param aboutMe
     * @return
     * http://localhost:8080/about/findAboutMe
     */

    @RequestMapping(value = "findAboutMe",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ModelAndView findAboutMe(ModelAndView mav,AboutMe aboutMe){
        System.out.println("------------>findAboutMe");

       mav.addObject("aboutMes",aboutMeServer.findAboutMe(1L));
       mav.addObject("educationDegree",educationDegreeServer.findEducationDegree());
       mav.addObject("workingStatus",workingStatusServer.findWorkingStatus());

       mav.setViewName("aboutMe");
       return mav;
    }

    /**
     * 修改我的基本信息
     * @param aboutMe
     * @return
     * http://localhost:8080/about/updateAboutMe
     */
    @PostMapping(value = "updateAboutMe")
    public String updateAboutMe(AboutMe aboutMe,Model model) {
        System.out.println("--------------->updateAboutMe");
           //编辑后更新
        aboutMeServer.updateAboutMe(aboutMe);
        List<AboutMe> aboutMes=aboutMeServer.findAboutMe(1L);
        System.out.println(aboutMes);
        model.addAttribute("aboutMes",aboutMes);
        return "aboutMe";
    }

    // http://localhost:8080/about/image

    @RequestMapping(value = "image",method = {RequestMethod.POST})
    @ResponseBody
    public String uploadImage(HttpServletRequest request,
                              HttpServletResponse response, HttpSession session,
                              @RequestParam(value = "file", required = true) MultipartFile file)
            throws IllegalStateException, IOException {

        System.out.println("------------->uploadImage");

        String path = session.getServletContext().getRealPath("/upload");
        System.out.println("real path: " + path);
        String fileName = file.getOriginalFilename();
        System.out.println("file name: " + fileName);
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        file.transferTo(targetFile);
        String fileUrl = request.getContextPath() + "/upload/" + fileName;
        return fileUrl;
    }
}

