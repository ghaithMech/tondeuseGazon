package com.libon.test.tondeuseGazon.service.exception;

public class OrientationException extends RuntimeException {
    public OrientationException(){
        super("L'orientation n'est pas valide");
    }
}
