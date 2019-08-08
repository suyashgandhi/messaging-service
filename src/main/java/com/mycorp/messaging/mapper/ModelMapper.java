package com.mycorp.messaging.mapper;

import org.springframework.stereotype.Component;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

/**
 * ModelMapper is used for mapping between types.
 *
 * @author sgandhi
 */
@Component
public class ModelMapper extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory) {
        factory.getConverterFactory().registerConverter(new OffsetDateTimeConverter());
    }
}
