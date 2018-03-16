package online.shixun.ssmresume.mapper;


import online.shixun.ssmresume.model.AboutMe;

import java.util.List;

public interface AboutMeMapper {
    List<AboutMe> findAboutMe(Long id);
    void updateAboutMe(AboutMe aboutMe);
}