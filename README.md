**Spring Boot + ShedLock Demo Project**<br/>
Demo project for testing lock using @SchedulerLock for @Scheduled tasks in distributed environment.<br/><br/>
To start demo project execute:<br/>
`docker-compose up --build -d --scale scheduling-tasks=4`<br/><br/>
Scheduled task from each container should create record in `events` table. For example,<br/>
