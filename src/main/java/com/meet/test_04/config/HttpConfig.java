package com.meet.test_04.config;

import com.meet.test_04.RestClientNew;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.support.RestClientHttpServiceGroupConfigurer;
import org.springframework.web.service.registry.ImportHttpServices;

@Configuration // This config is used for RestClientNew client
@ImportHttpServices(types = {RestClientNew.class})
public class HttpConfig {

    @Bean
    RestClientHttpServiceGroupConfigurer groupConfigurer() {
        return groups -> {
            groups.forEachClient((group, builder) -> builder
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .build());
        };
    }
}
