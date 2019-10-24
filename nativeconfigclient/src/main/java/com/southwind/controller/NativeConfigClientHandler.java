package com.southwind.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/native")
public class NativeConfigClientHandler {

    @Value("${server.port}")
    private String port; //来自于配置中心的server.port

    @Value("${foo}")
    private String foo;//来自于配置中心的server.foo

    @GetMapping("/index")
 public String index(){
return this.port+"-"+this.foo;
 }

}
