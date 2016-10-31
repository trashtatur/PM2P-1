package umsatz;

/**
 * Created by andi on 06.10.16.
 */
public class GeldBetrag {
	private int money;



    public GeldBetrag() {
        this(0,0);
    }

    public GeldBetrag(int cent, int euro){
        if(cent < 0 || euro < 0){
            throw new IllegalArgumentException();

        }
        this.money = cent + euro*100;
    }

    public GeldBetrag(int cent){
        if(cent < 0){
            throw new IllegalArgumentException();
        }
        this.money=cent*100;
    }


    public GeldBetrag add(GeldBetrag betrag){
        this.money += betrag.money;
        return this;
    }

    public String toString() {
        return money%100 == 0 ? money/100 + " Euro" : money/100 + "," + money%100 + " Euro";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + money;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GeldBetrag other = (GeldBetrag) obj;
        if (money != other.money)
            return false;
        return true;
    }
}
