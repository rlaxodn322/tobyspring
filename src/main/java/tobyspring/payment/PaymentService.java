package tobyspring.payment;
//Crtl+ ALT + O import 정리
import tobyspring.exrate.ExRateProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
//@Component
 public class PaymentService {
     ExRateProvider exRateProvider;

     //Alt + Insert 생성자
     public PaymentService(ExRateProvider exRateProvider
     ) {
         this.exRateProvider =  exRateProvider;
     }

     public Payment prepare(Long orderId,
                            String currency,
                            BigDecimal foreignCurrencyAmount) throws IOException {

        BigDecimal exRate = exRateProvider.getExRate(currency);
        // 금액 계산
        BigDecimal convertedAmount = foreignCurrencyAmount.multiply(exRate);
        // 유효 시간 계산
        LocalDateTime validUntil = LocalDateTime.now().plusMinutes(30);

        return new Payment(orderId, currency, foreignCurrencyAmount, exRate, convertedAmount, validUntil);

    }


}
