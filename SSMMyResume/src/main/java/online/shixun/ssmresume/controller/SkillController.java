package online.shixun.ssmresume.controller;

import online.shixun.ssmresume.common.DataBinderSkill;
import online.shixun.ssmresume.model.Skill;
import online.shixun.ssmresume.server.SkillServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * 技能Controller类
 */
@Controller
@RequestMapping("skill")
public class SkillController {

    @Autowired
    private SkillServer skillServer;

    @Autowired
    private DataBinderSkill dataBinderSkill;

    /**
     *
     * @param mav
     * @return
     * http://localhost:8080/skill/findSkill
     */
    @RequestMapping(value = "findSkill",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ModelAndView findSkill(ModelAndView mav){
        System.out.println("------------->findSkill");
        System.out.println(skillServer.findSkill());

        dataBinderSkill.setSkills(skillServer.findSkill());
        mav.addObject("dataBinderSkill",dataBinderSkill.getSkills());
        mav.setViewName("skill");
        return mav;
    }


    @PostMapping("updateSkill")
    public ModelAndView updateSkill(DataBinderSkill dataBinderSkill,ModelAndView mav){

        for (Skill skill:dataBinderSkill.getSkills()) {
            skillServer.updateSkill(skill);
        }

        dataBinderSkill.setSkills(skillServer.findSkill());
        mav.addObject("dataBinderSkill",dataBinderSkill.getSkills());
        System.out.println("skills"+dataBinderSkill.getSkills());

        mav.setViewName("skill");
        return mav;
    }
}
