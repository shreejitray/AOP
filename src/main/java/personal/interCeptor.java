package personal;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * created by schaud3
 * created on 12/18/18
 */
@Component
public class interCeptor implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("inside interceptor");
        return methodInvocation.proceed();
    }
}
