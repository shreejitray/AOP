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
        System.out.println("Printing name Supplier 1");
        System.out.println(supplier.getName());

        System.out.println("Printing Last name Supplier 1");
        System.out.println(supplier.getLastName());

        Supplier2 supplier2 = classPathXmlApplicationContext.getBean("supplier2",Supplier2.class);
        System.out.println("Printing name Supplier 2");
        System.out.println(supplier2.getName());

        System.out.println("Printing last name Supplier 2");
        System.out.println(supplier2.getLastName());
    }
}
