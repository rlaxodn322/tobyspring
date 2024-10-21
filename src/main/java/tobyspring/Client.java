package tobyspring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import tobyspring.payment.Payment;
import tobyspring.payment.PaymentService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(PaymentConfig.class);
        PaymentService paymentService = beanFactory.getBean(PaymentService.class);
//        OrderService orderService = beanFactory.getBean(OrderService.class);
//        System.out.println(paymentService.exRateProvider == orderService.exRateProvider);


        Payment payment1 = paymentService.prepare(100L, "USD", BigDecimal.valueOf(51.2));
        System.out.println("Payment:" + payment1);
//        System.out.println("Payment1 : " + payment1);
//        TimeUnit.SECONDS.sleep(1);
//        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//        Payment payment2 = paymentService.prepare(100L, "USD", BigDecimal.valueOf(51.2));
//        System.out.println("Payment2 : " + payment2 );
//        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//        TimeUnit.SECONDS.sleep(3);
//        Payment payment3 = paymentService.prepare(100L, "USD", BigDecimal.valueOf(51.2));
//        System.out.println("Payment3 : " + payment3);
    }
}


