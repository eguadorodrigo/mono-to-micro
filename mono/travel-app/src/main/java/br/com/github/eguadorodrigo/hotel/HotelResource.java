package br.com.github.eguadorodrigo.hotel;

import br.com.github.eguadorodrigo.mapper.HotelMapper;
import br.com.github.eguadorodrigo.repository.HotelRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("hotel")
public class HotelResource {

    @Inject
    HotelRepository repository;

    @Inject
    HotelMapper mapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<HotelDTO> listAll(){
        return Optional.ofNullable(repository
                        .listAll())
                .stream()
                .flatMap(Collection::stream)
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public HotelDTO findById(@QueryParam("id") long id){
        return mapper.toDTO(repository.findById(id));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public HotelDTO create(HotelDTO dto){
        HotelEntity hotel = mapper.toEntity(dto);
        hotel.id = null;
        repository.persistAndFlush(hotel);
        return mapper.toDTO(hotel);
    }

}
