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

        assertEquals("C1", currencyRecord.getCurrency());
        assertEquals("DAQ", currencyRecord.getNum());
        assertEquals("CODE", currencyRecord.getCode());
        assertEquals(Integer.valueOf(11), currencyRecord.getNumberOfDigits());

    }
}