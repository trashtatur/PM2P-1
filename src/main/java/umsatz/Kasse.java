package umsatz;

public class Kasse {
    private Rechnung[] rechnungArray;
    private int count = 0;

    public Kasse(int init){
        rechnungArray = new Rechnung[init];
    }

    public void addRechnung(Rechnung rechnung){
        rechnungArray[count] = rechnung;
        ++count;
    }

    @Override
    public String toString(){
        String temp = "";
        for(Rechnung rech : rechnungArray){
            temp += rech.toString()  + "|||\n";
        }
        return temp;
    }


}
