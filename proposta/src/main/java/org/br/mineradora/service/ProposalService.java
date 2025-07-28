package org.br.mineradora.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.br.mineradora.dto.ProposalDetailsDTO;
import org.br.mineradora.entity.ProposalEntity;
import org.br.mineradora.repository.ProposalRepository;

@ApplicationScoped
public interface ProposalService {


    public ProposalDetailsDTO findFullProposal(long id);

    public void createNewProposal(ProposalDetailsDTO proposalDetails);

    public void removeProposal(long id);






}
