package tobyspring.payment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static java.math.BigDecimal.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PaymentServiceTest {
    Clock clock;
    @BeforeEach
    void beforeEach(){
        this.clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
    }
    @Test
    //@DisplayName("잘 충족")
    void convertedAmount() throws IOException {
        //준비
      testAmount(valueOf(500), valueOf(5_000), this.clock);
      testAmount(valueOf(1_000), valueOf(10_000), this.clock);
      testAmount(valueOf(3_000), valueOf(30_000), this.clock);
//        assertThat(payment.getValidUntil()).isAfter(LocalDateTime.now());
//        assertThat(payment.getValidUntil()).isBefore(LocalDateTime.now().plusMinutes(30));
    }
    @Test
    void validUntil() throws IOException {
        PaymentService paymentService = new PaymentService(new ExRateProviderStub(valueOf(1_000)),clock);
        Payment payment = paymentService.prepare(1L,"KRW", BigDecimal.TEN);
        LocalDateTime now = LocalDateTime.now(this.clock);
        LocalDateTime expectedValidUntil = now.plusMinutes(30);

         Assertions.assertThat(payment.getValidUntil()).isEqualTo(expectedValidUntil);
    }
    private static void testAmount(BigDecimal exRate, BigDecimal convertedAmount, Clock clock) throws IOException {
        PaymentService paymentService = new PaymentService(new ExRateProviderStub(exRate), clock);
        Payment payment = paymentService.prepare(1L, "KRW", BigDecimal.TEN);
        assertThat(payment.getExRate()).isEqualByComparingTo(exRate);
        assertThat(payment.getConvertedAmount()).isEqualTo(convertedAmount);
    }
}