package br.com.eguadorodrigo.service;

import br.com.eguadorodrigo.service.dto.HotelDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;
import java.util.concurrent.CompletionStage;

@Path("/hotel")
@RegisterRestClient
public interface HotelResourceClient implements AbstractResourceClient<HotelDTO>{



}
