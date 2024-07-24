package br.com.eguadorodrigo.service;

import br.com.eguadorodrigo.service.dto.HotelDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/hotel")
@RegisterRestClient
public interface HotelResourceClient extends AbstractResourceClient<HotelDTO>{

    @Override
    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<HotelDTO> findAll();

    @Override
    @Path("/findById")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    HotelDTO findById(Long id);

    @Path("findByOrder")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    HotelDTO findByOrder(@QueryParam("orderId") Long orderId);
    @Override
    @Path("/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    void create(HotelDTO dto);
}
