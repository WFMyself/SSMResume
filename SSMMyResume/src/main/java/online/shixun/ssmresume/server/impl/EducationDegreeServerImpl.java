package online.shixun.ssmresume.server.impl;

import online.shixun.ssmresume.mapper.EducationDegreeMapper;
import online.shixun.ssmresume.model.EducationDegree;
import online.shixun.ssmresume.server.EducationDegreeServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 张罗平 on 2018/1/25.
 */
@Service
public class EducationDegreeServerImpl implements EducationDegreeServer{


    @Autowired
    private EducationDegreeMapper educationDegreeMapper;
    @Override
    public List<EducationDegree> findEducationDegree() {
        return educationDegreeMapper.findEducation();
    }
}
