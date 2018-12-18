package personal;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * created by schaud3
 * created on 12/18/18
 */
public class MainClass {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Supplier supplier = classPathXmlApplicationContext.getBean("supplier",Supplier.class);
        System.out.println("Printing name");
        System.out.println(supplier.getName());
    }
}
