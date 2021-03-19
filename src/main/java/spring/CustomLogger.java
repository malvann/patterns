package spring;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CustomLogger implements EventLogger{
    String id = UUID.randomUUID().toString();

    public void logEvent(String msg){
            System.out.println(msg + " (" + id + ")");
    }
}
