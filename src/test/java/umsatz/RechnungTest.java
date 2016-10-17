package umsatz;

import static org.junit.Assert.*;

/**
 * Created by Andi on 10.10.2016.
 */
public class RechnungTest {

    private Position posi1;
    private Position posi2;
    private Position posi3;
    private Position posi4;
    private Position posi5;
    private Position posi6;
    private Position posi7;
    private Rechnung rechnEmpty;
    private Rechnung addrechnung;
    private Position[] posary;


    @org.junit.Before
    public void setUp() throws Exception {
        posi1=new Position(15,12,"Ganz teurer Bonbon!");
        posi2=new Position(0,40,"Fischsalat");
        posi3=new Position(0,0,"Hier gibs nix umsonst!");
        posi4=new Position(0,1,"Ein einzelnes Reiskorn");
        posi5=new Position(10,20,"Riesen Paket Käse");
        posi6=new Position(15,10,"Schinken Speck und Eiersalat");
        posi7=new Position(0,100,"Enorm viele Krabben");
        rechnEmpty=new Rechnung (1337);
        addrechnung=new Rechnung(9000);
        posary=new Position[]{posi1,posi2,posi3,posi4,posi5,posi6,posi7};
    }

    @org.junit.Test
    public void add() throws Exception {
        addrechnung.add(posi1);
        addrechnung.add(posi2);
        addrechnung.add(posi3);
        addrechnung.add(posi4);
        addrechnung.add(posi5);
        addrechnung.add(posi6);
        addrechnung.add(posi7);
        assertArrayEquals(posary,addrechnung.getPositionen());

    }

    @org.junit.Test
    public void rechnungsSumme() throws Exception {
        addrechnung.add(posi1);
        addrechnung.add(posi2);
        addrechnung.add(posi3);
        addrechnung.add(posi4);
        addrechnung.add(posi5);
        addrechnung.add(posi6);
        addrechnung.add(posi7);
        assertEquals(new GeldBetrag(40,183),addrechnung.rechnungsSumme());
    }
}