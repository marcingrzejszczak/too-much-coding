package pl.grzejszczak.marcin.drools.springintegration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.grzejszczak.marcin.drools.springintegration.service.ProductService;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 14.01.13
 */
public class DroolsSpring {

    public static void main(String args[]){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ((ProductService)applicationContext.getBean("ProductServiceImpl")).runProductLogic();
        ((ProductService)applicationContext.getBean("NoRulesProductServiceImpl")).runProductLogic();

    }
}
