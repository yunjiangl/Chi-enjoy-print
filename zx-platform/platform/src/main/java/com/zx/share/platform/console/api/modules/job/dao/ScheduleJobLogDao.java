package com.zx.share.platform.console.api.modules.job.dao;

import com.zx.share.platform.console.api.modules.job.entity.ScheduleJobLogEntity;
import com.zx.share.platform.console.api.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 定时任务日志
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2016年12月1日 下午10:30:02
 */
@Mapper
public interface ScheduleJobLogDao extends BaseDao<ScheduleJobLogEntity> {
	
}
