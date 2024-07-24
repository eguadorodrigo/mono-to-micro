package br.com.eguadorodrigo;

import br.com.eguadorodrigo.service.FlightResourceClient;
import br.com.eguadorodrigo.service.HotelResourceClient;
import br.com.eguadorodrigo.service.dto.FlightDTO;
import br.com.eguadorodrigo.service.dto.HotelDTO;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.stream.Collectors;

@Path("/order")
public class OrderResource {

    @Inject
    OrderMapper mapper;

    @Inject
    OrderRepository repository;

    @Inject
    FlightResourceClient flightResource;

    @Inject
    HotelResourceClient hotelResource;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrderDTO> listAll() {
        List<OrderEntity> travels = repository.listAll();
        return travels
                .stream()
                .map(order -> new OrderDTO(order.id,
                        flightResource.findByOrder(order.id),
                        hotelResource.findByOrder(order.id)))
                .collect(Collectors.toList());
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public OrderDTO findById(@QueryParam("id") long id){
        return mapper.toDTO(repository.findById(id));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public OrderDTO create(OrderDTO dto){
        OrderEntity travelOrder = new OrderEntity();
        travelOrder.id = null;
        travelOrder.persist();
        flightResource.create(new FlightDTO(null, travelOrder.id, dto.flight().fromAirport(), dto.flight().toAirport()));
        hotelResource.create(new HotelDTO(null, travelOrder.id, dto.hotel().nights()));
        return mapper.toDTO(travelOrder);
    }

}
