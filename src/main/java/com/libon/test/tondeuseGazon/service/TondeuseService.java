package com.libon.test.tondeuseGazon.service;

import com.libon.test.tondeuseGazon.domain.Payload;
import com.libon.test.tondeuseGazon.domain.Position;
import com.libon.test.tondeuseGazon.domain.Resultat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TondeuseService {

    public Resultat getPosition(Payload payload) {
        Resultat resultat = new Resultat();
        List<Position> positionList = new ArrayList<>();
        resultat.setPositions(positionList);
        return resultat;
    }

}
