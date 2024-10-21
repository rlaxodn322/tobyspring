package tobyspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tobyspring.api.ApiTemplate;
import tobyspring.api.ErApiExtractor;
import tobyspring.api.SimpleApiExecutor;
import tobyspring.exrate.CachedExRateProvider;
import tobyspring.exrate.ExRateProvider;
import tobyspring.exrate.SimpleExRateProvider;
import tobyspring.exrate.WebApiExRateProvider;
import tobyspring.payment.PaymentService;

import java.time.Clock;


@Configuration
//@ComponentScan
public class PaymentConfig {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider(), clock());
    }

    @Bean
    public ApiTemplate apiTemplate(){
        return new ApiTemplate(new SimpleApiExecutor(), new ErApiExtractor());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new WebApiExRateProvider(apiTemplate());
    }

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }
}


//    @Bean
//    public ExRateProvider cachedExRateProvider(){
//        return new CachedExRateProvider(exRateProvider());
//    }
//    @Bean
//    public OrderService orderService(){
//        return new OrderService(exRateProvider());
//    }
//class OrderService{
//    ExRateProvider exRateProvider;
//    public OrderService(ExRateProvider exRateProvider) {
//        this.exRateProvider = exRateProvider;
//    }
//}

