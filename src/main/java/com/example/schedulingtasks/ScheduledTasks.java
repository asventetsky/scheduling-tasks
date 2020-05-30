/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.schedulingtasks;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.util.Date;

import static java.lang.String.format;

@Component
public class ScheduledTasks {

	@Resource
	private JdbcTemplate jdbcTemplate;

//	@Autowired
//	private ThreadPoolTaskScheduler taskScheduler;

	@Scheduled(cron = "*/10 * * * * *")
	@SchedulerLock(name = "reportEvent", lockAtMostFor = "PT5S")
	public void reportEvent() throws Exception {
		jdbcTemplate.update(
				"INSERT INTO events (text, created_at) VALUES (?, ?)",
				format("Hostname: %s", InetAddress.getLocalHost().getHostName()),
				new Date()
		);
		Thread.sleep(5000);
	}
}
