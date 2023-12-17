package com.Nreal.rpc;

import com.Nreal.annontation.NrealHttpClient;
import com.Nreal.annontation.NrealMapping;
import com.Nreal.model.Goods;
import org.springframework.web.bind.annotation.PathVariable;

@NrealHttpClient(value = "goodsHttpRpc")
public interface GoodsHttpRpc {
    @NrealMapping(url="http://localhost:9527",api="/provider/goods/{id}")
    public Goods findGoods(@PathVariable Long id);
}
