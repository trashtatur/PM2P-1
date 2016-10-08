package umsatz;

/**
 * Created by the Creator, the great and only King, Prince and God, holy ghost and Master of every mortal beeing Philipp on 06.10.2016.
 */
public class Position {
    private GeldBetrag geldBetrag;
    private String gerichtOderGetraenk;

    public Position(int cent,int euro, String gerichtOderGetraenk){
        this.gerichtOderGetraenk = gerichtOderGetraenk;
        geldBetrag = new GeldBetrag(cent,euro);
    }

    public GeldBetrag getPrice(){

        return geldBetrag;
    }

    public String getGerichtOderGetraenk(){

        return gerichtOderGetraenk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return gerichtOderGetraenk != null ? gerichtOderGetraenk.equals(position.gerichtOderGetraenk) : position.gerichtOderGetraenk == null;
    }
}
