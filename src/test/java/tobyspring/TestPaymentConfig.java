package tobyspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tobyspring.exrate.ExRateProvider;
import tobyspring.payment.ExRateProviderStub;
import tobyspring.payment.PaymentService;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

@Configuration
//@ComponentScan
public class TestPaymentConfig {
    @Bean
    public PaymentService paymentService(){
        return new PaymentService(exRateProvider(), clock());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new ExRateProviderStub(BigDecimal.valueOf(1_000));
    }
    @Bean
    public Clock clock(){
        return Clock.fixed(Instant.now() , ZoneId.systemDefault());
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

