package br.com.eguadorodrigo;

import br.com.github.eguadorodrigo.config.QuarkusMappingConfig;
import org.mapstruct.Mapper;

@Mapper(config = QuarkusMappingConfig.class)
public interface TravelOrderMapper extends BaseMapper<TravelOrderEntity, TravelOrderDTO> {}
