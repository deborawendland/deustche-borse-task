package org.deborawendland.aggregator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.BAD_REQUEST,
        reason = "No test result files submitted."
)
public class NoTestFileException extends RuntimeException {

    public NoTestFileException() {
        super();
    }

}
