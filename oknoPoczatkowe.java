package procesy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.regex.MatchResult;
import java.util.stream.Stream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class oknoPoczatkowe extends JFrame implements ActionListener,KeyListener{
	
	ImageIcon img = new ImageIcon("clock.png");
	static Timer timer;
	public String rezultattakto="";
	JButton zatwierdz=przyciskZatwierdz();
	JButton procesy=przyciskProcesy();
	JLabel napis=dialog();
	static String procesString="";
	String procesyString=DisplayProcesses.getResult();
	List processes;
	JTextField input=nazwaProcesu();
	boolean klikniety=false;
	Scanner przed;
	Scanner po;
	JButton przyciskmessage;
	
	
	
	
	oknoPoczatkowe(){
		
		this.setSize(300,150);
		this.add(napis);
		this.add(input);
		this.add(zatwierdz);
		this.add(procesy);
		this.setTitle("Stoper");
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.WARNING_DIALOG);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.getContentPane().setBackground(Color.black);
		this.getContentPane().setForeground(Color.white);
		this.setSize(300,130);
		this.setResizable(false);
		addKeyListener(this);
		input.addKeyListener(this);
		this.setIconImage(img.getImage());
		
		
	}
	
	
	
	public JButton przyciskZatwierdz() {
		JButton przycisk= new JButton("Zatwierdz");
		przycisk.setPreferredSize(new Dimension(95,25));
		przycisk.addActionListener(this);
		przycisk.setFocusable(false);
		przycisk.setBackground(new Color(46,46,42));
		przycisk.setForeground(Color.green);
		return przycisk;
	}

	
	
	public JButton przyciskProcesy() {
		JButton przycisk=new JButton("Podejrzyj");
		przycisk.setPreferredSize(new Dimension(95,25));
		przycisk.addActionListener(this);
		przycisk.setFocusable(false);
		przycisk.setBackground(new Color(46,46,42));
		przycisk.setForeground(Color.green);
		return przycisk;
	}
	
	
	
	
	public JLabel dialog() {
		JLabel dialog=new JLabel();
		dialog.setText("<html> Podaj nazwę procesu który chcesz śledzić </html>");
		dialog.setForeground(Color.white);
		return dialog;
		
		
	} 
	
	
	
	
	public JTextField nazwaProcesu() {
		JTextField nazwa=new JTextField();
		nazwa.setPreferredSize(new Dimension(200,25));
		nazwa.setBackground(Color.black);
		nazwa.setForeground(Color.green);
		return nazwa;
	}
	
	
	
	public static String getNazwaProcesu() {
		return procesString;
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==zatwierdz)
		{
			zatwierdz();
			
			
		}
		if(e.getSource()==procesy)
		{
			
			
				if(klikniety==false) {
				
				
					wyswietlenieprocesow();
					przed=new Scanner(DisplayProcesses.getResult());
					klikniety=true;
				
				
				
				}
				else if(klikniety==true) {
				
				
				
					List procesik=Procesy.listRunningProcesses();
					DisplayProcesses.Display(procesik);
					po=new Scanner(DisplayProcesses.getResult());		
					String roznica=rozniceProcesy();				
					wyswietlenieprocesow(roznica);
					klikniety=false;
				
				
				}
			
		}
	}
	
	
	
	
	public void wyswietlenieprocesow() {
		
		processes=Procesy.listRunningProcesses();
		DisplayProcesses.Display(processes);
		String result=DisplayProcesses.getResult();
		showMessage(result);
		
		
	}
	
	
	
	public void wyswietlenieprocesow(String rezultat) {
		
		showMessage(rezultat);
	}
	
	
	
	
	public void zatwierdz() {
		
		
		procesString=input.getText();
		System.out.println(procesString);
		Timer1.proces=procesString;
		new Timer1();
		timer=new Timer();
		timer.schedule(Timer1.timertask,new Date(),1000);
		this.setVisible(false);
		
		
	}
	
	
	
	
	public void showMessage(String result) {
		
		
		 Scanner skanerek=new Scanner(result);
		 String rezultat=roznica(skanerek);
		 UIManager UI=new UIManager();
		 
		 UI.put("OptionPane.background", Color.black);
		 UI.put("OptionPane.messageForeground", Color.white);
		 UI.put("Panel.background", Color.black);
		 	if (klikniety==false){
		 		JOptionPane.showMessageDialog(this, rezultat);
		 	}
		 	if(klikniety==true) {
				JOptionPane.showMessageDialog(this, "Nowe procesy: \n"+rezultat);
		 	}
		
	}
	
	
	
	public String roznica(Scanner skanerek) {
		String liniateraz="";
		String liniazaraz="";
		String rezultat="";
		int i=0;
		
		boolean glazik=false;
		
		while(skanerek.hasNextLine()) {
			if(glazik==false) {
				liniateraz=skanerek.nextLine();
				glazik=true;
				
			}
			else if(glazik==true) {
				liniazaraz=skanerek.nextLine();
				if(liniateraz.equals(liniazaraz)) {
					rezultat+=liniateraz+" , ";
					i++;
					glazik=false;
				}
				
				else {
					rezultat+=liniazaraz+" , "+liniateraz+" , ";
					i=i+2;
					glazik=false;
					
				}
				
			}
	
			if(i>=10) {
				rezultat+="\n\n";
				i=0;
			}
		}
		return rezultat;
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
	
	
	
	
	public String rozniceProcesy() {
		String result="";
		String liniaprzed="";
		String liniapo="";
		
		while(po.hasNextLine()) {
			
			while(przed.hasNextLine()) {
				liniaprzed=przed.nextLine();
					if(po.hasNextLine()) {
						liniapo=po.nextLine();
					}
					
				
				
				
				if(liniaprzed.equals(liniapo)==false) {
					result+=liniapo+"\n";
				}
					
			}
			if(po.hasNextLine()) {
				liniapo=po.nextLine();
				result+=liniapo+"\n";
			}
			System.out.println("elo");
			
		}
		
		
		return result;
		
		
	}

	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==10) {
			zatwierdz();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
