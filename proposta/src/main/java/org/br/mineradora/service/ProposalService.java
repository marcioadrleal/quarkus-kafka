package org.br.mineradora.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.br.mineradora.repository.ProposalRepository;

@ApplicationScoped
public class ProposalService {

    @Inject
    private ProposalRepository proposalRepository;
}
