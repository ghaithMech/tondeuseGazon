package com.libon.test.tondeuseGazon.domain;

public enum Instruction {
    D('D'),
    G('G'),
    A('A');
    private final char code;

    Instruction(char code) {
        this.code = code;
    }

    public char getCode() {
        return code;
    }

}
