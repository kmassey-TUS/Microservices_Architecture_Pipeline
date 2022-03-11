package com.tus.game;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringFoxConfig {

	@Bean
	public GroupedOpenApi api(){
        return GroupedOpenApi.builder()
            .pathsToMatch("/**")
            .group("game")
            .build();
}
}