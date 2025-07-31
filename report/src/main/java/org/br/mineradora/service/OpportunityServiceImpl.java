package org.br.mineradora.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.br.mineradora.dto.OpportunityDTO;
import org.br.mineradora.dto.ProposalDTO;
import org.br.mineradora.dto.QuotationDTO;
import org.br.mineradora.entity.OpportunityEntity;
import org.br.mineradora.entity.QuotationEntity;
import org.br.mineradora.repository.OpportunityRepository;
import org.br.mineradora.repository.QuotationRepository;
import org.br.mineradora.utils.CsvHelper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class OpportunityServiceImpl implements OpportunityService {

    @Inject
    private QuotationRepository quotationRepository;

    @Inject
    private OpportunityRepository opportunityRepository;

    @Override
    public void buildOpportunity(ProposalDTO proposal) {
        List<QuotationEntity> quotationEntity = quotationRepository.findAll().list();
        Collections.reverse(quotationEntity);
        OpportunityEntity opp = new OpportunityEntity();
        opp.setDate(new Date());
        opp.setProposalId(proposal.getProposalId());
        opp.setCustomer(proposal.getCustomer());
        opp.setPriceTonne(proposal.getPriceTonne());
        opp.setLastDollarQuotation(quotationEntity.get(0).getCurrencyPrice());
        opportunityRepository.persist(opp);
    }

    @Override
    @Transactional
    public void saveQuotation(QuotationDTO quotation) {
      QuotationEntity qu = new QuotationEntity();
      qu.setDate(new Date());
      qu.setCurrencyPrice(quotation.currencyPrice());
      quotationRepository.persist(qu);
    }

    @Override
    public List<OpportunityDTO> generateOpportunityData() {

        List<OpportunityDTO> opportunityList = new ArrayList<>();
        opportunityRepository.findAll().list().forEach(item ->
                opportunityList.add(
                        new OpportunityDTO(
                                item.getProposalId(), item.getCustomer(), item.getPriceTonne(), item.getLastDollarQuotation()))
        );

        return opportunityList;
    }

  /*  @Override
    public ByteArrayInputStream generatedCSVOpportunityReport()  {
        List<OpportunityDTO> opportunityList = new ArrayList<>();
        opportunityRepository.findAll().list().forEach(item ->
                opportunityList.add(
                        new OpportunityDTO(
                                item.getProposalId(), item.getCustomer(), item.getPriceTonne(), item.getLastDollarQuotation()))
        );

        return CsvHelper.OpportunitiesToCsv(opportunityList);
    } */
}
