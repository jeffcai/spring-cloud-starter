package com.jeffcaijf.microservice.practices.springcloud.service.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by IntelliJ IDEA.
 * User: duqi
 * Date: 2017/3/2
 * Time: 22:58
 */
@RestController
public class ConsumerController {

    @Autowired
    private LoadBalancerClient loadBalancer;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/add")
    public String add() {
        ServiceInstance instance = loadBalancer.choose("COMPUTE-SERVICE");
        String url = String.format("http://%s:%s", instance.getHost(), instance.getPort());
        return restTemplate.getForObject("http://COMPUTE-SERVICE/add?a=10&b=20", String.class);
    }

}
