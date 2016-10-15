
package umsatz;

import static org.junit.*;
import PM2P-1/src/main/java/umsatz/GeldBetrag;
import org.junit.Before;
import org.junit.Test;
import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.junit.Assert.*;

/**
 * Created by Philipp on 06.10.2016.
 */
public class GeldBetragTest {
    private int highCentValue;
    private int convertedEuro;
    private int temp;


    @Before
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
        GeldBetrag betrag = new GeldBetrag(temp);
        assertEquals(highCentValue, betrag.getCent());
        assertEquals(convertedEuro, betrag.getEuro());
    }

    @Test
    public void testNegative(){
        assertException(new GeldBetrag(-50,-30));
    }



}