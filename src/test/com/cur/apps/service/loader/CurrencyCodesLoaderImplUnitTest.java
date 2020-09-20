package com.cur.apps.service.loader;

import com.cur.apps.integration.WikiGateway;
import com.cur.apps.model.v1.CurrencyRecord;
import com.cur.apps.model.v1.factory.CurrencyRecordFactory;
import com.cur.apps.model.v1.factory.CurrencyRecordFactoryImpl;
import com.cur.apps.service.CurrencyRecordService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.FieldSetter;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class CurrencyCodesLoaderImplUnitTest {

    @Mock
    private WikiGateway wikiGateway;

    private CurrencyRecordFactory currencyRecordFactory = new CurrencyRecordFactoryImpl();

    @Mock
    private CurrencyRecordService currencyRecordService;

    @InjectMocks
    private CurrencyCodesLoaderImpl currencyCodesLoader = new CurrencyCodesLoaderImpl();

    @Test
    public void loadCurrenciesFromWikiIntoDatabase() throws NoSuchFieldException, IOException {


        File input = new File("src/test/resources/wiki_page_20_sept.html");
        Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
        when(wikiGateway.getWikiPageContent()).thenReturn(doc);
        when(currencyRecordService.addCurrencyRecord(any())).then(AdditionalAnswers.returnsFirstArg());
        FieldSetter.setField(currencyCodesLoader, CurrencyCodesLoaderImpl.class
                .getDeclaredField("currencyRecordFactory"), currencyRecordFactory);

        Map<String, CurrencyRecord> currencyRecordMap =
                currencyCodesLoader.loadCurrenciesFromWikiIntoDatabase();

        assertEquals(179, currencyRecordMap.values().size());

        CurrencyRecord currencyRecord = currencyRecordMap.get("CHE");
        assertEquals("CHE", currencyRecord.getCode());
        assertEquals("WIR euro (complementary currency)", currencyRecord.getCurrency());
        assertEquals(Integer.valueOf(2), currencyRecord.getNumberOfDigits());
        assertEquals("947", currencyRecord.getNum());

        currencyRecord = currencyRecordMap.get("MDL");
        assertEquals("MDL", currencyRecord.getCode());
        assertEquals("Moldovan leu", currencyRecord.getCurrency());
        assertEquals(Integer.valueOf(2), currencyRecord.getNumberOfDigits());
        assertEquals("498", currencyRecord.getNum());

    }
}