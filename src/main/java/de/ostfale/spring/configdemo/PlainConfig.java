package de.ostfale.spring.configdemo;

import org.springframework.context.annotation.Bean;

/**
 * Simple configuration class
 * Created :  08.08.2018
 *
 * @author : Uwe Sauerbrei
 */
public class PlainConfig {

    public static class PlainPojo {
    }

    @Bean
    public PlainPojo plainPojo() {
        return new PlainPojo();
    }
}
