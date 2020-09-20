package com.cur.apps.service;

import com.cur.apps.model.v1.LogRecord;

import java.util.List;

public interface AuditService {
    void addLogRecord(LogRecord logRecord);
    List<LogRecord> getLogRecords();
    List<LogRecord> getCurrencyRecordAccessLog(String url);
}
