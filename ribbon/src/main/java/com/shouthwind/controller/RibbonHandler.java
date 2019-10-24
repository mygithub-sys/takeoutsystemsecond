package com.shouthwind.controller;

import com.shouthwind.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/ribbon")
public class RibbonHandler {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return restTemplate.getForObject("http://provider/student/findAll",Collection.class);
        //"http://localhost:8010/student/..."已经在注册中心注册，
        // 顾可以直接使用服务提供者在配置文件application。yml中的
        // application.name：provider,可以替代当前服务提供者的网络地址
    }
    @GetMapping("/index")
    public  String index(){
        return restTemplate.getForObject("http://provider/student/index",String.class);
    }
}
