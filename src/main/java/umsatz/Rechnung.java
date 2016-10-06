package umsatz;
/**
 * Created by andi on 06.10.16.
 */
public class Rechnung {
    private int Rechnungsnummer;
    private int initialeKapazitaet;
    private int cursor;
    private Position positionen[];

    public Rechnung(int rechnungsnummer, int initialeKapazitaet, int cursor) {
        Rechnungsnummer = rechnungsnummer;
        this.initialeKapazitaet = initialeKapazitaet;
        this.cursor = cursor;
        this.positionen = new Position[initialeKapazitaet];
    }


}
