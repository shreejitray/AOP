package personal;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import personal.Annotation.Intercept;

/**
 * created by schaud3
 * created on 12/18/18
 */
@Component
@Scope("prototype")
public class interCeptor implements MethodInterceptor {
    private String context;
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Intercept intercept = methodInvocation.getMethod().getDeclaredAnnotation(Intercept.class);
        if(intercept!=null) {
            System.out.println("inside interceptor, context is " + context + " intercept value " + intercept.value());
        }else{
            System.out.println("Pointcut filter worked");
        }
        return methodInvocation.proceed();
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
