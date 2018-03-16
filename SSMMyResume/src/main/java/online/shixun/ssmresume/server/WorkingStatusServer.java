package online.shixun.ssmresume.server;

import online.shixun.ssmresume.model.WorkingStatus;

import java.util.List;

/**
 * Created by 张罗平 on 2018/1/25.
 */
public interface WorkingStatusServer {

    public List<WorkingStatus> findWorkingStatus();
}
