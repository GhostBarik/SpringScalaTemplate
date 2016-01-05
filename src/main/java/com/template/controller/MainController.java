package com.template.controller;

import com.template.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Main controller
 */
@RestController
public class MainController {

    /**
     * default logger
     */
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    /**
     * User service
     */
    @Autowired
    UserService userService;


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<String> test() {

        logger.info("calling controller!");

        return ResponseEntity.ok(userService.getAllUsers().toString());
    }
}
