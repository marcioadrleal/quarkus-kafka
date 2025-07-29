package org.br.mineradora.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.br.mineradora.service.OpportunityServiceImpl;

import java.util.Date;

@Path("/api/opportunity")
public class OpportunityController {

  @Inject
  private OpportunityServiceImpl opportunityService;

  @GET
  @Path("/report")
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  public Response generateReport(){
     try {
         return Response.ok(opportunityService.generatedCSVOpportunityReport(),
                         MediaType.APPLICATION_OCTET_STREAM)
                 .header("content-disposition", "attachment;filename = " + new Date() + "--oppotunity-sale.csv").build();
     }catch (Exception e){
         return Response.serverError().build();
     }
  }

}
