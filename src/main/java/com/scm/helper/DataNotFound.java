package com.scm.helper;

public class DataNotFound extends RuntimeException {

    public DataNotFound(String message) {
        super(message);
    }

    public DataNotFound() {
        super("Resource Not Found");
    }

}
