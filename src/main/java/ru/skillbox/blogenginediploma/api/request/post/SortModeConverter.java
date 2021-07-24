package ru.skillbox.blogenginediploma.api.request.post;

import org.springframework.core.convert.converter.Converter;

public class SortModeConverter implements Converter<String, PostSortMode> {

    @Override
    public PostSortMode convert(String mode) {
        try {
            return PostSortMode.valueOf(mode.toUpperCase());
        } catch (IllegalArgumentException e){
            return PostSortMode.RECENT;
        }
    }
}
