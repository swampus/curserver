package com.cur.apps.repository;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TimeRepositoryImpl implements TimeRepository {

    @Override
    public Date getCurrentApplicationDate() {
        return new Date();
    }
}
