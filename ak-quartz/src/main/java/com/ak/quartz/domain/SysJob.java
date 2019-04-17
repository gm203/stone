package com.ak.quartz.domain;

import java.io.Serializable;
import java.util.Date;

import com.ak.common.annotation.Excel;
import com.ak.common.constant.ScheduleConstants;
import com.ak.common.core.domain.BaseEntity;
import com.ak.common.utils.StringUtils;
import com.ak.quartz.util.CronUtils;

import lombok.Getter;
import lombok.Setter;

/**
 * 定时任务调度表 sys_job
 * 
 * @author ak
 */
@Getter
@Setter
public class SysJob extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 任务ID */
	@Excel(name = "任务序号")
	private Long jobId;

	/** 任务名称 */
	@Excel(name = "任务名称")
	private String jobName;

	/** 任务组名 */
	@Excel(name = "任务组名")
	private String jobGroup;

	/** 任务方法 */
	@Excel(name = "任务方法")
	private String methodName;

	/** 方法参数 */
	@Excel(name = "方法参数")
	private String methodParams;

	/** cron执行表达式 */
	@Excel(name = "执行表达式 ")
	private String cronExpression;

	/** cron计划策略 */
	@Excel(name = "计划策略 ")
	private String misfirePolicy = ScheduleConstants.MISFIRE_DEFAULT;

	/** 是否并发执行（0允许 1禁止） */
	@Excel(name = "并发执行", readConverterExp = "0=允许,1=禁止")
	private String concurrent;

	/** 任务状态（0正常 1暂停） */
	@Excel(name = "任务状态", readConverterExp = "0=正常,1=暂停")
	private String status;

	public Date getNextValidTime() {
		if (StringUtils.isNotEmpty(cronExpression)) {
			return CronUtils.getNextExecution(cronExpression);
		}
		return null;
	}
}