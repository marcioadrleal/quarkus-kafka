package org.br.mineradora.dto;


import java.math.BigDecimal;

public class ProposalDetailsDTO {

    public ProposalDetailsDTO() {
    }


    private Long proposalId;

    private String customer;

    private BigDecimal priceTonne;

    private Integer tonnes;

    private String country;

    private Integer proposalValidityDays;

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

    public Integer getTonnes() {
        return tonnes;
    }

    public void setTonnes(Integer tonnes) {
        this.tonnes = tonnes;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getProposalValidityDays() {
        return proposalValidityDays;
    }

    public void setProposalValidityDays(Integer proposalValidityDays) {
        this.proposalValidityDays = proposalValidityDays;
    }
}
