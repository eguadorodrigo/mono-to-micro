package br.com.eguadorodrigo;

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

@Path("/flight")
public class FlightResource {

    @Inject
    FlightMapper flightMapper;

    @Inject
    FlightRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<FlightDTO> getAll(){
        List<FlightEntity> flights = repository.listAll();
        return flights
                .stream()
                .map(flightMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public FlightDTO findById(@QueryParam("id") long id){
        return flightMapper.toDTO(repository.findById(id));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public FlightDTO create(FlightDTO dto){
        FlightEntity flight = flightMapper.toEntity(dto);
        flight.id = null;
        repository.persistAndFlush(flight);
        return flightMapper.toDTO(flight);
    }

}
