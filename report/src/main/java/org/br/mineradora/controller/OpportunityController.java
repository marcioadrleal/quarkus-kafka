package org.br.mineradora.controller;

import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.br.mineradora.dto.OpportunityDTO;
import org.br.mineradora.service.OpportunityServiceImpl;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.util.Date;
import java.util.List;

@Path("/api/opportunity")
@Authenticated
public class OpportunityController {

  @Inject
  private JsonWebToken token;

  @Inject
  private OpportunityServiceImpl opportunityService;

  @GET
  @Path("/data")
  @RolesAllowed({"user" , "manager"})
  public List<OpportunityDTO> generateReport(){
    return opportunityService.generateOpportunityData();
  }

}
