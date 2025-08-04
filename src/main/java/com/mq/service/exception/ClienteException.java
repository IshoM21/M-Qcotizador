package com.mq.service.exception;

public class ClienteException extends RuntimeException {
    public ClienteException(String mensaje) {
        super(mensaje);
    }
}
