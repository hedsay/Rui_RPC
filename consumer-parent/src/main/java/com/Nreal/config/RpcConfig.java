package com.Nreal.config;

import com.Nreal.annontation.EnableHttpClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableHttpClient(basePackage = "com.Nreal.rpc")
public class RpcConfig {
}
