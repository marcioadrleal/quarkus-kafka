package org.br.mineradora.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

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
}
