package procesy;

import java.util.List;
import java.util.TimerTask;

public class Timer2 {
 
	
	
	public static TimerTask timertask2;
	
	boolean elo=false;
	
	
	List processes;
	
	
	double godziny;
	double minuty;
	double sekundy;
	
	
	public Timer2(String proces){
		timertask2=new TimerTask(){
			@Override
			public void run() {
				
				godziny=sprawdzaeniePierwsze.getgodzinastart();
				minuty=sprawdzaeniePierwsze.getminutastart();
				sekundy=sprawdzaeniePierwsze.getsekundastart();
				
				processes=Procesy.listRunningProcesses();
				
				
				
				if(processes.contains(proces)==false)
				{
				
				new sprawdzanieDrugie();
				new oknoKoniec();
				Timer1.timer2.cancel();
				}
				
			}};
	}
	
}
