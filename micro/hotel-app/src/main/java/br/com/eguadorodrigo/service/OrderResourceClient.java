package br.com.eguadorodrigo.service;

import br.com.eguadorodrigo.service.dto.OrderDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/order")
@RegisterRestClient
public interface OrderResourceClient extends AbstractResourceClient<OrderDTO>{

    @Override
    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<OrderDTO> findAll();

    @Override
    @Path("/findById")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    OrderDTO findById(@QueryParam("id") Long id);

    @Path("findByOrder")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    OrderDTO findByOrder(@QueryParam("orderId") Long orderId);

    @Override
    @Path("/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    void create(OrderDTO dto);
}
