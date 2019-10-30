package com.jwt.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.tasks.RejectedThreadHandler;

@Configuration
@EnableAsync
@EnableScheduling
public class ThreadPoolConfig {

	@Bean
	@Transactional
	public TaskExecutor threadPoolTaskExecutor() {

		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(10);
		executor.setMaxPoolSize(10);
		executor.setQueueCapacity(10);
		executor.setThreadNamePrefix("apk_decompile_pool_thread");
		executor.initialize();
		executor.setRejectedExecutionHandler(new RejectedThreadHandler());
		return executor;
	}
}
