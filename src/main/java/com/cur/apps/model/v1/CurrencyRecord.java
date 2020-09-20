package com.cur.apps.model.v1;

import javax.persistence.*;

@Entity
@Table(name = "currency")
public class CurrencyRecord {

    @Id
    @Column(name = "currency_record_record_pk")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String code;
    @Column
    private String num;
    @Column(name = "number_of_digits")
    private Integer numberOfDigits;
    @Column
    private String currency;

    public CurrencyRecord() {

    }

    public CurrencyRecord(String code, String num, Integer numberOfDigits,
                          String currency) {
        this.code = code;
        this.num = num;
        this.numberOfDigits = numberOfDigits;
        this.currency = currency;
    }

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
