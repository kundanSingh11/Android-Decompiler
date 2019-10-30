package com.jwt.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@EnableScheduling
@Transactional
public class PurgeTask {

	

	@Scheduled(fixedDelay = 1800000, initialDelay = 1000)
	public void begainPurge() {
		// List<ApkTask> completedWork = apkTaskDao.getAllTaskForPurge();
	}
}
