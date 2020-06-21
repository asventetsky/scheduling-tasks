# Spring Boot + ShedLock Demo Project
Demo project for testing distributed lock using @SchedulerLock annotation for @Scheduled tasks in distributed environment.<br/><br/>
Application has 4 scheduled tasks, which executes every 10th seconds during 5 seconds.

## Description
- `@EnableScheduling` - registers `ScheduledAnnotationBeanPostProcessor`<br/>
- `ScheduledAnnotationBeanPostProcessor` - registers methods annotated with `@Scheduled`
to be invoked by a `org.springframework.scheduling.TaskScheduler`

By default, will be searching for an associated scheduler definition: either a unique `TaskScheduler` bean in the context, or a `TaskScheduler` bean named "taskScheduler" otherwise; the same lookup will also be performed for a `ScheduledExecutorService` bean. If neither of the two is resolvable, a local single-threaded default scheduler will be created and used within the registrar.
```text
ScheduledTaskRegistrar.class
...
protected void scheduleTasks() {
    if (this.taskScheduler == null) {
	    this.localExecutor = Executors.newSingleThreadScheduledExecutor();
	    this.taskScheduler = new ConcurrentTaskScheduler(this.localExecutor);
    }
    ...
}
```

### Results for thread pool of size 1 (default)
| id | host | event\_type | thread | created\_at |
| :--- | :--- | :--- | :--- | :--- |
| 1 | 3f5240cd417a | SECOND | scheduling-1 | 2020-06-21 15:36:40.183000 |
| 2 | 63336a343928 | FIRST | scheduling-1 | 2020-06-21 15:36:40.212000 |
| 3 | 3f5240cd417a | FIRST | scheduling-1 | 2020-06-21 15:36:45.220000 |
| 4 | 63336a343928 | FOURTH | scheduling-1 | 2020-06-21 15:36:45.227000 |
| 5 | 3f5240cd417a | FOURTH | scheduling-1 | 2020-06-21 15:36:50.253000 |
| 6 | 63336a343928 | THIRD | scheduling-1 | 2020-06-21 15:36:50.254000 |
| 7 | 63336a343928 | FIRST | scheduling-1 | 2020-06-21 15:36:55.289000 |
| 8 | 3f5240cd417a | THIRD | scheduling-1 | 2020-06-21 15:36:55.295000 |
| 9 | 3f5240cd417a | FIRST | scheduling-1 | 2020-06-21 15:37:00.316000 |
| 10 | 63336a343928 | SECOND | scheduling-1 | 2020-06-21 15:37:00.317000 |
| 11 | 3f5240cd417a | FOURTH | scheduling-1 | 2020-06-21 15:37:05.335000 |
| 12 | 63336a343928 | THIRD | scheduling-1 | 2020-06-21 15:37:05.340000 |
| 13 | 3f5240cd417a | THIRD | scheduling-1 | 2020-06-21 15:37:10.345000 |
| 14 | 63336a343928 | SECOND | scheduling-1 | 2020-06-21 15:37:10.350000 |
| 15 | 3f5240cd417a | FIRST | scheduling-1 | 2020-06-21 15:37:15.356000 |
| 16 | 63336a343928 | FOURTH | scheduling-1 | 2020-06-21 15:37:15.359000 |
| 17 | 3f5240cd417a | SECOND | scheduling-1 | 2020-06-21 15:37:20.367000 |
| 18 | 63336a343928 | FIRST | scheduling-1 | 2020-06-21 15:37:20.368000 |
| 19 | 3f5240cd417a | FOURTH | scheduling-1 | 2020-06-21 15:37:25.378000 |

### Results for thread pool of size 4


## Getting started
`docker-compose up --build -d --scale scheduling-tasks=2`<br/><br/>
This command creates 1 container of `postgres` and 2 containers of `scheduling-tasks` services.<br/>
