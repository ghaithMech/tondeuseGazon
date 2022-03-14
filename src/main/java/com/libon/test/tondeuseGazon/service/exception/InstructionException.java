package com.libon.test.tondeuseGazon.service.exception;

public class InstructionException extends RuntimeException {
    public InstructionException(){
        super("L'instruction n'est pas valide");
    }
}
