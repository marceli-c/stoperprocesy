package procesy;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class odczytCzasu {

	String nazwa=oknoPoczatkowe.getNazwaProcesu();
	
	int godzinydzien1=0;
	int minutydzien1=0;
	int sekundydzien1=0;
	
	int godziny=0;
	int minuty=0;
	int sekundy=0;
	
	static int godzinydzien=0;
	static int minutydzien=0;
	static int sekundydzien=0;
	
	static int godzinyrok=0;
	static int minutyrok=0;
	static int sekundyrok=0;
	static int dnirok=0;
	
	static int godzinytydzien=0;
	static int minutytydzien=0;
	static int sekundytydzien=0;
	static int dnitydzien=0;
	
	static int godzinymiesiac=0;
	static int dnimiesiac=0;
	static int minutymiesiac=0;
	static int sekundymiesiac=0;
	
	int godzinaodczyt=0;
	//int minutaodczyt=0;
	int dzienodczyt=0;
	//int sekundaodczyt=0;
	int miesiacodczyt=0;
	int rokodczyt=0;
	int dzienrokuodczyt=0;
	
	LocalDateTime czas=LocalDateTime.now();
	int godzinateraz=czas.getHour();
	int dzienteraz=czas.getDayOfMonth();
	int miesiacteraz=czas.getMonthValue();
	int rokteraz=czas.getYear();
	int dzienrokuteraz=czas.getDayOfYear();
	
	odczytCzasu(){
		
		
		
		
		
		
		nazwa=nazwa.replaceAll(".exe", ".txt");
		
		Scanner skaner=skaner();

		while(skaner.hasNextLine()) {
			
			
			
			if(skaner.next().charAt(0)=='g') {
				
				godziny=rownanie(skaner);
			}
			if(skaner.next().charAt(0)=='m') {
				
				minuty=rownanie(skaner);
			}
			if(skaner.next().charAt(0)=='s') {
				
				sekundy=rownanie(skaner);
			}
			if(skaner.next().charAt(0)=='h') {
				
				godzinaodczyt=rownanie(skaner);
			}
			
			if(skaner.next().charAt(0)=='p') {
				miesiacodczyt=rownanie(skaner);
				//System.out.println("Miesiac wtedy "+miesiacodczyt);
				
			}
			if(skaner.next().charAt(0)=='r') {
				rokodczyt=rownanie(skaner);
				if(rokteraz==rokodczyt) {
					//godzinyrok+=godziny
				}
			}
			if(skaner.next().charAt(0)=='d') {
				
				dzienodczyt=rownanie(skaner);
				
			}
			if(skaner.next().charAt(0)=='b') {
				
				dzienrokuodczyt=rownanie(skaner);
			}
			
			liczDni();
			liczTydzien();
			liczMiesiac();
			liczRok();
			
			
				
		}
		
		
		
		System.out.println("godziny dzien="+godzinydzien);
		System.out.println("minuty dzien="+minutydzien);
		System.out.println("sekundy dzien="+sekundydzien);
		
		System.out.println("godziny tydzien="+godzinytydzien);
		System.out.println("minuty tydzien="+minutytydzien);
		System.out.println("sekundy tydzien="+sekundytydzien);
		
		System.out.println("godziny miesiac="+godzinymiesiac);
		System.out.println("minuty miesiac="+minutymiesiac);
		System.out.println("sekundy miesiac="+sekundymiesiac);
		
		System.out.println("godziny rok="+godzinyrok);
		System.out.println("minuty rok="+minutyrok);
		System.out.println("sekundy rok="+sekundyrok);
		
		
		System.out.println("sekundyu=" + sekundy);
		System.out.println("minuty=" + minuty);
		
	}
	
	
	private Scanner skaner() {
		File openFile=new File(nazwa);
		
		try {
			Scanner skaner=new Scanner(openFile);
			return skaner;
		} catch (FileNotFoundException e) {
			
			System.out.println("Coś nie tak");
			return null;
		}
		
		
	}
	
	
	public int rownanie(Scanner skaner) {
		return Integer.parseInt(skaner.nextLine().replaceAll(" ", ""));
	}
	
	public void liczDni() {
		//System.out.println(miesiacodczyt);
		//System.out.println("dzien teraz="+dzienrokuteraz);
		//System.out.println("dzien odczyt="+dzienrokuodczyt);
		//System.out.println("Godzina teraz= "+godzinateraz);
		//System.out.println("Godzina odczyt= "+godzinaodczyt);
		if(
			( dzienrokuteraz==dzienrokuodczyt || dzienrokuteraz==dzienrokuodczyt+1 && godzinateraz<godzinaodczyt)
			 && (((dzienrokuodczyt-dzienrokuteraz)<=31 && miesiacteraz==miesiacodczyt+1) || miesiacteraz==miesiacodczyt) 
			 && ((rokteraz==rokodczyt) || (rokodczyt+1==rokteraz&&dzienrokuteraz<dzienrokuodczyt))){
			
					godzinydzien+=godziny;
					minutydzien+=minuty;
					sekundydzien+=sekundy;
					
			} 
		while(sekundydzien>=60) {
			sekundydzien-=60;
			minutydzien+=1;
		}
		while(minutydzien>=60) {
			minutydzien-=60;
			godzinydzien+=1;
		}
		
			
	}
	public void liczTydzien() {
		
		if(((dzienrokuteraz-dzienrokuodczyt)<=7 ||(dzienrokuteraz-dzienrokuodczyt)==8 && godzinateraz<godzinaodczyt) && 
				(((dzienodczyt-dzienteraz)<=31 && miesiacteraz==miesiacodczyt+1) || miesiacteraz==miesiacodczyt)
				&& ((rokteraz==rokodczyt) || (rokodczyt+1==rokteraz&&dzienrokuteraz<dzienrokuodczyt))){
				
					godzinytydzien+=godziny;
					minutytydzien+=minuty;
					sekundytydzien+=sekundy;
					
		}
		while(sekundytydzien>=60) {
			sekundytydzien-=60;
			minutytydzien+=1;
		}
		while(minutytydzien>=60) {
			minutytydzien-=60;
			godzinytydzien+=1;
		}
		while(godzinytydzien>=24) {
			godzinytydzien-=24;
			dnitydzien+=1;
		}
	}
	public void liczMiesiac() {
		if(((dzienrokuteraz-dzienrokuodczyt)<=31 && miesiacteraz==miesiacodczyt+1 
				||	miesiacteraz==miesiacodczyt) 
				&& ((rokteraz==rokodczyt) || (rokodczyt+1==rokteraz&&dzienrokuteraz<dzienrokuodczyt))){
				
					godzinymiesiac+=godziny;
					minutymiesiac+=minuty;
					sekundymiesiac+=sekundy;

		}
		while(sekundymiesiac>=60) {
			sekundymiesiac-=60;
			minutymiesiac+=1;
		}
		while(minutymiesiac>=60) {
			minutymiesiac-=60;
			godzinymiesiac+=1;
		}
		while(godzinymiesiac>=24) {
			godzinymiesiac-=24;
			dnimiesiac+=1;
		}
		
	}
	public void liczRok() {
		if(
				(rokodczyt==rokteraz) ||
				(rokodczyt+1==rokteraz && dzienrokuteraz<dzienrokuodczyt)) {
			
			
			godzinyrok+=godziny;
			minutyrok+=minuty;
			sekundyrok+=sekundy;
		}
		while(sekundyrok>=60) {
			sekundyrok-=60;
			minutyrok+=1;
		}
		while(minutyrok>=60) {
			minutyrok-=60;
			godzinyrok+=1;
		}
		while(godzinyrok>=24) {
			godzinyrok-=24;
			dnirok+=1;
		}
	
	
	}
	public static String getCzasRok() {
		if(dnirok>=1) {
			String rok="Dni: "+dnirok+" Godzin:"+String.valueOf(godzinyrok)+" Minut:"+String.valueOf(minutyrok)+" Sekund:"+String.valueOf(sekundyrok);
			return rok;
		}
		else {
			String rok="Godzin:"+String.valueOf(godzinyrok)+" Minut:"+String.valueOf(minutyrok)+" Sekund:"+String.valueOf(sekundyrok);
			return rok;
		}
	}
	public static String getCzasMiesiac() {
		if(dnimiesiac>=1) {
			String miesiac="Dni: "+dnimiesiac+" Godzin:"+String.valueOf(godzinymiesiac)+" Minut:"+String.valueOf(minutymiesiac)+" Sekund:"+String.valueOf(sekundymiesiac);
			return miesiac;
		}
		else {
			String miesiac="Godzin:"+String.valueOf(godzinymiesiac)+" Minut:"+String.valueOf(minutymiesiac)+" Sekund:"+String.valueOf(sekundymiesiac);
			return miesiac;
		}
		
	}
	public static String getCzasTydzien() {
		if(dnitydzien>=1) {
			String tydzien="Dni:"+dnitydzien+" Godzin:"+String.valueOf(godzinytydzien)+" Minut:"+String.valueOf(minutytydzien)+" Sekund:"+String.valueOf(sekundytydzien);
			return tydzien;
		}
		else {
			String tydzien="Godzin:"+String.valueOf(godzinytydzien)+" Minut:"+String.valueOf(minutytydzien)+" Sekund:"+String.valueOf(sekundytydzien);
			return tydzien;
		}
	}
	public static String getCzasDzien() {
		String dzien="Godzin:"+String.valueOf(godzinydzien)+" Minut:"+String.valueOf(minutydzien)+" Sekund:"+String.valueOf(sekundydzien);
		return dzien;
	}
	
}