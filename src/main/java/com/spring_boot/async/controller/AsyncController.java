package com.spring_boot.async.controller;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot.async.service.AsyncService;

@RestController
public class AsyncController {

	@Autowired
	private AsyncService asyncService;

	@GetMapping("/async-task")
	public String triggerAsyncTask() throws InterruptedException, ExecutionException {
		System.out.println("Controller - "+Thread.currentThread().getName());
		String uniqueID = UUID.randomUUID().toString();
		  asyncService.performAsyncTask(uniqueID);
		 return "Async task submitted successfully with request ID - "+uniqueID;
	}
}
