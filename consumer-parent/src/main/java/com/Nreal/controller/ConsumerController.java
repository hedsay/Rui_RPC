package com.Nreal.controller;

import com.Nreal.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/find/{id}")
    public Goods find(@PathVariable Long id){
        ResponseEntity<Goods> forEntity = restTemplate.getForEntity("http://localhost:9527/provider/goods/1", Goods.class);
        if (forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }
        return null;
    }
}