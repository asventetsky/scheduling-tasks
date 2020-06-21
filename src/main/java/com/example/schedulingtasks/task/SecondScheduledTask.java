package com.example.schedulingtasks.task;

import com.example.schedulingtasks.EventRepository;
import com.example.schedulingtasks.aspect.Audit;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SecondScheduledTask {

	private final EventRepository repository;

	public SecondScheduledTask(EventRepository repository) {
		this.repository = repository;
	}

	@Audit
	@Scheduled(cron = "*/10 * * * * *")
	@SchedulerLock(name = "secondScheduledTask", lockAtMostFor = "PT5S")
	public void secondScheduledTask() throws Exception {
		repository.save("SECOND");
		Thread.sleep(5000);
	}
}
