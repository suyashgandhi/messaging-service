package com.mycorp.messaging.mapper;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import ma.glasnost.orika.Converter;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;

@RunWith(MockitoJUnitRunner.class)
public class ModelMapperTest {

    @Test
    public void configure_shouldSucceed() {
        MapperFactory mapperFactory = mock(MapperFactory.class);
        ConverterFactory converterFactory = mock(ConverterFactory.class);
        when(mapperFactory.getConverterFactory()).thenReturn(converterFactory);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.configure(mapperFactory);
        verify(mapperFactory).getConverterFactory();
        verify(converterFactory).registerConverter(any(Converter.class));
    }
}
