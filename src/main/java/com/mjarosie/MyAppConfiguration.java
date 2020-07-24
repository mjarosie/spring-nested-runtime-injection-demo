package com.mjarosie;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyAppConfiguration {
    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public MyAuthService createMyAuthService(String environment, String clientId, String clientSecret) {
        return new MyAuthService(environment, clientId, clientSecret);
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public MyService createMyService(String environment, String clientId, String clientSecret) {
        MyAuthService myAuthService = createMyAuthService(environment, clientId, clientSecret);
        return new MyService(myAuthService, environment);
    }

}
