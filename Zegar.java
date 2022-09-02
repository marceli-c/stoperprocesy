package procesy;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Zegar extends JFrame implements MouseMotionListener{

	int xPress=0;
    int yPress=0;
    
    
	public static MyPanel panel;
	
	public Zegar() {
		this.addMouseMotionListener(this);
		this.setUndecorated(true);
		this.setBackground(new Color(0,0,0,0));
		this.setSize(1300,420);
		panel=new MyPanel();
		this.add(panel); 
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
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
	
	
}
