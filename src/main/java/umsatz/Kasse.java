package umsatz;

public class Kasse {
    private Array<Rechnung> rechnungArray;
    private int count = 0;

    public Kasse(int init){
        rechnungArray = new Array<Rechnung>(init);
    }

    public void addRechnung(Rechnung rechnung){
        rechnungArray[count] = rechnung;
        ++count;
    }

}
