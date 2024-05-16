package br.com.github.eguadorodrigo.order;

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
    TravelOrderMapper travelOrderMapper;

    @Inject
    TravelOrderRepository repository;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TravelOrderDTO> listAll() {
        List<TravelOrderEntity> travels = repository.listAll();
        return travels
                .stream()
                .map(travelOrderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public TravelOrderDTO findById(@QueryParam("id") long id){
        return travelOrderMapper.toDTO(repository.findById(id));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public TravelOrderDTO create(TravelOrderDTO dto){
        TravelOrderEntity travelOrder = new TravelOrderEntity();
        travelOrder.id = null;

        repository.persist(travelOrder);

        return travelOrderMapper.toDTO(travelOrder);
    }

}
