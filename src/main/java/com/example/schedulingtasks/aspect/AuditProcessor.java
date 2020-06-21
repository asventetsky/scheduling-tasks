package com.example.schedulingtasks.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditProcessor {

    private static final Logger logger = LoggerFactory.getLogger(AuditProcessor.class);

    @Before("@annotation(com.example.schedulingtasks.aspect.Audit)")
    public void audit() {
        logger.info("Started execution of scheduled task in {} thread", Thread.currentThread().getName());
    }
}
