package org.br.mineradora.service;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.br.mineradora.dto.ProposalDTO;
import org.br.mineradora.dto.ProposalDetailsDTO;
import org.br.mineradora.entity.ProposalEntity;
import org.br.mineradora.message.KafkaEvent;
import org.br.mineradora.repository.ProposalRepository;

import java.util.Date;

public class ProposaServiceImpl implements ProposalService{

    @Inject
    private ProposalRepository proposalRepository;

    @Inject
    private KafkaEvent kafkaEvent;

    @Override
    public ProposalDetailsDTO findFullProposal(long id) {
      ProposalEntity proposal = proposalRepository.findById(id);
      return new ProposalDetailsDTO(proposal);
    }

    @Override
    @Transactional
    public void createNewProposal(ProposalDetailsDTO proposalDetails) {
      saveNewProposal(proposalDetails);
      ProposalEntity proposalId = proposalRepository.findByCustomer(proposalDetails.getCustomer()).get();
      ProposalDTO dto = new ProposalDTO( proposalId.getId() , proposalDetails.getCustomer() , proposalDetails.getPriceTonne() );
      kafkaEvent.sendNewKafkaEvent(dto);
    }


    private void saveNewProposal(ProposalDetailsDTO proposalDetails){
        ProposalEntity entity = new ProposalEntity();
        entity.setCreated(new Date());
        entity.setCountry(proposalDetails.getCountry());
        entity.setCustomer(proposalDetails.getCustomer());
        entity.setTonnes(proposalDetails.getTonnes());
        entity.setPriceTonne(proposalDetails.getPriceTonne());
        entity.setProposalValidityDays(proposalDetails.getProposalValidityDays());
        proposalRepository.persist(entity);
    }

    @Transactional
    @Override
    public void removeProposal(long id) {
      proposalRepository.deleteById(id);
    }
}
