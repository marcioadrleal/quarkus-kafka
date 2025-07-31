package org.br.mineradora.dto;

import java.math.BigDecimal;

public class ProposalDTO {


    private Long proposalId;

    private String customer;

    private BigDecimal priceTonne;

    public Long getProposalId() {
        return proposalId;
    }

    public ProposalDTO() {
    }

    public ProposalDTO(Long proposalId, String customer, BigDecimal priceTonne) {
        this.proposalId = proposalId;
        this.customer = customer;
        this.priceTonne = priceTonne;
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
}
