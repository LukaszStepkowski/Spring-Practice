package pl.sda.shopapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestNoSpring {

    @Test
    void Test(){
        Assertions.assertEquals(1, 1);

        BeanB b = new BeanB(new BeanA(), new BeanC());
        b.sayHello();
    }
}
