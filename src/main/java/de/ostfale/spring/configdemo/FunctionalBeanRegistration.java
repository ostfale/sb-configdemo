package de.ostfale.spring.configdemo;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

/**
 * <description>
 * Created :  08.08.2018
 *
 * @author : Uwe Sauerbrei
 */
public class FunctionalBeanRegistration implements ApplicationContextInitializer<GenericApplicationContext> {

    @Override
    public void initialize(GenericApplicationContext genericApplicationContext) {
        genericApplicationContext.registerBean(Greeter.class, Greeter::new);

    }
}
