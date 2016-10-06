package umsatz;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
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
		Scanner sc = new Scanner(f);
		//TODO hier fehlt das Auswerten der Dateiinhalte!!!!!
		sc.close();
		return kasse;
	}

}
