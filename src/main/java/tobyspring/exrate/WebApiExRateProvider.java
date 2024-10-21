package tobyspring.exrate;

import tobyspring.api.*;

import java.math.BigDecimal;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WebApiExRateProvider implements ExRateProvider {
    ApiTemplate apiTemplate = new ApiTemplate();

    @Override
    public BigDecimal getExRate(String currency) {

        String url = "https://open.er-api.com/v6/latest/" + currency;
        return apiTemplate.getExRate(url, new HttpClientApiExercutor(), new ExApiExRateExtractor());
        //System.out.println("API Exrate: " + data.rates().get("KRW"));
    }


}
