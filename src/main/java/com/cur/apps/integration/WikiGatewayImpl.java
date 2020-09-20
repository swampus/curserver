package com.cur.apps.integration;

import com.cur.apps.exceptions.ServiceException;
import com.cur.apps.handler.ErrorCode;
import com.google.common.collect.ImmutableMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class WikiGatewayImpl implements WikiGateway {

    @Value("${wiki.url}")
    private String wikiUrl;

    @Override
    public Document getWikiPageContent() {
        return createDocument();
    }

    private Document createDocument() {
        try {
            return Jsoup.connect(wikiUrl).get();
        } catch (IOException e) {
            throw new ServiceException(ErrorCode.GEN_WIK_01,
                    ImmutableMap.of("url", wikiUrl, "message", e.getMessage()), "en");
        }
    }

}
