package com.example.schedulingtasks;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

@Repository
public class EventRepository {

    private static final String QUERY = "INSERT INTO events (host, event_type, thread, created_at) VALUES (?, ?, ?, ?)";

    @Resource
    private JdbcTemplate jdbcTemplate;

    public void save(String event) throws UnknownHostException {
        jdbcTemplate.update(
                QUERY,
                InetAddress.getLocalHost().getHostName(),
                event,
                Thread.currentThread().getName(),
                new Date()
        );
    }
}
