package com.cur.apps.repository;

import com.cur.apps.model.v1.CurrencyRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRecordRepository extends JpaRepository<CurrencyRecord, Long> {
    CurrencyRecord findByCode(String code);
}
