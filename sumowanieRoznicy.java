package procesy;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;

public class sumowanieRoznicy {

	static int roznicagodziny;
	static int roznicaminuty;
	static long roznicasekundy;
	static LocalDateTime poczatek;
	static LocalDateTime koniec;
	
	public sumowanieRoznicy() {
		
		sumowanieRoznicy.poczatek=sprawdzaeniePierwsze.getDataPoczatek();
		sumowanieRoznicy.koniec=sprawdzanieDrugie.getDataKoniec();
		
		
		Duration trwanie=Duration.between(poczatek, koniec);
		
		roznicasekundy=trwanie.getSeconds();
		roznicaminuty=0;
		roznicagodziny=0;
		while(roznicasekundy>60)
		{
			roznicaminuty=roznicaminuty+1;
			roznicasekundy=roznicasekundy-60;
			
			while (roznicaminuty>60)
			{
				roznicagodziny=roznicagodziny+1;
				roznicaminuty=roznicaminuty-60;
			}
			
		}
			
			
		//double godzinastart=sprawdzaeniePierwsze.getgodzinastart();
		//double minutastart=sprawdzaeniePierwsze.getminutastart();
		//double sekundastart=sprawdzaeniePierwsze.getsekundastart();
		
		//double godzina=sprawdzanieDrugie.getGodzina();
		//double minuta=sprawdzanieDrugie.getMinuta();
		//double sekundy=sprawdzanieDrugie.getSekunda();
		
		System.out.println("Trwanie === "+trwanie);
		//roznicagodziny=godzina-godzinastart;
    	//roznicaminuty=minuta-minutastart;
    	//roznicasekundy=sekundy;
    	//if(roznicaminuty==0&&roznicagodziny==0) {
    	//	roznicasekundy=sekundy-sekundastart;
    	//}
    	
    	
	}
	
	
	static double getGodzinyFinal() {
		return roznicagodziny;
	}
	static double getMinutyFinal() {
		return roznicaminuty;
	}
	static double getSekundyFinal() {
		return roznicasekundy;
	}
	static DayOfWeek getDzien() {
		return koniec.getDayOfWeek();
		
	}
	static int getMonth() {
		return koniec.getMonthValue();
	}
	static int getYear() {
		return koniec.getYear();
	}
	static int getGodzinaZakonczenia() {
		return koniec.getHour();
	}
	static int getDzienRoku() {
		return koniec.getDayOfYear();
	}
} 
