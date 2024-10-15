package tobyspring.payment;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;

import static java.math.BigDecimal.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PaymentServiceTest {

    @Test
    //@DisplayName("잘 충족")
    void convertedAmount() throws IOException {
        //준비
      testAmount(valueOf(500), valueOf(5_000));
      testAmount(valueOf(1_000), valueOf(10_000));
      testAmount(valueOf(3_000), valueOf(30_000));


//        assertThat(payment.getValidUntil()).isAfter(LocalDateTime.now());
//        assertThat(payment.getValidUntil()).isBefore(LocalDateTime.now().plusMinutes(30));
    }

    private static void testAmount(BigDecimal exRate, BigDecimal convertedAmount) throws IOException {
        PaymentService paymentService = new PaymentService(new ExRateProviderStub(exRate));
        Payment payment = paymentService.prepare(1L, "KRW", BigDecimal.TEN);
        assertThat(payment.getExRate()).isEqualByComparingTo(exRate);
        assertThat(payment.getConvertedAmount()).isEqualTo(convertedAmount);
    }
}