package com.spring_boot.async.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.spring_boot.async.constant.AsyncConstant;

@Configuration
@EnableAsync
public class AsyncConfig {

	@Primary
	@Bean(name = AsyncConstant.LIGHT_TASK_EXECUTOR)
	Executor taskExecutorLight() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(5);
		executor.setMaxPoolSize(5);
		executor.setQueueCapacity(100);
		executor.setThreadNamePrefix("AsyncLightThread-");
		executor.initialize();
		return executor;
	}

	@Bean(name = AsyncConstant.HEAVY_TASK_EXECUTOR)
	Executor taskExecutorHeavy() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(50);
		executor.setThreadNamePrefix("AsyncHeavyThread-");
		executor.initialize();
		return executor;
	}
}
