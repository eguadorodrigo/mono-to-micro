package br.com.github.eguadorodrigo.mapper;

import br.com.github.eguadorodrigo.config.QuarkusMappingConfig;
import br.com.github.eguadorodrigo.flight.FlightEntity;
import br.com.github.eguadorodrigo.flight.FlightDTO;
import org.mapstruct.Mapper;

@Mapper(config = QuarkusMappingConfig.class)
public interface FlightMapper extends BaseMapper<FlightEntity,FlightDTO> {}

