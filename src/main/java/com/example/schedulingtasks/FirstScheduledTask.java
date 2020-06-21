package com.example.schedulingtasks;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FirstScheduledTask {

	private final EventRepository repository;

	public FirstScheduledTask(EventRepository repository) {
		this.repository = repository;
	}

	@Scheduled(cron = "*/10 * * * * *")
	@SchedulerLock(name = "firstScheduledTask", lockAtMostFor = "PT5S")
	public void firstScheduledTask() throws Exception {
		repository.save("FIRST");
		Thread.sleep(5000);
	}
}
