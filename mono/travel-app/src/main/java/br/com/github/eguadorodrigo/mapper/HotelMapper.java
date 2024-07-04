package br.com.github.eguadorodrigo.mapper;

import br.com.github.eguadorodrigo.config.QuarkusMappingConfig;
import br.com.github.eguadorodrigo.hotel.HotelDTO;
import br.com.github.eguadorodrigo.hotel.HotelEntity;
import org.mapstruct.Mapper;

@Mapper(config = QuarkusMappingConfig.class)
public interface HotelMapper extends BaseMapper<HotelEntity, HotelDTO> {}

