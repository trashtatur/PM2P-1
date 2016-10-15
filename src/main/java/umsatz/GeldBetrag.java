package umsatz;
import  java.lang.*;

/**
 * Created by andi on 06.10.16.
 */
public class GeldBetrag {
    private int cent;
    private int euro;


    public GeldBetrag() {
        this(0,0);
    }

    public GeldBetrag(int cent, int euro){
        if(cent < 0 || euro < 0){
            throw new IllegalArgumentException();

        }
        formatMoney(cent,euro);
    }

    public GeldBetrag(int cent){
        if(cent < 0){
            throw new IllegalArgumentException();
        }
        formatMoney(cent, 0);
    }

    /**
     * Converts 100 cents to 1  euro. After cent < 100 the whhile loop stops. Then sets the Object Parameter to the correct value
     * @param cent expects a value as cent. Can be more then 100.
     * @param euro expects a value as Euro.
     */
    private void formatMoney(int cent, int euro) {
        while (cent>=100) {
            cent-=100;
            euro+=1;
        }
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
