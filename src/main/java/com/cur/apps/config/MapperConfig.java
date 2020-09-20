package com.cur.apps.config;

import com.cur.apps.dto.response.CurrencyRecordDtoResponse;
import com.cur.apps.dto.response.LogRecordDtoResponse;
import com.cur.apps.model.v1.CurrencyRecord;
import com.cur.apps.model.v1.LogRecord;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public MapperFactory mapperFactory(){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(CurrencyRecord.class, CurrencyRecordDtoResponse.class);
        mapperFactory.classMap(LogRecord.class, LogRecordDtoResponse.class);
        return mapperFactory;
    }

    @Bean
    public MapperFacade mapper(@Autowired  MapperFactory mapperFactory){
        return mapperFactory.getMapperFacade();
    }


}
