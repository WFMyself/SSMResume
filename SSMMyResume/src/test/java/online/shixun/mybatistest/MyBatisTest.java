package online.shixun.mybatistest;

import com.alibaba.fastjson.JSON;
import online.shixun.ssmresume.model.AboutMe;
import online.shixun.ssmresume.model.EducationDegree;
import online.shixun.ssmresume.model.WorkingStatus;
import online.shixun.ssmresume.server.AboutMeServer;
import online.shixun.ssmresume.server.EducationDegreeServer;
import online.shixun.ssmresume.server.SkillServer;
import online.shixun.ssmresume.server.WorkingStatusServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by 张罗平 on 2018/1/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:appliactionContext-mybatis.xml","classpath:appliactionContext-service.xml"})
public class MyBatisTest {

    @Autowired
    private AboutMeServer aboutMeServer;

    @Autowired
    private EducationDegreeServer educationDegreeServer;

    @Autowired
    private WorkingStatusServer workingStatusServer;

    @Autowired
    private SkillServer skillServer;

    private static Logger logger = LoggerFactory.getLogger(MyBatisTest.class);
    @Test
    public void findTest(){

        System.out.println(skillServer.findSkill());

//        aboutMeServer.updateAboutMe(new AboutMe("傅红雪","Male","刀在人在","四川","2214221888@qq.com","13623423452","5"));

//        List<AboutMe> users =aboutMeServer.findAboutMe(1L);
//        List<EducationDegree> educationDegrees=educationDegreeServer.findEducationDegree();
//        List<WorkingStatus> workingStatuses =workingStatusServer.findWorkingStatus();
//        System.out.println(users);
//        System.out.println(educationDegrees);
//        System.out.println(workingStatuses);
//        logger.info(JSON.toJSONString(users));

    }
}
