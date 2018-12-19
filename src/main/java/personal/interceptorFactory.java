package personal;

import org.aspectj.weaver.patterns.AnnotationPointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import personal.Annotation.Intercept;
import personal.Annotation.Proxy;

/**
 * created by schaud3
 * created on 12/18/18
 */
@Component
public class interceptorFactory  implements BeanPostProcessor {

    @Autowired
    ApplicationContext applicationContext;

    Pointcut pointcut = new AnnotationMatchingPointcut(null,Intercept.class,Boolean.TRUE);


    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> targetClass = AopUtils.getTargetClass(bean);
        Proxy proxy = targetClass.getAnnotation(Proxy.class);
        if(proxy !=null){
            String value = proxy.context();
            interCeptor interCeptor = new interCeptor();
            interCeptor.setContext(value);

            PointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, interCeptor);

            if (bean instanceof Advised){
                ((Advised) bean).addAdvisor(0,advisor);
                return bean;
            }

            ProxyFactory proxyFactoryBean = new ProxyFactory();
            proxyFactoryBean.setTarget(bean);
            proxyFactoryBean.addAdvisor(advisor);
            return proxyFactoryBean.getProxy();
        }
        return bean;
    }

}
