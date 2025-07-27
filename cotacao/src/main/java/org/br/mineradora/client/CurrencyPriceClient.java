package org.br.mineradora.client;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.br.mineradora.dto.CurrencyPriceDTO;
import org.br.mineradora.dto.USDBRL;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.Set;


@Path("json/last")
@RegisterRestClient
@ApplicationScoped
public interface CurrencyPriceClient {

    @GET
    @Path("/{pair}")
    @Produces(MediaType.APPLICATION_JSON)
    CurrencyPriceDTO getPriceByPair(@PathParam("pair") String pair);
}
