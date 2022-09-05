package procesy;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class Zegar extends JFrame implements MouseMotionListener,MouseListener,ActionListener{

	int xPress=0;
    int yPress=0;
    JPopupMenu menu;
    JMenuItem zakoncz;
    JMenuItem kolorzielony;
    JMenuItem kolorczarny;
    JMenuItem kolorbialy;
    ImageIcon img = new ImageIcon("clock.png");
    
	public static MyPanel panel;
	
	public Zegar() {
		
		menuPop();
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setUndecorated(true);
		this.setBackground(new Color(0,0,0,0));
		this.setSize(1300,420);
		panel=new MyPanel();
		this.add(panel); 
		this.setVisible(true);
		//this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		//this.setType(javax.swing.JFrame.Type.UTILITY); 
		this.setAlwaysOnTop(true);	
		this.setIconImage(img.getImage());
		
	}
	public void menuPop() {
		menu=stworzPopupMenu();
		zakoncz=stworzMenuItem("Zakończ");
		kolorzielony=stworzMenuItem("Kolor zielony");
		kolorczarny=stworzMenuItem("Kolor czarny");
		kolorbialy=stworzMenuItem("Kolor bialy");
		menu.add(kolorzielony);
		menu.add(kolorczarny);
		menu.add(kolorbialy);
		menu.add(zakoncz);
		zakoncz.addActionListener(this);
		kolorzielony.addActionListener(this);
		kolorbialy.addActionListener(this);
		kolorczarny.addActionListener(this);
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) 
	{
		drag(e);
		
	}
	@Override
	public void mouseMoved(MouseEvent e) 
	{
			xPress = e.getX();
			yPress = e.getY();
	}
	public void drag(MouseEvent e)
	{
		int xDrag = e.getX();
	    int yDrag = e.getY();

	    JFrame sFrame = (JFrame) e.getSource();
	    sFrame.setLocation(sFrame.getLocation().x+xDrag-xPress, 
	    sFrame.getLocation().y+yDrag-yPress);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON3) {
			popUp(e);
		}
		
	}
	public JMenuItem stworzMenuItem(String tekst) {
		JMenuItem item=new JMenuItem(tekst);
		return item;
	}
	public JPopupMenu stworzPopupMenu() {
		JPopupMenu menu=new JPopupMenu();
		return menu;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==kolorzielony) {
			MyPanel.setKolor(Color.green);
		}
		if(e.getSource()==kolorczarny) {
			MyPanel.setKolor(Color.black);
		}
		if(e.getSource()==kolorbialy) {
			MyPanel.setKolor(Color.white);
		}
		if(e.getSource()==zakoncz) {
			new sprawdzanieDrugie();
			new oknoKoniec();
			Timer1.timer2.cancel();
			this.setVisible(false);
		}
	}
	public void popUp(MouseEvent e) {
		menu.show(e.getComponent(),e.getX(),e.getY());
	}
	public void rep() {
		panel.rep();
	}
	
	
	
	
	
	
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	//public static void setVisible(boolean bol) {
	//	this.setVisible(bol);
	//}
}
