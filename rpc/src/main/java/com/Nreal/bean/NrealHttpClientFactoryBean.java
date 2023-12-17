package com.Nreal.bean;

import com.Nreal.proxy.NrealHttpClientProxy;
import org.springframework.beans.factory.FactoryBean;

public class NrealHttpClientFactoryBean<T> implements FactoryBean<T> {

    private Class<T> interfaceClass;

    @Override
    public T getObject() throws Exception {
        //返回一个代理实现类
        return new NrealHttpClientProxy().getProxy(interfaceClass);
    }

    //类型是接口
    @Override
    public Class<?> getObjectType() {
        return interfaceClass;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public Class<T> getInterfaceClass() {
        return interfaceClass;
    }

    public void setInterfaceClass(Class<T> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }
}