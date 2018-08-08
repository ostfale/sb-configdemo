package de.ostfale.spring.configdemo;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static de.ostfale.spring.configdemo.ApplicationConfig.BarProperties;
import static de.ostfale.spring.configdemo.ApplicationConfig.FooProperties;

/**
 * Configuration class
 * Created :  08.08.2018
 *
 * @author : Uwe Sauerbrei
 */
@Configuration
@EnableConfigurationProperties({BarProperties.class, FooProperties.class})
public class ApplicationConfig {

    @ConfigurationProperties("bar")
    public static class BarProperties {

        private String otherValue;

        public String getOtherValue() {
            return otherValue;
        }

        public void setOtherValue(String otherValue) {
            this.otherValue = otherValue;
        }
    }

    @ConfigurationProperties("foo")
    public static class FooProperties {

        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class FooService {

        final String name;

        public FooService(String name) {
            this.name = name;
        }

        public void myInit() {
        }

        public void destroy() {
        }
    }

    public static class BarService {

        final FooService fooService;

        final Integer interval;

        public BarService(
                FooService fooService,
                Integer interval
        ) {
            this.fooService = fooService;
            this.interval = interval;
        }

        public void close() {
            System.out.println("close");
        }
    }

    public static class FactoredService {
    }

    private final FooProperties fooProperties;

    public ApplicationConfig(
            FooProperties fooProperties
    ) {
        this.fooProperties = fooProperties;
    }

    @Bean(
            name = "myFooService",
            initMethod = "myInit",
            destroyMethod = "destroy"
    )
    public FooService fooService() {
        return new FooService(fooProperties.getValue());
    }

    @Bean(destroyMethod = "")
    public BarService barService(
            ExampleProperties exampleProperties
    ) {
        return new BarService(
                fooService(),
                exampleProperties.getInterval()
        );
    }

    @Bean
    public FactoryBean<FactoredService> factoredService() {
        return new FactoryBean<FactoredService>() {
            final FactoredService factoredService = new FactoredService();

            @Override
            public FactoredService getObject() throws Exception {
                return factoredService;
            }

            @Override
            public Class<?> getObjectType() {
                return FactoredService.class;
            }

            @Override
            public boolean isSingleton() {
                return true;
            }
        };
    }
}
