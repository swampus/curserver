package com.cur.apps.model.v1.factory;

import com.cur.apps.model.v1.CurrencyRecord;
import org.springframework.stereotype.Component;

@Component
public class CurrencyRecordFactoryImpl implements CurrencyRecordFactory {
    @Override
    public CurrencyRecord createCurrencyRecord(String curCode, String num,
                                               Integer numberOfDigits, String currency) {
        CurrencyRecord currencyRecord = new CurrencyRecord();
        currencyRecord.setCode(curCode);
        currencyRecord.setNum(num);
        currencyRecord.setNumberOfDigits(numberOfDigits);
        currencyRecord.setCurrency(currency);
        return currencyRecord;
    }
}
