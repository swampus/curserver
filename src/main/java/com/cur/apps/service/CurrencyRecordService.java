package com.cur.apps.service;

import com.cur.apps.model.v1.CurrencyRecord;

public interface CurrencyRecordService {
    CurrencyRecord getByCode(String currencyCode);
    CurrencyRecord addCurrencyRecord(CurrencyRecord currencyRecord);
}
