package com.shiju.aiagent.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ErrorController {

    private static final Logger log = LoggerFactory.getLogger(ErrorController.class);

    @GetMapping("/db-error")
    public String dbError() {
        log.info("DB API called");
        throw new RuntimeException("Database connection timeout");
    }

    @GetMapping("/null-error")
    public String nullError() {
        log.info("Null API called");
        String value = null;
        return value.toString();
    }

    @GetMapping("/external-error")
    public String externalError() {
        log.info("External API call");
        throw new RuntimeException("External API returned 500");
    }

    @GetMapping("/slow")
    public String slow() throws InterruptedException {
        log.info("Slow API triggered");
        Thread.sleep(5000);
        return "Delayed response";
    }
}