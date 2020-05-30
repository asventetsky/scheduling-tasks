#Spring Boot + ShedLock Demo Project
Demo project for testing distributed lock using @SchedulerLock annotation for @Scheduled tasks in distributed environment.<br/><br/>
To start demo project execute:<br/>
`docker-compose up --build -d --scale scheduling-tasks=4`<br/><br/>
This command creates 1 container of `postgres` and 4 containers of `scheduling-tasks` services.<br/>
