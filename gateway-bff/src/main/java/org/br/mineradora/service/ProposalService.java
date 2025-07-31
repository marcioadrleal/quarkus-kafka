package org.br.mineradora.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import org.br.mineradora.dto.ProposalDetailsDTO;

@ApplicationScoped
public interface ProposalService {

    ProposalDetailsDTO getProposalDetailsId(long proposalId);

    Response createProposal(ProposalDetailsDTO proposalDetails);

    Response removeProposal(long id);

}
