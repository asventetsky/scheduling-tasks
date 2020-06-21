package com.example.schedulingtasks.task;

import com.example.schedulingtasks.EventRepository;
import com.example.schedulingtasks.aspect.Audit;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FirstScheduledTask {

	private final EventRepository repository;

	public FirstScheduledTask(EventRepository repository) {
		this.repository = repository;
	}

	@Audit
	@Scheduled(cron = "*/10 * * * * *")
	@SchedulerLock(name = "firstScheduledTask", lockAtMostFor = "PT5S")
	public void firstScheduledTask() throws Exception {
		repository.save("FIRST");
		Thread.sleep(5000);
	}
}
