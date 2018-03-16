package online.shixun.ssmresume.server;

import online.shixun.ssmresume.model.Skill;

import java.util.List;

/**
 * Created by 张罗平 on 2018/2/4.
 */
public interface SkillServer {
    List<Skill> findSkill();
    void updateSkill(Skill skill);
}
