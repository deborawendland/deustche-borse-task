package org.deborawendland.aggregator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.INTERNAL_SERVER_ERROR,
        reason = "Error parsing CSV file."
)
public class CSVParsingException extends RuntimeException {

    public CSVParsingException(String message) {
        super(message);
    }

}
