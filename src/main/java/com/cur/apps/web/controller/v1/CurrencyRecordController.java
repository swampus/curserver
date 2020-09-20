package com.cur.apps.web.controller.v1;

import com.cur.apps.dto.request.GetCurrencyRecordRequest;
import com.cur.apps.dto.response.CurrencyRecordDtoResponse;
import com.cur.apps.service.CurrencyRecordService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rest/v1/CurrencyRecord.svc")
public class CurrencyRecordController {

    public static final String CURRENCY_RECORD_CODE = "/currencyRecord/code";

    @Autowired
    private MapperFacade mapperFacade;

    @Autowired
    private CurrencyRecordService currencyRecordService;

    @PostMapping(CURRENCY_RECORD_CODE)
    public CurrencyRecordDtoResponse getCurrencyCode(@RequestBody GetCurrencyRecordRequest getCurrencyRecordRequest) {
        return mapperFacade.map(currencyRecordService.getByCode(getCurrencyRecordRequest.getCode()),
                CurrencyRecordDtoResponse.class);
    }

}
