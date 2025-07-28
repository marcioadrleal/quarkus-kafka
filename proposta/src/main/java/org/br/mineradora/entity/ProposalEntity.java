package org.br.mineradora.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "proposal")
public class ProposalEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String customer;

    @Column(name = "price_tonne")
    private BigDecimal priceTonne;

    private Integer tonnes;

    private String country;

    @Column(name = "proposal_validity_days")
    private Integer proposalValidityDays;

    private Date created;

    public ProposalEntity() {
    }

    public ProposalEntity(String customer, BigDecimal priceTonne, Integer tonnes, String country, Integer proposalValidityDays, Date created) {
        this.customer = customer;
        this.priceTonne = priceTonne;
        this.tonnes = tonnes;
        this.country = country;
        this.proposalValidityDays = proposalValidityDays;
        this.created = created;
    }

    public ProposalEntity(Long id, String customer, BigDecimal priceTonne, Integer tonnes, String country, Integer proposalValidityDays, Date created) {
        this.id = id;
        this.customer = customer;
        this.priceTonne = priceTonne;
        this.tonnes = tonnes;
        this.country = country;
        this.proposalValidityDays = proposalValidityDays;
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProposalEntity that = (ProposalEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(customer, that.customer) && Objects.equals(priceTonne, that.priceTonne) && Objects.equals(tonnes, that.tonnes) && Objects.equals(country, that.country) && Objects.equals(proposalValidityDays, that.proposalValidityDays) && Objects.equals(created, that.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, priceTonne, tonnes, country, proposalValidityDays, created);
    }

    public Long getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }

    public BigDecimal getPriceTonne() {
        return priceTonne;
    }

    public Integer getTonnes() {
        return tonnes;
    }

    public String getCountry() {
        return country;
    }

    public Integer getProposalValidityDays() {
        return proposalValidityDays;
    }

    public Date getCreated() {
        return created;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setPriceTonne(BigDecimal priceTonne) {
        this.priceTonne = priceTonne;
    }

    public void setTonnes(Integer tonnes) {
        this.tonnes = tonnes;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setProposalValidityDays(Integer proposalValidityDays) {
        this.proposalValidityDays = proposalValidityDays;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
