package procesy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.DayOfWeek;

public class zapisCzasu {

	
	String nazwa=oknoPoczatkowe.getNazwaProcesu();
	
	
	String godzina="g "+String.valueOf((int)sumowanieRoznicy.getGodzinyFinal())+"\n";
	String minuta="m "+String.valueOf((int)sumowanieRoznicy.getMinutyFinal())+"\n";
	String sekunda="s "+String.valueOf((int)sumowanieRoznicy.getSekundyFinal())+"\n";
	String dzien="d "+String.valueOf(sumowanieRoznicy.getDzien().getValue())+"\n";
	String miesiac="p "+String.valueOf(sumowanieRoznicy.getMonth())+"\n";
	String rok="r "+String.valueOf(sumowanieRoznicy.getYear())+"\n";
	String godzinazakonczenia="h "+String.valueOf(sumowanieRoznicy.getGodzinaZakonczenia())+"\n";
	String dzienroku="b "+String.valueOf(sumowanieRoznicy.getDzienRoku())+"\n";
	
	String pelny=godzina+minuta+sekunda+godzinazakonczenia+miesiac+rok+dzien+dzienroku;
	
	zapisCzasu(){
		nazwa=nazwa.replaceAll(".exe", ".txt");
			write();
		
	}
	
	
	public void write(){
try {
			
			Files.writeString(Paths.get(nazwa), pelny,StandardOpenOption.APPEND);
			
		} catch (IOException e) {
			
			
			try {
				Files.writeString(Paths.get(nazwa), pelny);
			} catch (IOException e1) {
				
			}
		}
	}
	
}

