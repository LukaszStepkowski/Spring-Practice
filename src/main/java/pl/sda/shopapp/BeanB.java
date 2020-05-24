package pl.sda.shopapp;

import org.springframework.stereotype.Component;

@Component
public class BeanB {

    private final BeanA beanA;
    private final BeanC beanC;

    BeanB(BeanA beanA, BeanC beanC){
        this.beanA = beanA;
        this.beanC = beanC;
    }

    void sayHello() {
        System.out.println("I'm in BeanB");
        System.out.println("I'm invoking Bean A");
        beanA.sayHello();
        beanC.whoIAm();
    }

//    public void setBeanC(BeanC beanC) {
//        this.beanC = beanC;
//    }
}
