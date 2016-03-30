package com.mypack;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

public class SimpleTrigger1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		JobDetail detail= new JobDetail();
		detail.setName("myjob");
		
		detail.setJobClass(HelloJob.class);

		
		org.quartz.SimpleTrigger sTrigget= new org.quartz.SimpleTrigger();
		sTrigget.setName("myTrigger");
		sTrigget.setStartTime(new Date(System.currentTimeMillis() + 1000));
		sTrigget.setRepeatCount(org.quartz.SimpleTrigger.REPEAT_INDEFINITELY);
		sTrigget.setRepeatInterval(3000);
		
		Scheduler sche= new StdSchedulerFactory().getScheduler();		
		sche.start();		
		sche.scheduleJob(detail, sTrigget);		
	}

}
