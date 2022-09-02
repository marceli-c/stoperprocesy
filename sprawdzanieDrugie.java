package procesy;

import java.time.LocalDateTime; 


import javax.swing.JFrame;
import javax.swing.JLabel;

public class sprawdzanieDrugie {
	
	static LocalDateTime data2;
	static double godzina;
	static double minuta;
	static double sekundy;
	public sprawdzanieDrugie() {
		
		
		
			data2=LocalDateTime.now();
	    	 godzina=data2.getHour();
	    	 minuta=data2.getMinute();
	    	 sekundy=data2.getSecond();
	    	new sumowanieRoznicy();
	    	

		
	}
	public static double getGodzina() {
		return godzina;
	}
	public static double getMinuta() {
		return minuta;
	}
	public static double getSekunda() {

		return sekundy;
	}
	public static LocalDateTime getDataKoniec() {
		return data2;
	}
	
	
}
