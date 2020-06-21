package com.example.schedulingtasks;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FourthScheduledTask {

	private final EventRepository repository;

	public FourthScheduledTask(EventRepository repository) {
		this.repository = repository;
	}

	@Scheduled(cron = "*/10 * * * * *")
	@SchedulerLock(name = "fourthScheduledTask", lockAtMostFor = "PT5S")
	public void fourthScheduledTask() throws Exception {
		repository.save("FOURTH");
		Thread.sleep(5000);
	}
}
