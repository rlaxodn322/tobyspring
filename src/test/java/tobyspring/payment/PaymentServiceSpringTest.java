package tobyspring.payment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tobyspring.TestPaymentConfig;

import java.io.IOException;
import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class) // 둘이 한쌍
@ContextConfiguration(classes = TestPaymentConfig.class) // 둘이 한쌍
class PaymentServiceSpringTest {
    //@Autowired BeanFactory beanFactory;
    @Autowired PaymentService paymentService;
    @Autowired ExRateProviderStub exRateProviderStub;

    @Test
    //@DisplayName("잘 충족")
    void convertedAmount() throws IOException {
        //PaymentService paymentService = beanFactory.getBean(PaymentService.class);
        //exRate: 1000
        Payment payment = paymentService.prepare(1L, "KRW", BigDecimal.TEN);
        assertThat(payment.getExRate()).isEqualByComparingTo(valueOf(1_000));
        assertThat(payment.getConvertedAmount()).isEqualTo(valueOf(10_000));
        //500
        exRateProviderStub.setExRate(valueOf(500));
        Payment payment1 = paymentService.prepare(1L, "KRW", BigDecimal.TEN);
        assertThat(payment1.getExRate()).isEqualByComparingTo(valueOf(500));
        assertThat(payment1.getConvertedAmount()).isEqualTo(valueOf(5_000));
//        assertThat(payment.getValidUntil()).isAfter(LocalDateTime.now());
//        assertThat(payment.getValidUntil()).isBefore(LocalDateTime.now().plusMinutes(30));
    }


}