package org.br.mineradora.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "opportunities")
public class OpportunityEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Date date;

    @Column(name = "proposal_id")
    private Long proposalId;

    private String customer;

    @Column(name = "price_tonne")
    private BigDecimal priceTonne;

    @Column(name = "last_currency_quotation")
    private BigDecimal lastDollarQuotation;

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

    public Long getProposalId() {
        return proposalId;
    }

    public void setProposalId(Long proposalId) {
        this.proposalId = proposalId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public BigDecimal getPriceTonne() {
        return priceTonne;
    }

    public void setPriceTonne(BigDecimal priceTonne) {
        this.priceTonne = priceTonne;
    }

    public BigDecimal getLastDollarQuotation() {
        return lastDollarQuotation;
    }

    public void setLastDollarQuotation(BigDecimal lastDollarQuotation) {
        this.lastDollarQuotation = lastDollarQuotation;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OpportunityEntity that = (OpportunityEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(proposalId, that.proposalId) && Objects.equals(customer, that.customer) && Objects.equals(priceTonne, that.priceTonne) && Objects.equals(lastDollarQuotation, that.lastDollarQuotation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, proposalId, customer, priceTonne, lastDollarQuotation);
    }
}

