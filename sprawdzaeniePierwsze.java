package procesy;

import java.time.LocalDateTime;



public class sprawdzaeniePierwsze {
	
	
	static LocalDateTime data1;
	static double godzina1=0;
	static double minuta1=0;
	static double sekundy1=0;
 

	
	public sprawdzaeniePierwsze(){
				
						data1=LocalDateTime.now();
				    	godzina1=data1.getHour();
				    	minuta1=data1.getMinute();
				    	sekundy1=data1.getSecond();
				    	System.out.println("Godziny ="+godzina1+" Minuty= "+minuta1+" Sekundy = "+sekundy1);
				    	
				    	//elo=true;
				    	
				
			
	}

	
	public static double getgodzinastart() {
		return godzina1;
	}
	
	public static double getminutastart() {
		return minuta1;
	}

	public static double getsekundastart() {
	return sekundy1;
}
	
	public static LocalDateTime getDataPoczatek() {
		
		return data1;
	}
}
