package com.libon.test.tondeuseGazon.service;

import com.libon.test.tondeuseGazon.domain.*;
import com.libon.test.tondeuseGazon.service.exception.InstructionException;
import com.libon.test.tondeuseGazon.service.exception.OrientationException;
import com.libon.test.tondeuseGazon.service.exception.PositionException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TondeuseService {

    public Resultat getPosition(Payload payload) {
        Resultat resultat = new Resultat();
        List<Position> positionList = new ArrayList<>();
        for (Mower mower : payload.getMowers()) {
            if (mower.getPosition().checkPosition(payload.getDimensions())) {
                String instructions = mower.getInstructions();
                for (int i = 0; i < instructions.length(); i++) {
                    try{
                        switch (Instruction.valueOf("" + instructions.charAt(i))) {
                            case A:
                                mower.getPosition().marcher(payload.getDimensions());
                                break;
                            case G:
                                mower.getPosition().tournerGauche();
                                break;
                            case D:
                                mower.getPosition().tournerDroite();
                                break;
                            default:
                                throw new InstructionException();
                        }
                    }catch (OrientationException e){
                        throw e;
                    }catch (Exception e){
                        throw new InstructionException();
                    }

                }
                positionList.add(mower.getPosition());
            } else {
                throw new PositionException();
            }
        }
        resultat.setPositions(positionList);
        return resultat;
    }
}
