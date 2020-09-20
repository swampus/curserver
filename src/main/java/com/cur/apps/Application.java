package com.cur.apps;

import com.cur.apps.model.v1.CurrencyRecord;
import com.cur.apps.service.loader.CurrencyCodesLoader;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Remove from final version
     */
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {

        return args -> {

            logger.debug("Let's inspect the beans provided by Spring Boot:");
            CurrencyCodesLoader currencyCodesLoader = ctx.getBean(CurrencyCodesLoader.class);
            currencyCodesLoader.loadCurrenciesFromWikiIntoDatabase().values()
                    .forEach((CurrencyRecord currencyRecord) -> logger.info("Currency loaded: "
                            + ReflectionToStringBuilder.reflectionToString(currencyRecord)));

        };
    }
}
