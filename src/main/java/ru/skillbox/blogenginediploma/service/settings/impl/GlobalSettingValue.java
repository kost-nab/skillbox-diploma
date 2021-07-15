package ru.skillbox.blogenginediploma.service.settings.impl;

import java.util.function.Function;

public class GlobalSettingValue<T> {
    private Function<T, String> toDatabaseFunction;
    private Function<String, T> fromDatabaseFunction;
    private T value;

    GlobalSettingValue(Function<T, String> toDatabaseFunction, Function<String, T> fromDatabaseFunction, T value) {
        this.toDatabaseFunction = toDatabaseFunction;
        this.fromDatabaseFunction = fromDatabaseFunction;
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public T getValue(String databaseValue) {
        return fromDatabaseFunction.apply(databaseValue);
    }

    public String getDatabaseValue() {
        return toDatabaseFunction.apply(value);
    }

}