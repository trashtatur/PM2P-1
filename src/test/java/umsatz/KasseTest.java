package umsatz;

import umsatz.Rechnung;
import static org.junit.Assert.*;

/**
 * Created by Andi on 10.10.2016.
 */
public class KasseTest {
    private int anzahl = 5;
    private Rechnung[] rechnungen = new Rechnung[anzahl];
    private int betrag = 10000;

    @org.junit.Before
    public void setUp() throws Exception {
        int euro = 0;
        int cent = betrag;
        while(cent >= 100){
            ++euro;
            cent-=100;
        }
        for(int i = 0; i < anzahl; ++i){
            rechnungen[i] = new Rechnung(i);
            rechnungen[i].add(new Position(cent,euro,"ApfelSaft"));
        }
        betrag = betrag*anzahl;
    }

    @org.junit.Test
    public void addRechnung() throws Exception {
        Kasse kasse = new Kasse(anzahl+1);
        for(int i = 0; i < anzahl; ++i){
            kasse.addRechnung(rechnungen[i]);
        }

        assertEquals(anzahl,kasse.getCount());
        kasse.addRechnung(new Rechnung(anzahl + 1));
        assertEquals(anzahl+1,kasse.getCount());
    }

    @org.junit.Test
    public void kassenStand() throws Exception {
        Kasse kasse = new Kasse(anzahl+1);
        for(int i = 0; i < anzahl; ++i){
            kasse.addRechnung(rechnungen[i]);
        }
        assertEquals(betrag, kasse.kassenStand().getCent()+kasse.kassenStand().getEuro()*100);
        kasse.addRechnung(new Rechnung(anzahl + 1));
        assertEquals(betrag, kasse.kassenStand().getCent()+kasse.kassenStand().getEuro()*100);
    }

}