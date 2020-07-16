package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SystemTestConfig {
    @Bean
    public SystemTestConfig systemTestConfig(SystemTestConfig systemTestConfig){
        return new SystemTestConfig();
    }
}
