package personal;

import personal.Annotation.Intercept;
import personal.Annotation.Proxy;

/**
 * created by schaud3
 * created on 12/18/18
 */
@Proxy(context = "Class level")
public class Supplier {
    private String name;
    private String lastName;

    public String getName() {
        return name;
    }

    @Intercept(value = "Ray")
    public String getLastName() { return lastName; }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }
}
