package com.cur.apps.web.controller.v1;

import com.cur.apps.dto.response.LogRecordDtoResponse;
import com.cur.apps.model.v1.LogRecord;
import com.cur.apps.service.AuditService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.cur.apps.web.controller.v1.CurrencyRecordController.CURRENCY_RECORD_CODE;

@RestController
@RequestMapping("/api/rest/v1/LogRecord.svc")
public class AuditController {

    @Autowired
    private MapperFacade mapperFacade;

    @Autowired
    private AuditService auditService;

    @GetMapping("/logrecords")
    public List<LogRecordDtoResponse> getLogs() {
        return auditService.getLogRecords().stream()
                .map((LogRecord logRecord) -> mapperFacade.map(logRecord, LogRecordDtoResponse.class)
                ).collect(Collectors.toList());
    }


    @GetMapping("/log")
    public List<LogRecordDtoResponse> currencyRecordAccessLogs() {
        return auditService.getCurrencyRecordAccessLog("/api/rest/v1/CurrencyRecord.svc"
                + CURRENCY_RECORD_CODE).stream()
                .map((LogRecord logRecord) -> mapperFacade.map(logRecord, LogRecordDtoResponse.class)
                ).collect(Collectors.toList());
    }
}
