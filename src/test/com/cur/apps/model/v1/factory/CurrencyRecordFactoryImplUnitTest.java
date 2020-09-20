package com.cur.apps.model.v1.factory;

import com.cur.apps.model.v1.CurrencyRecord;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CurrencyRecordFactoryImplUnitTest {

    private CurrencyRecordFactoryImpl currencyRecordFactory = new CurrencyRecordFactoryImpl();

    @Test
    public void createCurrencyRecord() {
        CurrencyRecord currencyRecord =
                currencyRecordFactory.createCurrencyRecord("C1", "C2",
                        2, "C333");

        assertEquals("C333", currencyRecord.getCurrency());
        assertEquals("C2", currencyRecord.getNum());
        assertEquals("C1", currencyRecord.getCode());
        assertEquals(Integer.valueOf(2), currencyRecord.getNumberOfDigits());

    }
}