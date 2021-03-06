package test.autowiremap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class AutowireMapApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutowireMapApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void test() {
        System.out.println("hello world, I have just started up");
    }

}
