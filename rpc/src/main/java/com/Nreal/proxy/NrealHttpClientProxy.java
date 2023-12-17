package com.Nreal.proxy;

import com.Nreal.annontation.NrealMapping;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NrealHttpClientProxy implements InvocationHandler {

    public NrealHttpClientProxy(){

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        NrealMapping annotation = method.getAnnotation(NrealMapping.class);
        if (annotation != null){
            String url = annotation.url();
            // /provide/goods/{id}
            String api = annotation.api();
            Pattern compile = Pattern.compile("(\\{\\w+})");
            Matcher matcher = compile.matcher(api);
            if (matcher.find()){
                //简单判断一下 代表有路径参数需要替换
                int groupCount = matcher.groupCount();
                for (int i=0;i<groupCount;i++){
                    String group = matcher.group(i);
                    api = api.replace(group,args[i].toString());
                }
            }
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(url+api,method.getReturnType());
        }
        return null;
    }

    public <T> T getProxy(Class<T> interfaceClass) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(),new Class<?>[]{interfaceClass},this);
    }

    public static void main(String[] args) {
        Pattern compile = Pattern.compile("(\\{\\w+})");
        Matcher matcher = compile.matcher("test/test/{id}");
        System.out.println(matcher.find());
    }

}