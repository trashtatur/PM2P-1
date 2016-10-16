package umsatz;

public class Kasse {
    private Rechnung[] rechnungArray;
    private int count = 0;

    public Kasse(int init) {
        rechnungArray = new Rechnung[init];
    }

    public void addRechnung(Rechnung rechnung) {
        rechnungArray[count] = rechnung;
        ++count;
    }

    @Override
    public String toString() {
        String temp = "";
        for (Rechnung rech : rechnungArray) {
            temp += rech.toString() + "|||\n";
        }
        return temp;
    }

    public GeldBetrag kassenStand() {
        int euro = 0;
        int cent = 0;
        for (Rechnung rechnung : rechnungArray) {
            GeldBetrag geldBetrag = rechnung.rechnungsSumme();
            euro += geldBetrag.getEuro();
            cent += geldBetrag.getCent();
        }
        return new GeldBetrag(cent,euro);
    }

    public GeldBetrag summePosition(Position pos){
        for(Rechnung rechnung : rechnungArray){
            for(Position posRech : rechnung.getPositionen()){
                if(posRech.equals(pos)){

                }
            }
        }
    }
}
