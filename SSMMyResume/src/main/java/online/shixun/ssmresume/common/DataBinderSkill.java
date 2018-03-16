package online.shixun.ssmresume.common;

import online.shixun.ssmresume.model.Skill;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class DataBinderSkill {
    private List<Skill> skills=new ArrayList<>();

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public DataBinderSkill(List<Skill> skills) {
        this.skills = skills;
    }

    public DataBinderSkill() {
    }

    @Override
    public String toString() {
        return "DataBinder{" +
                "skills=" + skills +
                '}';
    }
}

