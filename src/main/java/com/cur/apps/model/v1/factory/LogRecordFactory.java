package com.cur.apps.model.v1.factory;

import com.cur.apps.model.v1.LogRecord;

import java.util.Date;


public interface LogRecordFactory {
    LogRecord createLogRecord(Date date, String method, String url,
                              String requestJson, String requestIpV6, String message,
                              String result);

}
