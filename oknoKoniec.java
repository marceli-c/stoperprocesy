package procesy; 

import javax.swing.JFrame;
import javax.swing.JLabel;

public class oknoKoniec {

	
	public oknoKoniec() {
		double roznicagodziny=sumowanieRoznicy.getGodzinyFinal();
    	double roznicaminuty=sumowanieRoznicy.getMinutyFinal();
    	double roznicasekundy=sumowanieRoznicy.getSekundyFinal();
    	
    	String roznica="Godziny ="+roznicagodziny+" Minuty= "+roznicaminuty+" Sekundy = "+roznicasekundy;
    	System.out.println("Rożniuca= "+roznica);
    	JFrame frame=new JFrame();
    	JLabel label=new JLabel(roznica);
    	frame.add(label);
    	frame.pack();
    	frame.setLocationRelativeTo(null);
    	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    	frame.setVisible(true);
    	przedTimer3.timer3.cancel();
	}
}
