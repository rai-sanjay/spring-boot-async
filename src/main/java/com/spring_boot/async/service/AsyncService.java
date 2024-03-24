package com.spring_boot.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.spring_boot.async.constant.AsyncConstant;

@Service
public class AsyncService {

	private static int count = 1;

	@Async(AsyncConstant.LIGHT_TASK_EXECUTOR)
	public void performAsyncTask(String uniqueID) {
		// Simulate a time-consuming task
		try {
			System.out.println("Async task ==" + count + " started with request ID - " + uniqueID + " in Thread - "
					+ Thread.currentThread().getName());
			Thread.sleep(20000); // Sleep for 5 seconds
			System.out.println("Async task ==" + count + " completed with ID - " + uniqueID);
			count++;
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
