package procesy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.regex.MatchResult;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class oknoPoczatkowe extends JFrame implements ActionListener{
	
	static Timer timer;
	public String rezultattakto="";
	JButton zatwierdz=przyciskZatwierdz();
	JButton procesy=przyciskProcesy();
	JLabel napis=dialog();
	String procesString="";
	String procesyString=DisplayProcesses.getResult();
	List processes;
	JTextField input=nazwaProcesu();
	boolean klikniety=false;
	
	oknoPoczatkowe(){
		
		this.setSize(300,150);
		
		
		this.add(napis);
		this.add(input);
		this.add(zatwierdz);
		this.add(procesy);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public JButton przyciskZatwierdz() {
		JButton przycisk= new JButton("Zatwierdz");
		przycisk.setPreferredSize(new Dimension(95,25));
		przycisk.addActionListener(this);
		przycisk.setFocusable(false);
		przycisk.setBackground(Color.gray);
		return przycisk;
	}

	public JButton przyciskProcesy() {
		JButton przycisk=new JButton("Podejrzyj");
		przycisk.setPreferredSize(new Dimension(95,25));
		przycisk.addActionListener(this);
		przycisk.setFocusable(false);
		przycisk.setBackground(Color.gray);
		return przycisk;
	}
	
	public JLabel dialog() {
		JLabel dialog=new JLabel();
		dialog.setText("<html> Podaj nazwę procesu który chcesz śledzić </html>");
		return dialog;
		
	} 
	
	public JTextField nazwaProcesu() {
		JTextField nazwa=new JTextField();
		nazwa.setPreferredSize(new Dimension(200,25));
		return nazwa;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==zatwierdz)
		{
			procesString=input.getText();
			System.out.println(procesString);
			Timer1.proces=procesString;
			
			new Timer1();
			timer=new Timer();
			timer.schedule(Timer1.timertask,new Date(),1000);
			this.setVisible(false);
			
			
		}
		if(e.getSource()==procesy)
		{
			
			if(klikniety==false) {
				
				wyswietlenieprocesow();
				klikniety=true;
			}
			else {
				String rezultatnowszy=odczytanieprocesow();
				//System.out.println(rezultatnowszy);
				String roznica=rozniceProcesy(rezultattakto,rezultatnowszy);
				System.out.println("ROZNICA ELO==== "+roznica);
				klikniety=false;
			}
			
		}
	}
	public void wyswietlenieprocesow() {
		processes=Procesy.listRunningProcesses();
		DisplayProcesses.Display(processes);
		String result=DisplayProcesses.getResult();
		showMessage(result);
		zapisanieprocesow(result);
		rezultattakto=result;
		
	}
	
	public void showMessage(String result) {
		
		JOptionPane.showMessageDialog(this,
			    result);
	}
	
	public void zapisanieprocesow(String result) {
		

		try {
			Files.writeString(Paths.get("procesy.txt"), result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String odczytanieprocesow(){
		
		String rezultat="";
		File openFile=new File("procesy.txt");
		Scanner skaner = null;
		try {
			skaner = new Scanner(openFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String linia=skaner.nextLine();
		rezultat+=linia;
		while(skaner.hasNextLine()) {
			linia=skaner.nextLine();
			rezultat+=linia+"\n";
			 
			
		}
		
		return rezultat;
	}
	
	public String rozniceProcesy(String przed, String po) {
		String roznica="";
		String chuj="";
		int dlpo=po.length();
		char[] tablicapo=new char[dlpo];
		int dlprzed=przed.length();
		char[] tablicaprzed=new char[dlprzed];
		
		for(int i=0;i<dlpo;i++) {
			tablicapo[i]=po.charAt(i);
		}
		
		
		for(int i=0;i<dlprzed;i++) {
			tablicaprzed[i]=przed.charAt(i);
		}
		for(int i=0;i<dlpo;i++) {
			if(tablicapo[i]==tablicaprzed[i]) {
				
				tablicapo[i]='+';
				chuj=chuj+tablicapo[i];
				if(i==50) {
					chuj=chuj+"\n";
				}
			}
			System.out.println(tablicapo[i]);
		}
		showMessage(chuj);
		
		
		Scanner skanpo=new Scanner(po);
		Scanner skanprzed=new Scanner(przed);
		
		//while(skanpo.hasNextLine()) {
		//	if(skanpo.nextLine().equals(skanprzed.nextLine())) {
		//		skanpo-=skanprzed;
		//	}
			
			
		//}
		skanpo.findInLine(przed);
		Stream<MatchResult> pppo=skanpo.findAll(po);
		String rowek=pppo.toString();
		
		System.out.println("  ppppo ===="+pppo);
		po.replaceAll(rowek,"-" );
		System.out.println("  ROWEK ===="+rowek);
		
		
		//for(int i=dlprzed;i<dlpo;i++) {
		//	System.out.println(tablicapo[i]);
		//}
		
		return roznica;
	}
}
