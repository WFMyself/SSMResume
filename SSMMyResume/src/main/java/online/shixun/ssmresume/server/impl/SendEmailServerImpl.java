package online.shixun.ssmresume.server.impl;

import online.shixun.ssmresume.mapper.SendEmailMapper;
import online.shixun.ssmresume.model.SendEmail;
import online.shixun.ssmresume.server.SendEmailServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 张罗平 on 2018/1/24.
 */

@Service

public class SendEmailServerImpl implements SendEmailServer{

    @Autowired
    private SendEmailMapper sendEmailMapper;

    @Override
    public int saveSendEmail(SendEmail sendEmail) {
        return sendEmailMapper.saveSendEmail(sendEmail);
    }
}
