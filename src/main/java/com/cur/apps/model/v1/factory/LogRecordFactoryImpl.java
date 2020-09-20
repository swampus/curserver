package com.cur.apps.model.v1.factory;

import com.cur.apps.model.v1.LogRecord;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class LogRecordFactoryImpl implements LogRecordFactory {
    @Override
    public LogRecord createLogRecord(Date date, String method, String url, String requestJson,
                                     String requestIpV6, String message, String result) {
        return new LogRecord(date, method, url, requestJson, requestIpV6, message, result);
    }
}
