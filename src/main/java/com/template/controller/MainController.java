package com.template.controller;

import com.template.service.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * main controller
 */
@RestController
public class MainController {

    @Autowired
    DummyService dummyService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<String> test() {
        return ResponseEntity.ok(dummyService.callMe());
    }
}
