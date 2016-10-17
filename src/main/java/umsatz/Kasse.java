package umsatz;

import java.util.Arrays;

public class Kasse {
	private Rechnung[] rechnungArray;
	private int count = 0;
	private int nemo = 5;

	public Kasse() {
		rechnungArray = new Rechnung[nemo];
	}

	public void add(Rechnung rechnung) {
		if (count - 1 <= nemo) {
			rechnungArray = Arrays.copyOf(rechnungArray, rechnungArray.length + 2);
			nemo += 2;
		}
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
		GeldBetrag betrag = new GeldBetrag();

		for (Rechnung rechnung : rechnungArray) {
			if (rechnung != null) {
				betrag.add(rechnung.rechnungsSumme());
			}
		}
		return betrag;
	}

	public GeldBetrag summePosition(Position pos) {
		if (pos == null) {
			return new GeldBetrag();
		}
		GeldBetrag betrag = new GeldBetrag();
		for (Rechnung rechnung : rechnungArray) {
			if (rechnung != null) {
				betrag = betrag.add(rechnung.summePosition(pos));
			}
		}
		return betrag;
	}
}
