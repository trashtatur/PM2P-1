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


    public Rechnung(int rechnungsnummer) {
        this(rechnungsnummer,5,0);
    }

    public Rechnung(int rechnungsnummer, int initialeKapazitaet, int cursor) {
        this.rechnungsnummer = rechnungsnummer;
        this.initialeKapazitaet = initialeKapazitaet;
        this.cursor = cursor;
        this.positionen = new Position[initialeKapazitaet];
    }


    public String toString() {
        return "Rechnung{" +
                "rechnungsnummer=" + rechnungsnummer +
                ", positionen=" + Arrays.toString(positionen) +
                '}';
    }
}
