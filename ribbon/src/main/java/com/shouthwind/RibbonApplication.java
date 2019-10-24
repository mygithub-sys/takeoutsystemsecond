package com.shouthwind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RibbonApplication{
    public static void main(String[] args){
        SpringApplication.run(RibbonApplication.class,args);
    }

    //使用RestTemplate调用服务提供者的服务
    @Bean  //注入到IOC容器中
    @LoadBalanced  //提供负载均衡功能
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
