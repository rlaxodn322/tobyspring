package tobyspring.exrate;

import java.io.IOException;
import java.math.BigDecimal;
//@Component
public class SimpleExRateProvider implements ExRateProvider{
    @Override
    public BigDecimal getExRate(String currency)  {
        if(currency.equals("USD")) return BigDecimal.valueOf(1000);

        throw new IllegalArgumentException("지원하지 않는 통화입니다.");
    }
}
