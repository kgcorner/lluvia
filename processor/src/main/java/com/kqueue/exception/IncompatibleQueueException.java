package com.kqueue.exception;

public class IncompatibleQueueException extends Exception{
    public IncompatibleQueueException() {
        super("Incompatible queue given");
    }
    public IncompatibleQueueException(String message) {
        super(message);
    }
}
