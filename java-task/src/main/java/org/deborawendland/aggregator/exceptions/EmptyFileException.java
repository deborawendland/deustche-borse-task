package org.deborawendland.aggregator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.NO_CONTENT,
        reason = "Empty file."
)
public class EmptyFileException extends RuntimeException {

    public EmptyFileException(String message) {
        super(message);
    }

}
