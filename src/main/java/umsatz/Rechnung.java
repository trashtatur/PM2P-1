package umsatz;

import java.util.Arrays;

/**
 * Created by andi on 06.10.16.
 */
public class Rechnung {
    private int rechnungsnummer;
    private int initialeKapazitaet;
    private int cursor;
    private Position positionen[];
    private int erweiternUm;




    public Rechnung(int rechnungsnummer) {
        this.rechnungsnummer = rechnungsnummer;
        this.initialeKapazitaet = 5;
        this.cursor = 0;
        this.positionen = new Position[initialeKapazitaet];
        this.erweiternUm=2;
    }

    public void add (Position pos) {
        if (cursor<positionen.length) {
            positionen[cursor]=pos;
            cursor++;
        }
        else {
            positionen=Arrays.copyOf(positionen,positionen.length+erweiternUm);
            positionen[cursor]=pos;
            cursor++;

        }

    }
    public String toString() {
        Position[] tempary=Arrays.copyOf(positionen,cursor-1);
        return "Rechnung{" +
                "rechnungsnummer=" + rechnungsnummer +
                ", positionen=" + Arrays.toString(tempary) +
                '}';
    }
}
