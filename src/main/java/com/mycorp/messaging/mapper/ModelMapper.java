package com.mycorp.messaging.mapper;

import org.springframework.stereotype.Component;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class ModelMapper extends ConfigurableMapper {

    /*@Bean
    public MapperFactory mapperFactory() {
        return new DefaultMapperFactory.Builder().build();
    }*/

    @Override
    protected void configure(MapperFactory factory) {
        factory.getConverterFactory().registerConverter(new OffsetDateTimeConverter());
    }
}
