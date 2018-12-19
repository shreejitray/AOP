package personal;

import personal.Annotation.Intercept;
import personal.Annotation.Proxy;

/**
 * created by schaud3
 * created on 12/19/18
 */
@Proxy(context = "Supplier 2")
public class Supplier2 {

    private String name;

    private String lastName;


    @Intercept(value = "Chaudhury")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
