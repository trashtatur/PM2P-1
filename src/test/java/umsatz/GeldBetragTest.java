package umsatz;

import static org.junit.Assert.*;

/**
 * Created by Philipp on 06.10.2016.
 */
public class GeldBetragTest {
    int highCentValue;
    int convertedEuro;
    int temp;


    @before
    public void init() {
        highCentValue = 1567;
        temp = highCentValue;
        convertedEuro = 0;
        while (highCentValue >= 100) {
            highCentValue -=100;
            ++convertedEuro;
        }
    }

    @Test
    public void testHighCentValue(){
        betrag = new GeldBetrag(temp);
        assertEquals(highCentValue, betrag.getCent());
        assertEquals(convertedEuro, betrag.getEuro());
    }

    @Test
    public void testNegative(){

    }



}