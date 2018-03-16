package online.shixun.ssmresume.server;

import online.shixun.ssmresume.model.SendEmail;

/**
 * Created by 张罗平 on 2018/1/24.
 */
public interface SendEmailServer {

    int saveSendEmail(SendEmail sendEmail);
}
