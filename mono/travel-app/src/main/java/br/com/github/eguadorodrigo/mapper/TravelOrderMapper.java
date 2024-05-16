package br.com.github.eguadorodrigo.mapper;

import br.com.github.eguadorodrigo.config.QuarkusMappingConfig;
import br.com.github.eguadorodrigo.order.TravelOrderEntity;
import br.com.github.eguadorodrigo.order.TravelOrderDTO;
import org.mapstruct.Mapper;

@Mapper(config = QuarkusMappingConfig.class)
public interface TravelOrderMapper extends BaseMapper<TravelOrderEntity, TravelOrderDTO> {}
