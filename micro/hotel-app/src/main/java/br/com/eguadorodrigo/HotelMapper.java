package br.com.eguadorodrigo;

import br.com.eguadorodrigo.config.BaseMapper;
import br.com.eguadorodrigo.config.QuarkusMappingConfig;
import org.mapstruct.Mapper;

@Mapper(config = QuarkusMappingConfig.class)
public interface HotelMapper extends BaseMapper<HotelEntity, HotelDTO> {}

