package test.autowiremap.test;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import test.autowiremap.service.MyServiceFactory;

import java.util.Map;

@Service
public class ServiceA implements InitializingBean {

    private final Map<String, Map<String, MyServiceFactory>> factoryGroupsA;

    public ServiceA(@Qualifier("factoryGroupsA") Map<String, Map<String, MyServiceFactory>> factoryGroupsA) {
        this.factoryGroupsA = factoryGroupsA;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        MyServiceFactory myServiceFactory = factoryGroupsA.get("myA").get("myFactory");
        System.out.println(myServiceFactory);
    }
}
