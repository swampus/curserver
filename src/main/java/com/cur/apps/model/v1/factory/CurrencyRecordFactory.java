package com.cur.apps.model.v1.factory;

import com.cur.apps.model.v1.CurrencyRecord;

public interface CurrencyRecordFactory {
    CurrencyRecord createCurrencyRecord(String curCode, String num, Integer numberOfDigits, String currency);
}
