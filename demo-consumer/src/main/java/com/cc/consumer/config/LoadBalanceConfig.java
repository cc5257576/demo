package com.cc.consumer.config;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/8/31 11:42
 * Description:
 */
@Configuration
public class LoadBalanceConfig {

    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
