package com.libon.test.tondeuseGazon.domain;

import com.libon.test.tondeuseGazon.service.exception.OrientationException;
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


    public void marcher(Dimension dimension) {
        switch (orientation) {
            case N:
                if (y < dimension.getHeight()) {
                    y++;
                }
                break;
            case E:
                if (x < dimension.getWidth()) {
                    x++;
                }
                break;
            case S:
                if (y > 0) {
                    y--;
                }
                break;
            case W:
                if (x > 0) {
                    x--;
                }
                break;
            default:
                throw new OrientationException();
        }
    }

    public void tournerGauche() {
        switch (orientation) {
            case N:
                orientation = Orientation.W;
                break;
            case E:
                orientation = Orientation.N;
                break;
            case S:
                orientation = Orientation.E;
                break;
            case W:
                orientation = Orientation.S;
                break;
            default:
                throw new OrientationException();
        }
    }

    public void tournerDroite() {
        switch (orientation) {
            case N:
                orientation = Orientation.E;
                break;
            case E:
                orientation = Orientation.S;
                break;
            case S:
                orientation = Orientation.W;
                break;
            case W:
                orientation = Orientation.N;
                break;
            default:
                throw new OrientationException();
        }
    }

    public boolean checkPosition(Dimension dimension) {
        return x >= 0
                && x <= dimension.getWidth()
                && y >= 0
                && y <= dimension.getHeight();
    }
}
