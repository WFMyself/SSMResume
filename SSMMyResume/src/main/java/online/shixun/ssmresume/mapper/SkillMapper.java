package online.shixun.ssmresume.mapper;

import online.shixun.ssmresume.model.Skill;

import java.util.List;


public interface SkillMapper {
    List<Skill> findSkill();
     void updateSkill(Skill skill);
}
