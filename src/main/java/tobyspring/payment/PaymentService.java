package tobyspring.payment;
//Crtl+ ALT + O import 정리

import tobyspring.exrate.ExRateProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;

//@Component
public class PaymentService {
    private final ExRateProvider exRateProvider;
    private final Clock clock;

    //Alt + Insert 생성자
    public PaymentService(ExRateProvider exRateProvider
            , Clock clock) {
        this.exRateProvider = exRateProvider;
        this.clock = clock;
    }

    public Payment prepare(Long orderId,
                           String currency,
                           BigDecimal foreignCurrencyAmount) {

        BigDecimal exRate = exRateProvider.getExRate(currency);

        return Payment.createPrepared(orderId, currency, foreignCurrencyAmount, exRate, LocalDateTime.now(clock));

    }


}
