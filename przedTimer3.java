package procesy;
import java.util.*;

public class przedTimer3 {
	
	double godziny;
	double minuty;
	double sekundy;
	static Timer timer3;
	
	przedTimer3(){
		
		godziny=sprawdzaeniePierwsze.getgodzinastart();
		minuty=sprawdzaeniePierwsze.getminutastart();
		sekundy=sprawdzaeniePierwsze.getsekundastart();
		
		
		new sprawdzanieDrugie();
		
		timer3=new Timer();
		
		new Timer3();
		timer3.schedule(Timer3.timertask3,new Date(), 1000);
		
		
		
	}
}
