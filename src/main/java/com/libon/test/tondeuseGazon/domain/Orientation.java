package com.libon.test.tondeuseGazon.domain;

public enum Orientation {
    N('N'),
    E('E'),
    W('W'),
    S('S');
    private final char code;

    Orientation(char code) {
        this.code = code;
    }

    public char getCode() {
        return code;
    }
}
