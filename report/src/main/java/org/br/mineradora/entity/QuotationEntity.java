package org.br.mineradora.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "quotation")
public class QuotationEntity {

    @Id
    @GeneratedValue
    private Long id;


    private Date date;

    @Column(name = "currency_price")
    private BigDecimal currencyPrice;

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

    public BigDecimal getCurrencyPrice() {
        return currencyPrice;
    }

    public void setCurrencyPrice(BigDecimal currencyPrice) {
        this.currencyPrice = currencyPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        QuotationEntity that = (QuotationEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(currencyPrice, that.currencyPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, currencyPrice);
    }
}
