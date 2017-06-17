package systems.ab4.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by radug on 6/17/2017.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Location")
public class LocationNotFoundException extends RuntimeException{
}
