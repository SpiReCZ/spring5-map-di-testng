package test.autowiremap.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import test.autowiremap.service.MyServiceFactory;

import java.util.Map;

@Test
@ContextConfiguration(locations = {"classpath:context.xml"})
public class ServiceA3XmlTest extends AbstractTestNGSpringContextTests {
    @Autowired
    @Qualifier("xmlFactoryMap")
    private Map<String, Map<String, MyServiceFactory>> factoryGroupsXml;
    @Autowired
    @Qualifier("xmlFactoryMap")
    private Object factoryGroupsXmlObject;

    @Test
    public void factoryGroupsA_fails() {
        MyServiceFactory myServiceFactory = factoryGroupsXml.get("xmlGroup").get("xmlFactory");
        System.out.println(myServiceFactory);
    }

    @Test
    public void factoryGroupsA_working() {
        var factoryGroupsXmlObject = (Map<String, Map<String, MyServiceFactory>>) this.factoryGroupsXmlObject;
        MyServiceFactory myServiceFactory = factoryGroupsXmlObject.get("xmlGroup").get("xmlFactory");
        System.out.println(myServiceFactory);
    }
}