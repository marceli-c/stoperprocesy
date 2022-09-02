package procesy;

import java.util.TimerTask;

public class Timer3 extends MyPanel{
	
	public static TimerTask timertask3;
	
	
	Timer3(){
	Zegar zegar=new Zegar();	
	
	timertask3=new TimerTask(){
		@Override
		public void run() {
			new sprawdzanieDrugie();
			MyPanel.godziny=(int)(sumowanieRoznicy.getGodzinyFinal());
			MyPanel.sekundy=(int)(sumowanieRoznicy.getSekundyFinal());
			MyPanel.minuty=(int)(sumowanieRoznicy.getMinutyFinal());
			
			zegar.panel.rep();
			
			
		}};
	}
}
