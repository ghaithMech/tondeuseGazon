package com.libon.test.tondeuseGazon.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Resultat {
    private List<Position> positions;
}
