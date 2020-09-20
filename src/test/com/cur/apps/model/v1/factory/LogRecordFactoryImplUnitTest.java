package com.cur.apps.model.v1.factory;


import com.cur.apps.model.v1.LogRecord;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class LogRecordFactoryImplUnitTest {

    private LogRecordFactoryImpl logRecordFactory = new LogRecordFactoryImpl();

    @Test
    public void createLogRecord() {
        Date date = new Date();
        String method = "m";
        String url = "u";
        String requestJson = "r";
        String requestIpV6 = "re";
        String message = "me";
        String result = "res";
        LogRecord logRecord = logRecordFactory
                .createLogRecord(date, method, url, requestJson, requestIpV6, message, result);

        assertEquals(date, logRecord.getDate());
        assertEquals("m", logRecord.getMethod());
        assertEquals("u", logRecord.getUrl());
        assertEquals("r", logRecord.getRequestJson());
        assertEquals("re", logRecord.getRequestIpV6());
        assertEquals("me", logRecord.getMessage());
        assertEquals("res", logRecord.getResult());
    }
}