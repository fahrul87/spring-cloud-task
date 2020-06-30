package com.fahrul.springcloudtask;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.cloud.task.listener.annotation.AfterTask;
import org.springframework.cloud.task.listener.annotation.BeforeTask;
import org.springframework.cloud.task.listener.annotation.FailedTask;
import org.springframework.cloud.task.repository.TaskExecution;

@SpringBootApplication
@EnableTask
public class SpringCloudTaskApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTaskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	System.out.println("Welcome to "+ args[0]);
		
	}
	@BeforeTask
	public void start(TaskExecution taskExecution) {
		System.out.println("Taskname : " + taskExecution.getTaskName() + " Execution Id : "+
				taskExecution.getExecutionId() + "Started....");
	}
	@AfterTask
	public void end(TaskExecution taskExecution) {
		System.out.println("TaskName : " + taskExecution.getTaskName() + " Execution Id : "+
	taskExecution.getExecutionId()+" failed...");
	}
	@FailedTask
	public void fail(TaskExecution taskExecution) {
		System.out.println("TaskName : " + taskExecution.getTaskName() + " Executin Id : " +
	taskExecution.getExecutionId()+" failed....");
	}
	

}
