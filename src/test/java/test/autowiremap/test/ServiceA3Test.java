package test.autowiremap.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import test.autowiremap.service.MyServiceFactory;

import java.util.Map;

@Test
@SpringBootTest
public class ServiceA3Test extends AbstractTestNGSpringContextTests {
    @Autowired
    @Qualifier("factoryGroupsA")
    private Map<String, Map<String, MyServiceFactory>> factoryGroupsXml;
    @Autowired
    @Qualifier("factoryGroupsA")
    private Object factoryGroupsXmlObject;

    @Test
    public void factoryGroupsA_working() {
        MyServiceFactory myServiceFactory = factoryGroupsXml.get("myA").get("myFactory");
        System.out.println(myServiceFactory);
    }

    @Test
    public void factoryGroupsA_working2() {
        var factoryGroupsXmlObject = (Map<String, Map<String, MyServiceFactory>>) this.factoryGroupsXmlObject;
        MyServiceFactory myServiceFactory = factoryGroupsXmlObject.get("myA").get("myFactory");
        System.out.println(myServiceFactory);
    }
}