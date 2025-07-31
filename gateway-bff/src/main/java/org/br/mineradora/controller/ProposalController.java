package org.br.mineradora.controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.br.mineradora.dto.ProposalDetailsDTO;
import org.br.mineradora.service.ProposalService;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/api/trade")
public class ProposalController {

    private final Logger LOG = LoggerFactory.getLogger(ProposalController.class);

    @Inject
    private JsonWebToken josonWebToken;

    @Inject
    private ProposalService proposalService;

    @GET
    @Path("/{id}")
    @RolesAllowed({"user", "manager"})
    public ProposalDetailsDTO findDetailsProposal(@PathParam("id") long id) {
        return proposalService.getProposalDetailsId(id);
    }

    @POST
    @RolesAllowed("proposal-customer")
    public Response createProposal(ProposalDetailsDTO dto) {
        try {
            proposalService.createProposal(dto);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("manager")
    public Response deleteProposal(@PathParam("id") long id) {
        try {
            proposalService.removeProposal(id);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
