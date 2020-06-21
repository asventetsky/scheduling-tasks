package com.example.schedulingtasks.task;

import com.example.schedulingtasks.EventRepository;
import com.example.schedulingtasks.aspect.Audit;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ThirdScheduledTask {

	private final EventRepository repository;

	public ThirdScheduledTask(EventRepository repository) {
		this.repository = repository;
	}

	@Audit
	@Scheduled(cron = "*/10 * * * * *")
	@SchedulerLock(name = "thirdScheduledTask", lockAtMostFor = "PT5S")
	public void thirdScheduledTask() throws Exception {
		repository.save("THIRD");
		Thread.sleep(5000);
	}
}
