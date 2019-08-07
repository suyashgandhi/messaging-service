package com.mycorp.messaging.mapper;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

public class OffsetDateTimeConverter extends BidirectionalConverter<java.sql.Timestamp, java.time.OffsetDateTime> {

    @Override
    public OffsetDateTime convertTo(Timestamp timestamp, Type<OffsetDateTime> type, MappingContext mappingContext) {
        if (timestamp != null) {
            Instant instant = Instant.ofEpochMilli(timestamp.getTime());
            return OffsetDateTime.ofInstant(instant, ZoneId.of("GMT"));
        }
        return null;
    }

    @Override
    public Timestamp convertFrom(OffsetDateTime offsetDateTime, Type<Timestamp> type, MappingContext mappingContext) {
        if (offsetDateTime != null) {
            return Timestamp.valueOf(offsetDateTime.toLocalDateTime());
        }
        return null;
    }
}
