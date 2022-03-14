package com.libon.test.tondeuseGazon.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    private int x;
    private int y;
    private Orientation orientation;
}