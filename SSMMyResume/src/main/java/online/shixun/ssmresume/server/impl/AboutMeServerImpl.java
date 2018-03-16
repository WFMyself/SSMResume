package online.shixun.ssmresume.server.impl;

import online.shixun.ssmresume.mapper.AboutMeMapper;
import online.shixun.ssmresume.model.AboutMe;
import online.shixun.ssmresume.server.AboutMeServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 张罗平 on 2018/1/25.
 */
@Service
public class AboutMeServerImpl implements AboutMeServer{

    @Autowired
    private AboutMeMapper aboutMeMapper;


    @Override
    public List<AboutMe> findAboutMe(Long id) {
        return aboutMeMapper.findAboutMe(id);
    }

    @Override
    public void updateAboutMe(AboutMe aboutMe) {
        aboutMeMapper.updateAboutMe(aboutMe);
    }


}
