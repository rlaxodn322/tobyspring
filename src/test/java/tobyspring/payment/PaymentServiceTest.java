package tobyspring.payment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tobyspring.exrate.WebApiExRateProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PaymentServiceTest {

    @Test
    //@DisplayName("잘 충족")
    void prepare() throws IOException {
        //준비
        PaymentService paymentService = new PaymentService(new WebApiExRateProvider());
        Payment payment = paymentService.prepare(1L, "KRW", BigDecimal.TEN);
        //환율 정보 가져온다
        Assertions.assertThat(payment.getExRate()).isNotNull();
        //원화환산금액 계산
        Assertions.assertThat(payment.getForeignCurrencyAmount()).isEqualTo(payment.getExRate().multiply(payment.getForeignCurrencyAmount()));
        //원화환산금액의 유효시간
        assertThat(payment.getValidUntil()).isAfter(LocalDateTime.now());
        assertThat(payment.getValidUntil()).isBefore(LocalDateTime.now().plusMinutes(30));
    }
}