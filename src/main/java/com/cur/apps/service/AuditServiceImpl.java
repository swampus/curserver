package com.cur.apps.service;

import com.cur.apps.model.v1.LogRecord;
import com.cur.apps.repository.LogRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuditServiceImpl implements AuditService {

    @Autowired
    private LogRecordRepository logRecordRepository;

    @Override
    public void addLogRecord(LogRecord logRecord) {
        logRecordRepository.save(logRecord);
    }

    @Override
    public List<LogRecord> getLogRecords() {
        return logRecordRepository.findAll();
    }

    @Override
    public List<LogRecord> getCurrencyRecordAccessLog(String url) {
        return logRecordRepository.findAllByUrlContains(url);
    }
}
