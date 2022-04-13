package test.autowiremap.test;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import test.autowiremap.service.MyServiceFactory;

import java.util.Map;

@Service
public class ServiceA2 implements InitializingBean {

    @Autowired
    @Qualifier("factoryGroupsA")
    private Map<String, Map<String, MyServiceFactory>> factoryGroupsA;

    @Override
    public void afterPropertiesSet() throws Exception {
        MyServiceFactory myServiceFactory = factoryGroupsA.get("myA").get("myFactory");
        System.out.println(myServiceFactory);
    }
}
