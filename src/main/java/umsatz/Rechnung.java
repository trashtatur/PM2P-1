package umsatz;

        import java.util.Arrays;

/**
 * Created by andi on 06.10.16.
 */
public class Rechnung {
    private int rechnungsnummer;
    private int initialeKapazitaet;
    private int cursor;
    private Position positionen[];
    private int erweiternUm;




    public Rechnung(int rechnungsnummer) {
        this.rechnungsnummer = rechnungsnummer;
        this.initialeKapazitaet = 5;
        this.cursor = 0;
        this.positionen = new Position[initialeKapazitaet];
        this.erweiternUm=2;
    }

    public void add (Position pos) {
        if (!(cursor<positionen.length)) {
            positionen=Arrays.copyOf(positionen,positionen.length+erweiternUm);
        }
        positionen[cursor]=pos;
        cursor++;
    }

    public GeldBetrag rechnungsSumme() {
        GeldBetrag temp = new GeldBetrag();
        for (Position posi: positionen)
            if (posi!=null) {
            {
                temp.add(posi.getPrice());
            }
        }
        return temp;
    }
    
    public Position[] getPositionCopy(){
    	
    	return positionen.clone();
    }

    public String toString() {
        Position[] tempary=Arrays.copyOf(positionen,cursor);
        return "Rechnung{" +
                "rechnungsnummer=" + rechnungsnummer +
                ", positionen=" + Arrays.toString(tempary) +
                '}';
    }
    
    public GeldBetrag summePosition(Position pos){
    	GeldBetrag betrag = new GeldBetrag();
    	for(Position temp : positionen){
    		if(temp != null && temp.equals(pos)){
    			betrag.add(temp.getPrice());
    		}
    	}
    	return betrag;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(positionen);
		result = prime * result + rechnungsnummer;
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
		Rechnung other = (Rechnung) obj;
		if (!Arrays.equals(positionen, other.positionen))
			return false;
		if (rechnungsnummer != other.rechnungsnummer)
			return false;
		return true;
	}
    
    
}
