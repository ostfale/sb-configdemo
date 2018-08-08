package de.ostfale.spring.configdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.PrintStream;

/**
 * Service class
 * Created :  08.08.2018
 *
 * @author : Uwe Sauerbrei
 */
@Service
public class ExampleService {

    private final String someValue;
    private final ExampleProperties exampleProperties;

    public ExampleService(@Value("${someValue:-1}") String someValue, ExampleProperties exampleProperties) {
        this.someValue = someValue;
        this.exampleProperties = exampleProperties;
    }

    public void printConfiguration(final PrintStream printWriter) {
        printWriter.println("someValue=" + this.someValue);
        printWriter.println("exampleProperties=" + this.exampleProperties);
    }
}
