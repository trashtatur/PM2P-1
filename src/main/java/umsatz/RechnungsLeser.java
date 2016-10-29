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
		// Erzeugt ein Dateiobjekt f (File) aus dem Namen der Datei quelle
		// sowie einen Scanner, der das Dateiobjekt f liest.
		// Eine Zeile in der Datei entspricht einer Rechnung.
		File f = new File(Paths.get(quelle).toString());

		Scanner filescanner = new Scanner(f);

			//Regexps die der Scanner nutzt
			//------------------------------------
			Pattern delim=Pattern.compile("\\s*\\|{2}\\s*");						//Trennzeichen zwischen Elementen (Token) der Zeile

            Pattern rechnungsNRFinder=Pattern.compile("\\s*(\\d)\\s*");				//RegExp zum Finden der RechnungsNummer am Zeilenanfang

            Pattern positionFinder=Pattern.compile("\\s*([A-Za-z\\s]+)\\s*;\\s*(\\d+),?(\\d{0,2})");   //TODO use this string as a matcher Regexp. It is tested and works

			//-------------------------------------


		while (filescanner.hasNextLine() && filescanner.skip("\\s*").hasNextLine()) {

			String zeile=filescanner.nextLine();
			Scanner zeileScanner= new Scanner(zeile);

			zeileScanner.useDelimiter(delim);											//Zeilenscanner nutzt delim (   ||  ) als Trennzeichen für Token



            Matcher matcherRechnungsNr=rechnungsNRFinder.matcher(zeileScanner.next());  //Matcher zum Finden der RechnungsNr anhand des RegExp rechnungsNrFinder
			Rechnung rechnungforKasse;
			if (matcherRechnungsNr.matches()) {
				int rechnungsNr = Integer.valueOf(matcherRechnungsNr.group(1));                //Parsed den Output des Matchers für einen int Wert, da das return in String ist.
				rechnungforKasse = new Rechnung(rechnungsNr);                        //Baut mit dem umgewandelten Wert ein Rechnungsobjekt
				System.out.println(rechnungforKasse);                                        //Testausgabe der Rechnung um zu sehen ob die RN übernommen wurde
			}
			//Erstelle Rechnungsobjekt mit der Rechnungsnummer, also der ersten Zahl aus der Zeile




				while (zeileScanner.hasNext()) {            //Checkt ob noch Token vorhanden sind
					Matcher matcherPosFinder = positionFinder.matcher(zeileScanner.next());
					GeldBetrag posgeldBetrag;
					if (matcherPosFinder.matches()) {
						int euro = Integer.valueOf(matcherPosFinder.group(2));

						if (matcherPosFinder.groupCount()==3) {
							int cent = Integer.valueOf(matcherPosFinder.group(3));
							GeldBetrag posgeldBetrag = new GeldBetrag(euro, cent);
						}
						else {
							GeldBetrag posgeldBetrag = new GeldBetrag(euro);
						}


						Position posForRechnung = new Position(posgeldBetrag, matcherPosFinder.group(1));

						rechnungforKasse.add(posForRechnung);
					}
				}

			zeileScanner.close();
			kasse.add(rechnungforKasse);
		}
		filescanner.close();
		return kasse;
	}
}
