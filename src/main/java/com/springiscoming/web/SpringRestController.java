package com.springiscoming.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class SpringRestController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getDefaultMessage() {
        return "REST Controller default message";
    }
}
