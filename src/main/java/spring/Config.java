package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.UUID;

@Configuration
public class Config {

    @Bean
    @Scope(value = "prototype")
    public Client getNew(){
        return new Client(UUID.randomUUID().toString(), "Jone Doe");
    }

    @Bean
    public CustomLogger getLogger(){
        return new CustomLogger();
    }
}
