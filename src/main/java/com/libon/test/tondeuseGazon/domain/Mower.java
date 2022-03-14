package com.libon.test.tondeuseGazon.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mower {
    private Position position;
    private String instructions;
}

