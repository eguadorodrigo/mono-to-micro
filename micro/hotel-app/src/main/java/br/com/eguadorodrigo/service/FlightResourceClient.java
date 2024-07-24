package br.com.eguadorodrigo.service;

import br.com.eguadorodrigo.service.dto.FlightDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("flight")
@RegisterRestClient
public interface FlightResourceClient extends AbstractResourceClient<FlightDTO>{

    @Override
    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<FlightDTO> findAll();

    @Override
    @Path("findById")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    FlightDTO findById(@QueryParam("id") Long id);

    @Path("findByOrder")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    FlightDTO findByOrder(@QueryParam("orderId") Long orderId);

    @Override
    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    void create(FlightDTO dto);
}
