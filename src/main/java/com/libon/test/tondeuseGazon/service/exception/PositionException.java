package com.libon.test.tondeuseGazon.service.exception;

public class PositionException extends RuntimeException {
    public PositionException(){
        super("La position n'est pas valide");
    }
}
