package com.cur.apps.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyRecordDtoResponse {

    @JsonProperty("currency_record_record_pk")
    private Long id;
    private String code;
    private String num;
    @JsonProperty("number_of_digits")
    private Integer numberOfDigits;
    private String currency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Integer getNumberOfDigits() {
        return numberOfDigits;
    }

    public void setNumberOfDigits(Integer numberOfDigits) {
        this.numberOfDigits = numberOfDigits;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
