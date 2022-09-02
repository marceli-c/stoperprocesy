package procesy;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Timer1 {
	
	
	static String proces;
	
	
	
	public static TimerTask timertask;
	boolean elo=false;
	List processes; 
	static Timer timer2=new Timer();
	public Timer1(){
		timertask=new TimerTask(){
			@Override
			public void run() {
				processes=Procesy.listRunningProcesses();
				
				if(processes.contains(proces))
				{
				new sprawdzaeniePierwsze();
				new Timer2(proces);
				new przedTimer3();
				timer2.schedule(Timer2.timertask2,new Date(),1000);
				oknoPoczatkowe.timer.cancel();
				
				
				}
			}};
	}
	
}