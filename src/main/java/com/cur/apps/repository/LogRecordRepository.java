package com.cur.apps.repository;

import com.cur.apps.model.v1.LogRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRecordRepository extends JpaRepository<LogRecord, Long> {
    List<LogRecord> findAllByUrlContains(String url);
}
