package br.com.github.eguadorodrigo.order;

import br.com.github.eguadorodrigo.flight.FlightDTO;
import br.com.github.eguadorodrigo.flight.FlightResource;
import br.com.github.eguadorodrigo.hotel.HotelDTO;
import br.com.github.eguadorodrigo.hotel.HotelResource;
import br.com.github.eguadorodrigo.mapper.TravelOrderMapper;
import br.com.github.eguadorodrigo.repository.TravelOrderRepository;
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
public class TravelOrderResource {

    @Inject
    TravelOrderMapper mapper;

    @Inject
    TravelOrderRepository repository;

    @Inject
    FlightResource flightResource;

    @Inject
    HotelResource hotelResource;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TravelOrderDTO> listAll() {
        List<TravelOrderEntity> travels = repository.listAll();
        return travels
                .stream()
                .map(order -> new TravelOrderDTO(order.id,
                        flightResource.findById(order.id),
                        hotelResource.findById(order.id)))
                .collect(Collectors.toList());
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public TravelOrderDTO findById(@QueryParam("id") long id){
        return mapper.toDTO(repository.findById(id));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public TravelOrderDTO create(TravelOrderDTO dto){
        TravelOrderEntity travelOrder = new TravelOrderEntity();
        travelOrder.id = null;
        travelOrder.persist();
        flightResource.create(new FlightDTO(null, travelOrder.id, dto.flight().fromAirport(), dto.flight().toAirport()));
        hotelResource.create(new HotelDTO(null, travelOrder.id, dto.hotel().nights()));
        return mapper.toDTO(travelOrder);
    }

}
