package com.cur.apps.web.controller.v1;

import com.cur.apps.dto.request.GetCurrencyRecordRequest;
import com.cur.apps.dto.response.CurrencyRecordDtoResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CurrencyRecordControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getCurrencyCode() {
        GetCurrencyRecordRequest getCurrencyRecordRequest = new GetCurrencyRecordRequest();
        getCurrencyRecordRequest.setCode("USD");

        CurrencyRecordDtoResponse response = this.restTemplate.postForObject("http://localhost:" + port
                        + "/api/rest/v1/CurrencyRecord.svc/currencyRecord/code",
                getCurrencyRecordRequest, CurrencyRecordDtoResponse.class);

        assertEquals("USD", response.getCode());
        assertEquals("United States dollar", response.getCurrency());
        assertEquals("840", response.getNum());
        assertEquals(Integer.valueOf(2), response.getNumberOfDigits());

        getCurrencyRecordRequest.setCode("EUR");
        response = this.restTemplate.postForObject("http://localhost:" + port
                        + "/api/rest/v1/CurrencyRecord.svc/currencyRecord/code",
                getCurrencyRecordRequest, CurrencyRecordDtoResponse.class);

        assertEquals("EUR", response.getCode());
        assertEquals("Euro", response.getCurrency());
        assertEquals("978", response.getNum());
        assertEquals(Integer.valueOf(2), response.getNumberOfDigits());
    }
}