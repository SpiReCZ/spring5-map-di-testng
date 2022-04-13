package test.autowiremap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.autowiremap.service.MyServiceFactory;

import java.util.Map;

@Configuration
public class TestConfiguration {

    @Bean("factoryGroupsA")
    public Map<String, Map<String, MyServiceFactory>> factoryGroupsA() {
        return Map.of("myA", Map.of("myFactory", new MyServiceFactory()));
    }

    @Bean("factoryGroupsB")
    public Map<String, Map<String, MyServiceFactory>> factoryGroupsB() {
        return Map.of("myB", Map.of("myFactory", new MyServiceFactory()));
    }
}
