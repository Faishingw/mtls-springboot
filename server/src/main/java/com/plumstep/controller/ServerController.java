package com.plumstep.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("server")
public class ServerController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RestTemplate restTemplate2;

    @ApiOperation(value = "Return text message to show off successful call")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    ResponseEntity<?> getMessage() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("https://localhost:8222/client/", String.class);
        return ResponseEntity.ok("Server successfully called!");
    }

    @ApiOperation(value = "Return text message to show off successful call")
    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    ResponseEntity<?> getMessage1() {
        ResponseEntity<String> forEntity = restTemplate2.getForEntity("https://localhost:8222/client/", String.class);
        return ResponseEntity.ok("Server successfully called!");
    }
}
