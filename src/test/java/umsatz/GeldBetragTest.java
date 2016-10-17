package umsatz;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by Philipp on 06.10.2016.
 */
public class GeldBetragTest {
    private GeldBetrag betragfinal;
    private GeldBetrag zeroconfig=new GeldBetrag(0,0);


    @Before
    public void setUp() {
        betragfinal=new GeldBetrag(18,220);
    }


    @Test
    public void add() throws Exception {
        GeldBetrag betrag1= new GeldBetrag(12,100);
        GeldBetrag betrag2= new GeldBetrag(6,120);
        assertEquals(betragfinal,(betrag1.add(betrag2)));
        assertEquals(betragfinal,((new GeldBetrag(0,0)).add(betragfinal)));
        assertEquals(new GeldBetrag(0),zeroconfig.add(zeroconfig));
    }



}