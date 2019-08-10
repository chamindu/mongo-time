package dev.chamindu.mongotime;

import org.springframework.core.convert.converter.Converter;

import java.time.format.DateTimeFormatter;

public class MongoLocalDateTimeToStringConverter implements Converter<MongoLocalDateTime, String> {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");

    @Override
    public String convert(MongoLocalDateTime source) {
        return formatter.format(source.toLocalDateTime());
    }
}
