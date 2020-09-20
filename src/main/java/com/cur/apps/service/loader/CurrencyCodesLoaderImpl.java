package com.cur.apps.service.loader;

import com.cur.apps.integration.WikiGateway;
import com.cur.apps.model.v1.CurrencyRecord;
import com.cur.apps.model.v1.factory.CurrencyRecordFactory;
import com.cur.apps.service.CurrencyRecordService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CurrencyCodesLoaderImpl implements CurrencyCodesLoader {

    private Logger logger = LoggerFactory.getLogger(CurrencyCodesLoaderImpl.class);

    private static final int FIRST = 0;

    @Autowired
    private WikiGateway wikiGateway;

    @Autowired
    private CurrencyRecordFactory currencyRecordFactory;

    @Autowired
    private CurrencyRecordService currencyRecordService;


    @Override
    public Map<String, CurrencyRecord> loadCurrenciesFromWikiIntoDatabase() {
        Document document = wikiGateway.getWikiPageContent();
        Element tableData = document.select(".sortable").first();
        Elements trsData = tableData.select("tr");
        trsData.remove(FIRST);


        return trsData.stream()
                .map(t -> {
                    Elements tdsData = t.select("td");
                    String curCode = tdsData.get(0).textNodes().get(0).text();
                    String num = tdsData.get(1).textNodes().get(0).text();
                    Integer digit = extractDigitNumbers(tdsData.get(2).textNodes().get(0));

                    String currency = tdsData.get(3).text();
                    CurrencyRecord currencyRecord = currencyRecordFactory.createCurrencyRecord(curCode, num,
                            digit, currency);

                    //Can use to init cache
                    return currencyRecordService.addCurrencyRecord(currencyRecord);

                }).collect(Collectors.toMap(CurrencyRecord::getCode,
                        currencyRecord -> currencyRecord));
    }

    private Integer extractDigitNumbers(TextNode textNode) {
        String digitNum = textNode.text();
        try {
            return Integer.valueOf(digitNum);
        } catch (NumberFormatException e) {
            logger.warn("Can not extract digit numbers for: [ " + digitNum + " ] ");
            return 0;
        }
    }

}
