package online.shixun.ssmresume.server;

import online.shixun.ssmresume.model.AboutMe;

import java.util.List;

/**
 * Created by 张罗平 on 2018/1/25.
 */
public interface AboutMeServer {

   public List<AboutMe> findAboutMe(Long id);

   public void updateAboutMe(AboutMe aboutMe);
}
