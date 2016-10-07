package umsatz;

/**
 * Created by andi on 06.10.16.
 */
public class GeldBetrag {
    private int cent;
    private int euro;


    public GeldBetrag() {

        this(0,0);
    }

    public GeldBetrag(int cent, int euro) {
        this.cent = cent;
        this.euro = euro;
    }

    public int getCent() {

        return cent;
    }

    public int getEuro() {

        return euro;
    }

    public GeldBetrag add(GeldBetrag betrag1, GeldBetrag betrag2){
        int cent=betrag1.getCent()+betrag2.getCent();
        int euro=betrag1.getEuro()+betrag2.getEuro();
        return new GeldBetrag(cent, euro);
    }

    public String toString() {
        return cent == 0 ? euro + "€" : euro + "," + cent + "€";
    }
}
