package umsatz;

import umsatz.Rechnung;
import static org.junit.Assert.*;

/**
 * Created by Someone somehell
 */
public class KasseTest {
    private int anzahl = 5;
    private Rechnung[] rechnungen = new Rechnung[anzahl];
    private GeldBetrag betrag = new GeldBetrag();

    @org.junit.Before
    public void setUp() throws Exception {
        betrag = new GeldBetrag(0,50);
        for(int i = 0; i < anzahl; ++i){
            rechnungen[i] = new Rechnung(i);
            rechnungen[i].add(new Position(betrag,"ApfelSaft"));
        }
        betrag = new GeldBetrag(0,50*anzahl);
    }

    @org.junit.Test
    public void addRechnung() throws Exception {
        Kasse kasse = new Kasse();
        for(int i = 0; i < anzahl; ++i){
            kasse.add(rechnungen[i]);
        }
        assertEquals(betrag,kasse.kassenStand());
    }

    @org.junit.Test
    public void kassenStand() throws Exception {
        Kasse kasse = new Kasse();
        for(int i = 0; i < anzahl; ++i){
            kasse.add(rechnungen[i]);
        }
        assertEquals(betrag, kasse.kassenStand());
        kasse.add(new Rechnung(anzahl + 1));
        assertEquals(betrag, kasse.kassenStand());
    }

    @org.junit.Test
    public void summePosition() throws Exception{
    	Kasse kasse = new Kasse();
        for(int i = 0; i < anzahl; ++i){
            kasse.add(rechnungen[i]);
        }
        GeldBetrag geld = kasse.summePosition(new Position(new GeldBetrag(),"ApfelSaft"));
        GeldBetrag grrr = new GeldBetrag();
        assertEquals(betrag,geld);
        geld = kasse.summePosition(new Position(new GeldBetrag(),"Apfel"));
        assertEquals(grrr,geld);
        geld = kasse.summePosition(null);
        assertEquals(grrr,geld);

    }
}
//////////////0\\\\\\\\\\\\
/////////////000\\\\\\\\\\\\
////////////00000\\\\\\\\\\\\