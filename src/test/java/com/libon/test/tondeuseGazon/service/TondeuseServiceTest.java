package com.libon.test.tondeuseGazon.service;

import com.libon.test.tondeuseGazon.domain.*;
import com.libon.test.tondeuseGazon.service.exception.InstructionException;
import com.libon.test.tondeuseGazon.service.exception.OrientationException;
import com.libon.test.tondeuseGazon.service.exception.PositionException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class TondeuseServiceTest {

    private static final String INSTRUCTIONS1 = "GAGAGAGAA";
    private static final String INSTRUCTIONS2 = "AADAADADDA";
    private static final String FAKEINSTRUCTIONS = "AADCADADDA";
    private static final String OVERINSTRUCTIONS = "GAGAGAAAAAAAAGAA";
    private final Dimension dimension = new Dimension(5, 5);
    private final Position position1 = new Position(1, 2, Orientation.N);
    private final Position position2 = new Position(3, 3, Orientation.E);
    private final Position fakePosition1 = new Position(1, 17, Orientation.N);
    private final Position fakePosition2 = new Position(-1, 3, Orientation.E);
    private final Resultat resultat = new Resultat(List.of(new Position(1, 3, Orientation.N), new Position(5, 1, Orientation.E)));
    private final Resultat overResultat = new Resultat(List.of(new Position(5, 3, Orientation.N), new Position(5, 1, Orientation.E)));
    @Mock
    private TondeuseService service;

    @Test
    void getPosition() {
        assertThrows(InstructionException.class,()->service.getPosition(new Payload(dimension, List.of(new Mower(position1, FAKEINSTRUCTIONS), new Mower(position2, INSTRUCTIONS2)))));
        assertThrows(PositionException.class,()->service.getPosition(new Payload(dimension, List.of(new Mower(fakePosition1, INSTRUCTIONS1), new Mower(position2, INSTRUCTIONS2)))));
        assertThrows(PositionException.class,()->service.getPosition(new Payload(dimension, List.of(new Mower(fakePosition2, INSTRUCTIONS1), new Mower(position2, INSTRUCTIONS2)))));
        assertEquals(resultat, service.getPosition(new Payload(dimension, List.of(new Mower(position1, INSTRUCTIONS1), new Mower(position2, INSTRUCTIONS2)))));
        assertEquals(overResultat, service.getPosition(new Payload(dimension, List.of(new Mower(position1, OVERINSTRUCTIONS), new Mower(position2, INSTRUCTIONS2)))));
    }

}