package com.cur.apps.service;

import com.cur.apps.model.v1.CurrencyRecord;
import com.cur.apps.repository.CurrencyRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrencyRecordServiceImpl implements CurrencyRecordService {

    @Autowired
    private CurrencyRecordRepository currencyRecordRepository;

    @Override
    public CurrencyRecord getByCode(String currencyCode) {
        return currencyRecordRepository.findByCode(currencyCode);
    }

    @Override
    public CurrencyRecord addCurrencyRecord(CurrencyRecord currencyRecord) {
        return currencyRecordRepository.save(currencyRecord);
    }
}
