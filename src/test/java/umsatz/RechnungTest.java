package umsatz;

import static org.junit.Assert.*;

/**
 * Created by Andi on 10.10.2016.
 */
public class RechnungTest {

    private int max=39;
    private int cent;
    private int euro=20;
    private int euro2;
    private int euromax=780;
    private Position[] posary= new Position[max];
    private Rechnung rechnung;
    private GeldBetrag grossbetrag;
    private String artikel="banana";


    @org.junit.Before
    public void setUp() throws Exception {
        int cent=0;
        int euro2=0;
        this.grossbetrag= new GeldBetrag(cent,euromax);
        this.rechnung = new Rechnung(1234);

        for (int counter = 0; counter!= max; counter++) {
            posary[counter]=new Position(cent,euro2,"Bananashake");
            euro2++;
        }

    }

    @org.junit.Test
    public void add() throws Exception {
        for (int counter = 0; counter!= max; counter++) {
            rechnung.add(new Position(cent,euro,"Bananashake"));
            euro++;
        }
        assertArrayEquals(posary,rechnung.getPositionen());

    }

    @org.junit.Test
    public void rechnungsSumme() throws Exception {
        for (int counter = 0; counter!= max; counter++) {
            rechnung.add(new Position(cent,euro,"Bananashake"));
            artikel+="shake";
        }
        assertEquals(grossbetrag,rechnung.rechnungsSumme());
    }
}