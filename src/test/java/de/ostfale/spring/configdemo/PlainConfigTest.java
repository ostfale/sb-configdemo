package de.ostfale.spring.configdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Test for {@link PlainConfigTest}
 * Created :  08.08.2018
 *
 * @author : Uwe Sauerbrei
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlainConfigTest {

    @Autowired
    PlainConfig.PlainPojo plainPojo;

    @Configuration
    @Import(PlainConfig.class)
    static class TestConfig {
    }

    @Test
    public void plainPojoShouldBeThere() {
        assertNotNull(plainPojo);
    }
}