package com.example.controller;

import com.example.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.client.IServiceHello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    IServiceHello serviceHello;
    
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHi( HttpServletRequest request, HttpServletResponse response){
        logger.info("Hello controller");
        User user  = new User();
        user.setName(request.getParameter("name"));
        return serviceHello.sayHello(user);
    }
}
