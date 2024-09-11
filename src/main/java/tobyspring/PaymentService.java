package tobyspring;
//Crtl+ ALT + O import 정리
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

 public class PaymentService {
    public Payment prepare(Long orderId,
                           String currency,
                           BigDecimal foreignCurrencyAmount) throws IOException {
        WebApiExRateProvider exRateProvider = new WebApiExRateProvider();
        BigDecimal exRate = exRateProvider.getWebExRate(currency);
        // 금액 계산
        BigDecimal convertedAmount = foreignCurrencyAmount.multiply(exRate);
        // 유효 시간 계산
        LocalDateTime validUntil = LocalDateTime.now().plusMinutes(30);
        return new Payment(orderId, currency, foreignCurrencyAmount, exRate, convertedAmount, validUntil);

    }


}
