package com.meet.test_04.config;

import com.meet.test_04.RestTemplateNew;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.support.RestClientHttpServiceGroupConfigurer;
import org.springframework.web.service.registry.ImportHttpServices;

@Configuration // This config is used for RestTemplateNew client
@ImportHttpServices(types = { RestTemplateNew.class })
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
