package com.Nreal.service.impl;

import com.Nreal.model.Goods;
import com.Nreal.service.GoodsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Value("${server.port}")
    private int port;
    @Override
    public Goods findGoods(Long id) {
        return new Goods(id,"服务提供方商品：" + port, BigDecimal.valueOf(100));
    }
}