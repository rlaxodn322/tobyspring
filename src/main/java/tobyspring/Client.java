package tobyspring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.math.BigDecimal;

public class Client {
    public static void main(String[] args) throws IOException {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(ObjectFactory.class);
        PaymentService paymentService = beanFactory.getBean(PaymentService.class);
        PaymentService paymentService1 = beanFactory.getBean(PaymentService.class);
        System.out.println(paymentService1);
        System.out.println(paymentService);
        System.out.println(paymentService1==paymentService);
        Payment payment = paymentService.prepare(100L, "USD", BigDecimal.valueOf(51.2));

        System.out.println(payment);
    }
}


