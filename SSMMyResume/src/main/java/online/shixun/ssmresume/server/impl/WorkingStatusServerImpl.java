package online.shixun.ssmresume.server.impl;

import online.shixun.ssmresume.mapper.WorkingStatusMapper;
import online.shixun.ssmresume.model.WorkingStatus;
import online.shixun.ssmresume.server.WorkingStatusServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 张罗平 on 2018/1/25.
 */
@Service
public class WorkingStatusServerImpl implements WorkingStatusServer{

    @Autowired
    private WorkingStatusMapper workingStatusMapper;

    @Override
    public List<WorkingStatus> findWorkingStatus() {
        return workingStatusMapper.findWorking();
    }
}
