package com.realmartynov.skyfetch.exception;

public class InvalidCityNameException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Неверный формат названия города.";
    }
}
