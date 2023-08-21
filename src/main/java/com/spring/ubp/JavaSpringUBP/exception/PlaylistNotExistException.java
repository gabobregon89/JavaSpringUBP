package com.spring.ubp.JavaSpringUBP.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Data
public class PlaylistNotExistException extends RuntimeException{

    private String message = "Not exists playlist with that name";

    public PlaylistNotExistException() {
        this.message = message;
    }
}
