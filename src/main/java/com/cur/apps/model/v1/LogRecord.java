package com.cur.apps.model.v1;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "logs")
public class LogRecord {
    @Id
    @Column(name = "log_record_pk")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Date date;
    @Column
    private String method;
    @Column
    private String url;
    @Column(name = "request_json")
    private String requestJson;
    @Column(name = "request_ip_v6")
    private String requestIpV6;
    @Column
    private String message;
    @Column
    private String result;

    public LogRecord() {
    }

    public LogRecord(Date date, String method, String url, String requestJson,
                     String requestIpV6, String message, String result) {
        this.date = date;
        this.method = method;
        this.url = url;
        this.requestJson = requestJson;
        this.requestIpV6 = requestIpV6;
        this.message = message;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRequestJson() {
        return requestJson;
    }

    public void setRequestJson(String requestJson) {
        this.requestJson = requestJson;
    }

    public String getRequestIpV6() {
        return requestIpV6;
    }

    public void setRequestIpV6(String requestIpV6) {
        this.requestIpV6 = requestIpV6;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
