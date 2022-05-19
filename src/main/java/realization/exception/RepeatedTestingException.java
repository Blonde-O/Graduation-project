package realization.exception;

import org.springframework.beans.factory.annotation.Autowired;


public class RepeatedTestingException extends Exception{

    @Autowired
    public RepeatedTestingException(String message) {
        super(message);
    }
}