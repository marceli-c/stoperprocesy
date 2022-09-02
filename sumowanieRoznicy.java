package procesy;

import java.time.Duration;
import java.time.LocalDateTime;

public class sumowanieRoznicy {

	static int roznicagodziny;
	static int roznicaminuty;
	static long roznicasekundy;
	
	public sumowanieRoznicy() {
		
		
		LocalDateTime poczatek=sprawdzaeniePierwsze.getDataPoczatek();
		LocalDateTime koniec=sprawdzanieDrugie.getDataKoniec();
		
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
} 
