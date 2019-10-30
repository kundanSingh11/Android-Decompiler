package com.jwt.tasks;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.beans.factory.annotation.Autowired;

import com.jwt.dao.ApkTaskDao;
import com.jwt.model.ApkTask;
import com.jwt.model.attributeconveters.ApkTaskStatus;

public class RejectedThreadHandler implements RejectedExecutionHandler {

	@Autowired
	private ApkTaskDao apktaskDao;

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		if (r instanceof DecompileTask) {
			ApkTask apkTask = ((DecompileTask) r).getTask();
			apkTask.setStatus(ApkTaskStatus.REJECTED);
			apktaskDao.updateTask(apkTask);
		}
	}
}
