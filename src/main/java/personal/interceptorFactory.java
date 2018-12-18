package personal;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * created by schaud3
 * created on 12/18/18
 */
@Component
public class interceptorFactory  implements BeanPostProcessor {
    @Autowired
    interCeptor interCeptor;

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if("supplier".equals(beanName)){
            ProxyFactory proxyFactoryBean = new ProxyFactory();
            proxyFactoryBean.setTarget(bean);
            proxyFactoryBean.addAdvice(interCeptor);
            return proxyFactoryBean.getProxy();
        }
        return bean;
    }

}
