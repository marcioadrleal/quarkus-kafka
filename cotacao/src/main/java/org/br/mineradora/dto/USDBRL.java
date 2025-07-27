package org.br.mineradora.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class USDBRL implements Serializable {

    @JsonProperty("code")
    private String code;

    @JsonProperty("codein")
    private String codein;

    @JsonProperty("name")
    private String name;

    @JsonProperty("high")
    private String high;

    @JsonProperty("low")
    private String low;

    @JsonProperty("varBid")
    private String varBid;

    @JsonProperty("pctChange")
    private String pctChange;

    @JsonProperty("bid")
    private String bid;

    @JsonProperty("ask")
    private String ask;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("create_date")
    private String create_date;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodein() {
        return codein;
    }

    public void setCodein(String codein) {
        this.codein = codein;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getVarBid() {
        return varBid;
    }

    public void setVarBid(String varBid) {
        this.varBid = varBid;
    }

    public String getPctChange() {
        return pctChange;
    }

    public void setPctChange(String pctChange) {
        this.pctChange = pctChange;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }
}


