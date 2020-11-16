package com.safa.webservices.Web.Service.Helloworld;


import com.safa.webservices.Web.Service.Helloworld.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean(new String[]{"Hello World Bean","Hello World Bean 2","Hello World Bean 3"});
    }

}
