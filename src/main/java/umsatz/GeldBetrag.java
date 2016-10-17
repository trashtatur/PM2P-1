package umsatz;

/**
 * Created by andi on 06.10.16.
 */
public class GeldBetrag {
	private int cent;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cent;
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
		if (cent != other.cent)
			return false;
		return true;
	}

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
        this.cent = cent + euro*100;
    }


    public GeldBetrag add(GeldBetrag betrag){
        this.cent += betrag.cent;
        return this;
    }

    public String toString() {
        return cent%100 == 0 ? cent/100 + " Euro" : cent/100 + "," + cent%100 + " Euro";
    }
}
