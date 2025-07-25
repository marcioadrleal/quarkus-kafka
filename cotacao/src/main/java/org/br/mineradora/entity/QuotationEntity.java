package org.br.mineradora.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="quotation")
public class QuotationEntity {


    @Id
    @GeneratedValue
    private Long id;

    @Column(name="date")
    private Date date;

    @Column(name="currecy_price")
    private BigDecimal currecyPrice;

    @Column(name="pct_change")
    private String pctChange;

    @Column(name="pair")
    private String pair;

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

    public BigDecimal getCurrecyPrice() {
        return currecyPrice;
    }

    public void setCurrecyPrice(BigDecimal currecyPrice) {
        this.currecyPrice = currecyPrice;
    }

    public String getPctChange() {
        return pctChange;
    }

    public void setPctChange(String pctChange) {
        this.pctChange = pctChange;
    }

    public String getPair() {
        return pair;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        QuotationEntity that = (QuotationEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(currecyPrice, that.currecyPrice) && Objects.equals(pctChange, that.pctChange) && Objects.equals(pair, that.pair);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, currecyPrice, pctChange, pair);
    }

    public void setPair(String pair) {
        this.pair = pair;
    }


}
