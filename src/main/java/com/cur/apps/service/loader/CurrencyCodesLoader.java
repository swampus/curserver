package com.cur.apps.service.loader;

import com.cur.apps.model.v1.CurrencyRecord;

import java.util.Map;

public interface CurrencyCodesLoader {
    Map<String,CurrencyRecord> loadCurrenciesFromWikiIntoDatabase();
}
