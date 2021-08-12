package ru.skillbox.blogenginediploma.api.configuration.mapping;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class TimestampConverter implements Converter<LocalDateTime, Long> {
    @Override
    public Long convert(MappingContext<LocalDateTime, Long> context) {
        return context.getSource().toInstant(ZoneOffset.UTC).getEpochSecond();
    }
}
