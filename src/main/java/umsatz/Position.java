package umsatz;

/**
 * Created by the Creator, the great and only King, Prince and God, holy ghost and Master of every mortal beeing Philipp on 06.10.2016.
 */
public class Position {
    private GeldBetrag geldBetrag;
    private String gerichtOderGetraenk;

    public Position(GeldBetrag geldBetrag, String gerichtOderGetraenk){
        this.gerichtOderGetraenk = gerichtOderGetraenk;
        this.geldBetrag = geldBetrag;
    }

    GeldBetrag getPrice(){

        return geldBetrag;
    }


	@Override
	public String toString() {
		return "Position{"+"GB:" + geldBetrag.toString() + ","+"PN:"+ gerichtOderGetraenk + '\'' + '}';
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gerichtOderGetraenk == null) ? 0 : gerichtOderGetraenk.hashCode());
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
		Position other = (Position) obj;
		if (gerichtOderGetraenk == null) {
			if (other.gerichtOderGetraenk != null)
				return false;
		} else if (!gerichtOderGetraenk.equals(other.gerichtOderGetraenk))
			return false;
		return true;
	}

    
    
}
