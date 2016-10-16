package umsatz;

import static org.junit.Assert.*;

/**
 * Created by Andi on 10.10.2016.
 */
public class RechnungTest {

    private int max=99;
    private int cent;
    private int euro;
    private int euro2;
    private Position[] posary= new Position[max];


    @org.junit.Before
    public void setUp() throws Exception {
        int euro=0;
        int cent=12;
        int euro2=0;

        for (int counter = 0; counter!= max; counter++) {
            posary[counter]=new Position(cent,euro2,"Bananashake");
            euro2++;
        }

    }

    @org.junit.Test
    public void add() throws Exception {
        Rechnung rechnung = new Rechnung(1234);
        for (int counter = 0; counter!= max; counter++) {
            rechnung.add(new Position(cent,euro,"Bananashake"));
            euro++;
        }
        assertArrayEquals(posary,rechnung.getPositionen());

    }



    @org.junit.Test
    public void rechnungsSumme() throws Exception {

    }

}