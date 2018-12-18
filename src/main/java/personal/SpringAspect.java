package personal;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * created by schaud3
 * created on 12/18/18
 */
@Aspect
public class SpringAspect {
    @Before("execution(* personal.Supplier.*())")
    public void beforeAdvice(){
        System.out.println("Before advice");
    }

    @AfterReturning(pointcut = "execution(* personal.Supplier.*())", returning = "name")
    public void afterAdvice(String name){
        System.out.println("The name returned is "+name);
    }
}
