package org.br.mineradora.client;


import io.quarkus.oidc.token.propagation.AccessTokenRequestFilter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.br.mineradora.dto.OpportunityDTO;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/api/opportunity")
@RegisterRestClient
@RegisterProvider(AccessTokenRequestFilter.class)
@ApplicationScoped
public interface ReportRestClient {

    @GET
    @Path("/data")
    List<OpportunityDTO> requestOpportunitiesDate();

}
