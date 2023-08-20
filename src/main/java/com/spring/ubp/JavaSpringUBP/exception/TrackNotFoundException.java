package com.spring.ubp.JavaSpringUBP.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Data
public class TrackNotFoundException extends RuntimeException {

    private String resourceName;
    private String fieldName;
    private String value;

    public TrackNotFoundException(String resourceName, String fieldName, String value) {
        super(String.format("%s no encontrado con: %s, '%s'", resourceName, fieldName, value));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.value = value;
    }
}
