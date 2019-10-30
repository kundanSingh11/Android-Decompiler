package com.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.model.ApkTask;
import com.jwt.tasks.DecompileTask;

@Service
@Transactional
public class DecompilerService {

	@Autowired
	private TaskExecutor taskExecutor;

	@Autowired
	private ApplicationContext applicationContext;

	public void executeAsynchronously(ApkTask id) {
		DecompileTask myThread = applicationContext.getBean(DecompileTask.class);
		myThread.setTask(id);
		taskExecutor.execute(myThread);
	}
}
