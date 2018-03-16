package online.shixun.ssmresume.server.impl;

import online.shixun.ssmresume.mapper.SkillMapper;
import online.shixun.ssmresume.model.Skill;
import online.shixun.ssmresume.server.SkillServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 张罗平 on 2018/2/4.
 */
@Service
public class SkillServerImpl implements SkillServer{

    @Autowired
    private SkillMapper skillMapper;
    @Override
    public List<Skill> findSkill() {
        return skillMapper.findSkill();
    }

    @Override
    public void updateSkill(Skill skill) {
        skillMapper.updateSkill(skill);
    }
}
