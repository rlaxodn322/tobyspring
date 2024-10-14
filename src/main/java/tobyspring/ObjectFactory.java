package tobyspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tobyspring.exrate.CachedExRateProvider;
import tobyspring.exrate.ExRateProvider;
import tobyspring.exrate.SimpleExRateProvider;
import tobyspring.exrate.WebApiExRateProvider;
import tobyspring.payment.PaymentService;

@Configuration
//@ComponentScan
public class ObjectFactory {
    @Bean
    public PaymentService paymentService(){
        return new PaymentService(exRateProvider());
    }
//    @Bean
//    public ExRateProvider cachedExRateProvider(){
//        return new CachedExRateProvider(exRateProvider());
//    }
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

