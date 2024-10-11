package tobyspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tobyspring.hellospring.CachedExRateProvider;

@Configuration
//@ComponentScan
public class ObjectFactory {
    @Bean
    public PaymentService paymentService(){
        return new PaymentService(cachedExRateProvider());
    }
    @Bean
    public ExRateProvider cachedExRateProvider(){
        return new CachedExRateProvider(exRateProvider());
    }
//    @Bean
//    public OrderService orderService(){
//        return new OrderService(exRateProvider());
//    }
    @Bean
    public ExRateProvider exRateProvider() {
        return new WebApiExRateProvider();
    }
}
//class OrderService{
//    ExRateProvider exRateProvider;
//    public OrderService(ExRateProvider exRateProvider) {
//        this.exRateProvider = exRateProvider;
//    }
//}

