package procesy; 

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;

public class oknoKoniec implements ActionListener{

	JButton przycisk;
	
	public oknoKoniec() {
		
		ImageIcon img = new ImageIcon("clock.png");
		new zapisCzasu();
		new odczytCzasu();
		int roznicagodziny=(int)sumowanieRoznicy.getGodzinyFinal();
    	int roznicaminuty=(int)sumowanieRoznicy.getMinutyFinal();
    	int roznicasekundy=(int)sumowanieRoznicy.getSekundyFinal();
    	JLabel sesjalabel;
    	JLabel dzienlabel;
    	JLabel tydzienlabel;
    	JLabel miesiaclabel;
    	JLabel roklabel;
    	JLabel procesik;
    	JPanel panel=stworzPanel();
    	
    	String proces="<html> W Programie "+oknoPoczatkowe.getNazwaProcesu().replaceAll(".exe", " ")+"spędziłeś:<br>";
    	String sesja="<html>Podczas tej sesji:<br>Godzin:"+roznicagodziny+" Minut:"+roznicaminuty+" Sekund:"+roznicasekundy;
    	String dzien="<html><br>W tym dniu:<br>"+odczytCzasu.getCzasDzien();
    	String tydzien="<html><br>W tym tygodniu:<br>"+odczytCzasu.getCzasTydzien();
    	String miesiac="<html><br>W tym miesiącu:<br>"+odczytCzasu.getCzasMiesiac();
    	String rok="<html><br>W tym roku:<br>"+odczytCzasu.getCzasRok()+"<br>";
    	
    	procesik=labelb(proces);
    	sesjalabel=labelb(sesja);
    	dzienlabel=labelb(dzien);
    	tydzienlabel=labelb(tydzien);
    	miesiaclabel=labelb(miesiac);
    	roklabel=labelb(rok);
    	
    	
    	
    	przycisk=przycisk("Zakończ");
    	
    	JFrame frame=new JFrame();
    	
    	
    	
    	panel.add(procesik);
    	panel.add(sesjalabel);
    	panel.add(dzienlabel);
    	panel.add(tydzienlabel);
    	panel.add(miesiaclabel);
    	panel.add(roklabel);
    	panel.add(przycisk);
    	
    	frame.add(panel);
    	panel.setLayout(new FlowLayout());
    	frame.setTitle("Spędzony czas");
    	frame.setSize(250,360);
    	frame.setResizable(false);
    	frame.setUndecorated(true);
    	frame.getRootPane().setWindowDecorationStyle(JRootPane.WARNING_DIALOG);
    	frame.setLayout(null);
    	frame.getContentPane().setBackground(Color.black);
    	frame.getContentPane().setForeground(Color.white);
    	frame.setLocationRelativeTo(null);
    	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    	frame.setVisible(true);
    	frame.setIconImage(img.getImage());
    	przedTimer3.timer3.cancel();
    	
	}
	public JLabel labelb(String tekst) {
		JLabel label=new JLabel(tekst);
		label.setForeground(Color.green);
		return label;
	}
	public JButton przycisk(String tekst) {
		JButton przycisk=new JButton(tekst);
		przycisk.setPreferredSize(new Dimension(95,25));
		przycisk.addActionListener(this);
		przycisk.setFocusable(false);
		przycisk.setBackground(new Color(46,46,42));
		przycisk.setForeground(Color.green);
		return przycisk;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==przycisk) {
			System.exit(0);
		}
		
	}
	
	public JPanel stworzPanel() {
		JPanel panel=new JPanel();
		panel.setBounds(10,10,225,305);
		panel.setBackground(Color.black);
		return panel;
	}
	
}
