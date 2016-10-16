package umsatz;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by Philipp on 06.10.2016.
 */
public class GeldBetragTest {
    private int highCentValue;
    private int convertedEuro;
    private int temp;
    private GeldBetrag betragfinal;
    private GeldBetrag zeroconfig=new GeldBetrag(0,0);


    @Before
    public void setUp() {
        highCentValue = 1567;
        temp = highCentValue;
        convertedEuro = 0;
        betragfinal=new GeldBetrag(18,220);
        while (highCentValue >= 100) {
            highCentValue -=100;
            ++convertedEuro;
        }
    }

    @Test
    public void testHighCentValue() throws Exception{
        GeldBetrag betrag = new GeldBetrag(temp);
        assertEquals(highCentValue, betrag.getCent());
        assertEquals(convertedEuro, betrag.getEuro());
    }

    @Test
    public void testNegative() throws Exception{

    }

    @Test
    public void add() throws Exception {
        GeldBetrag betrag1= new GeldBetrag(12,100);
        GeldBetrag betrag2= new GeldBetrag(6,120);
        assertEquals(betragfinal.getEuro(),(betrag1.add(betrag1,betrag2)).getEuro());
        assertEquals(betragfinal.getCent(),(betrag1.add(betrag1,betrag2)).getCent());
        assertEquals(betragfinal.getCent(),((new GeldBetrag(0,0)).add(new GeldBetrag(0,0),betragfinal)).getCent());
        assertEquals(betragfinal.getEuro(),((new GeldBetrag(0,0)).add(new GeldBetrag(0,0),betragfinal)).getEuro());
        assertEquals(new GeldBetrag(0).getCent(),zeroconfig.add(zeroconfig,zeroconfig).getCent());
        assertEquals(new GeldBetrag(0).getEuro(),zeroconfig.add(zeroconfig,zeroconfig).getEuro());
    }



}