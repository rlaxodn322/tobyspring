package tobyspring.hellospring;

import tobyspring.ExRateProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CachedExRateProvider implements ExRateProvider {
    private final ExRateProvider target;
    private BigDecimal cachedExRate;
    private LocalDateTime cacheExpiryTime;


    public CachedExRateProvider(ExRateProvider target) {
        this.target = target;
    }

    @Override
    public BigDecimal getExRate(String currency) throws IOException {
        if(cachedExRate == null || cacheExpiryTime.isBefore(LocalDateTime.now())){
            cachedExRate = this.target.getExRate(currency);
            cacheExpiryTime = LocalDateTime.now().plusMinutes(3);

            System.out.println("Cached Updated");
        }
        return cachedExRate;
    }
}
