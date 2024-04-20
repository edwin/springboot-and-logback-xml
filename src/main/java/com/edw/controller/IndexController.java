package com.edw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <pre>
 *     com.edw.controller.IndexController
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 20 Apr 2024 13:54
 */
@RestController
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/")
    public HashMap getIndexPage() {
        logger.debug("we are at index page using {}", "DEBUG");
        logger.info("we are at index page using {}", "INFO");

        return new HashMap() {{
            put("hello", "world");
        }};

    }

}
