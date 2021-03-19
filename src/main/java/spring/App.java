package spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(scanBasePackages = "spring")
public class App {
  public static void main(String[] args) {
      ApplicationContext context = new AnnotationConfigApplicationContext("spring");
      Business business = (Business) context.getBean("Business");
      business.logic("Hello mf!");
  }
}
