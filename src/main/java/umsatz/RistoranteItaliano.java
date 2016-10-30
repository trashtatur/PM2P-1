package umsatz;

import java.io.FileNotFoundException;

/**
 * Created by Andi on 30.10.2016.
 */
public class RistoranteItaliano {

    public static void main (String[] args) throws FileNotFoundException {
        RechnungsLeser rn=new RechnungsLeser("rechnungen.sv");
        rn.leseKasse();

    }

}
