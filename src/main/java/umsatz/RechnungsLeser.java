package umsatz;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RechnungsLeser {

	private String quelle;

	public RechnungsLeser(String string) {
		this.quelle = string;
	}

	public Kasse leseKasse() throws FileNotFoundException {

		Kasse kasse = new Kasse();
		ArrayList rechnungen=new ArrayList<Rechnung>();
		// Erzeugt ein Dateiobjekt f (File) aus dem Namen der Datei quelle
		// sowie einen Scanner, der das Dateiobjekt f liest.
		// Eine Zeile in der Datei entspricht einer Rechnung.
		File f = new File(Paths.get(quelle).toString());

		Scanner sc = new Scanner(f);

			//Variablen für Scanner
			//------------------------------------
			//Trennzeichen ist ||
			Pattern delim=Pattern.compile("\\s*(\\|{2})\\s*");
			Pattern matchstring=Pattern.compile("\\s*([A-Za-z\\s]+)\\s*;\\s*(\\d+),?(\\d{0,2})");   //TODO use this string as a matcher Regexp. It is tested and works
			//Zum erkennen der Leerzeichen
			Pattern leerZeichen=Pattern.compile("\\s*");

		while (sc.hasNextLine() && sc.skip(leerZeichen).hasNextLine()) {
			String zeile=sc.nextLine();
			Scanner zeileScanner= new Scanner(zeile);

			//Trennzeichen die oben definiert wurden werden nun per Zeile genutzt vom zeileScanner
			zeileScanner.useDelimiter(delim);

			//Erstelle Rechnungsobjekt mit der Rechnungsnummer, also der ersten Zahl aus der Zeile
			int rechnungsnummer=Integer.parseInt(zeileScanner.next());

			Rechnung rechnungVonZeile=new Rechnung(rechnungsnummer);
				String artikelname="";
				while (zeileScanner.hasNext()){
					if (zeileScanner.hasNextInt()){
						//TODO Geldbetrag muss korrekt von RegExp erfasst werden. ATM wird er nur die Stelle vor dem Komma dazupacken
						//TODO Also entweder den RegExp ändern oder hier in der Erstellung vom GeldBetrag
						rechnungVonZeile.add(new Position(new GeldBetrag(zeileScanner.nextInt()),artikelname));
					}
					else {
						artikelname=zeileScanner.next();
					}
				}
				kasse.add(rechnungVonZeile);
		}
		sc.close();
		return kasse;
	}
}
