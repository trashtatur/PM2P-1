package umsatz;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RechnungsLeser {

	private String quelle;

	public RechnungsLeser(String string) {
		this.quelle = string;
	}

	public Kasse leseKasse() throws FileNotFoundException {
		ArrayList<Rechnung> rechnungen = new ArrayList<Rechnung>();
		File f = new File(Paths.get(quelle).toString());
		Scanner sc = new Scanner(f);
		while(sc.hasNextLine()){
			String line = sc.nextLine();
		//	Matcher matcher = new MatchResult();					}
		Kasse kasse = new Kasse(rechnungen.size());
		for(Rechnung bill : rechnungen){
			kasse.addRechnung(bill);
		}
		sc.close();
		return kasse;
	}
}
