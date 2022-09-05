package procesy;
import java.util.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.util.Date;

import javax.swing.JPanel;
 
public class MyPanel extends JPanel{
	Timer timer;
	static int godziny=0;//(int)(sumowanieRoznicy.getGodzinyFinal());
	static int sekundy=0;//(int)(sumowanieRoznicy.getSekundyFinal());
	static int minuty=0;//(int)(sumowanieRoznicy.getMinutyFinal());
	static int second1=4;
	static int second2=8;
	static int minute1=3;
	static int minute2=9;
	static int hour1=0;
	static int hour2=0;
	public static int minus=20;
	static Color kolorek=Color.white;
	
	MyPanel(){
		
		
		
		this.setPreferredSize(new Dimension(400,400));
		this.setBackground(new Color(0,0,0,0));
		this.setOpaque(false);
		
	}
	
	
	public void paint(Graphics g) {
		
		Graphics2D g2d=(Graphics2D) g;
		super.paint(g2d);
		g2d.setRenderingHint
        (
        	RenderingHints.KEY_ANTIALIASING,
        	RenderingHints.VALUE_ANTIALIAS_ON
        );
		g2d.setStroke(new BasicStroke(5,BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		//kolorek=kolor(Color.black);
		
		g2d.setColor(kolorek);
		
		
		/*drawOne(g2d,100,100);
		drawTwo(g2d,200,100);
		drawThree(g2d,300,100);
		drawFour(g2d,400,100);
		drawFive(g2d,500,100);
		drawSix(g2d,600,100);
		drawSeven(g2d,700,100);
		drawEight(g2d,800,100);
		drawNine(g2d,900,100);
		drawZero(g2d,1000,100);
		drawDelimeter(g2d,1200,100);*/
		
		getSeconds(sekundy);
		getHours(godziny);
		getMinutes(minuty);
		drawHour(g2d);
		drawDelimeter(g2d,100,30);
		drawMinutes(g2d);
		drawDelimeter(g2d,190,30);
		drawSeconds(g2d);
		
	}
	
	
	private void kropka(Graphics2D g,int x,int y) {
		g.fillRect(x, y, 5, 5);
	}
	private void liniapozioma(Graphics2D g,int x,int y) {
		
		g.drawLine(x,y,x+30-minus,y);
	}
	private void liniapozioma(Graphics2D g,int x,int y,int xx) {
		
		g.drawLine(x,y,xx,y);
	}
	private void liniapozioma(Graphics2D g,int x,int y,int xx,int yy) {
		
		g.drawLine(x,y,xx,yy);
	}
	private void liniapionowa(Graphics2D g,int x,int y) {
		g.drawLine(x, y, x, y+40-minus);
	}
	private void liniapionowa(Graphics2D g,int x,int y,int yy) {
		g.drawLine(x, y, x, yy);
	}
	private void kwadrat(Graphics2D g,int x,int y) {
		
		g.drawRoundRect(x, y, 40-minus, 40-minus, 5, 5);
	}
	private void kwadrat(Graphics2D g,int x,int y,int xx,int yy) {
		
		g.drawRoundRect(x, y, xx, yy, 5, 5);
	}
	
	
	
	public void drawZero(Graphics2D g2d,int x,int y) {
		liniapozioma(g2d,x+5,y,x+35-minus);
		liniapozioma(g2d,x+5,y+60-minus,x+35-minus);
		liniapionowa(g2d,x,y+10);
		liniapionowa(g2d,x+40-minus,y+10);
	}
	public void drawDelimeter(Graphics2D g2d, int x,int y) {
		kropka(g2d,x,y);
		kropka(g2d,x,y+15);
	}
	public void drawOne(Graphics2D g2d,int x,int y) {
		liniapionowa(g2d,x+10,y,y+60-minus);
		liniapozioma(g2d,x+minus,y+60-minus,x+20-minus);
		liniapozioma(g2d,x,y,x+30-minus);
	}
	public void drawTwo(Graphics2D g2d,int x,int y) {
		
		liniapozioma(g2d,x,y);
		liniapionowa(g2d,x+30-minus,y,y+40-minus);
		liniapozioma(g2d,x,y+40-minus);
		liniapionowa(g2d,x,y+40-minus,y+60-minus);
		liniapozioma(g2d,x,y+60-minus);
	}
	public void drawThree(Graphics2D g2d,int x,int y) {
		
		liniapozioma(g2d,x,y);
		liniapionowa(g2d,x+30-minus,y,y+60-minus);
		liniapozioma(g2d,x,y+35-minus);
		liniapozioma(g2d,x,y+60-minus);
		
	}
	public void drawFour(Graphics2D g2d,int x,int y) {
		
		liniapionowa(g2d,x,y,y+40-minus);
		liniapozioma(g2d,x,y+40-minus);
		liniapionowa(g2d,x+30-minus,y+30-minus,y+60-minus);
	}
	
	public void drawFive(Graphics2D g2d,int x,int y) {
		liniapozioma(g2d,x,y);
		liniapionowa(g2d,x,y,y+40-minus);
		liniapozioma(g2d,x,y+40-minus);
		liniapionowa(g2d,x+30-minus,y+40-minus,y+60-minus);
		liniapozioma(g2d,x,y+60-minus);
	}
	public void drawSix(Graphics2D g2d, int x,int y) {
		
		liniapozioma(g2d,x,y,x+25-(minus/2));
		liniapionowa(g2d,x+25-(minus/2),y,y+10-(minus/6));
		liniapionowa(g2d,x,y,y+60-minus);
		kwadrat(g2d,x,y+40-minus,15,20);
		
	}
	public void drawSeven(Graphics2D g2d,int x,int y) {
		
		liniapozioma(g2d,x,y);
		liniapozioma(g2d,x+5,y+60-minus,x+10,y);
		
	}
	public void drawEight(Graphics2D g2d,int x,int y) {
		kwadrat(g2d,x,y,30-minus,40-minus);
		kwadrat(g2d,x-5,y+40-minus,40-minus,40-minus);
		
		
	}
	public void drawNine(Graphics2D g2d,int x,int y) {
		kwadrat(g2d,x-5,y,35-minus,40-minus);
		liniapionowa(g2d,x+30-minus,y,y+60-minus);
	}
	/*public void drawZero(Graphics2D g2d,int x,int y) {
		liniapozioma(g2d,x+5,y,x+45);
		liniapozioma(g2d,x+5,y+120,x+45);
		liniapionowa(g2d,x,y+10);
		liniapionowa(g2d,x+50,y+10);
	}
	public void drawDelimeter(Graphics2D g2d, int x,int y) {
		kropka(g2d,x,y);
		kropka(g2d,x,y+30);
	}
	public void drawOne(Graphics2D g2d,int x,int y) {
		liniapionowa(g2d,x,y,y+120);
		liniapozioma(g2d,x-15,y+120,x+15);
		liniapozioma(g2d,x-10,y,x);
	}
	public void drawTwo(Graphics2D g2d,int x,int y) {
		
		liniapozioma(g2d,x,y);
		liniapionowa(g2d,x+50,y,y+60);
		liniapozioma(g2d,x,y+60);
		liniapionowa(g2d,x,y+60,y+120);
		liniapozioma(g2d,x,y+120);
	}
	public void drawThree(Graphics2D g2d,int x,int y) {
		
		liniapozioma(g2d,x,y);
		liniapionowa(g2d,x+50,y,y+120);
		liniapozioma(g2d,x,y+60);
		liniapozioma(g2d,x,y+120);
		
	}
	public void drawFour(Graphics2D g2d,int x,int y) {
		
		liniapionowa(g2d,x,y,y+70);
		liniapozioma(g2d,x,y+70);
		liniapionowa(g2d,x+50,y+50,y+120);
	}
	
	public void drawFive(Graphics2D g2d,int x,int y) {
		liniapozioma(g2d,x,y);
		liniapionowa(g2d,x,y,y+60);
		liniapozioma(g2d,x,y+60);
		liniapionowa(g2d,x+50,y+60,y+120);
		liniapozioma(g2d,x,y+120);
	}
	public void drawSix(Graphics2D g2d, int x,int y) {
		
		liniapozioma(g2d,x,y,x+30);
		liniapionowa(g2d,x+30,y,y+10);
		liniapionowa(g2d,x,y,y+120);
		kwadrat(g2d,x,y+80);
		
	}
	public void drawSeven(Graphics2D g2d,int x,int y) {
		//liniapionowa(g2d,x,y,y+30);
		liniapozioma(g2d,x,y);
		//liniapionowa(g2d,x+50,y,y+30);
		//liniapozioma(g2d,x+25,y+45,x+50,y+30);
		//liniapionowa(g2d,x+25,y+45,y+120);
		liniapozioma(g2d,x+15,y+120,x+50,y);
	}
	public void drawEight(Graphics2D g2d,int x,int y) {
		kwadrat(g2d,x-5,y,50,60);
		kwadrat(g2d,x-10,y+60,60,60);
	}
	public void drawNine(Graphics2D g2d,int x,int y) {
		kwadrat(g2d,x,y,60,40);
		liniapionowa(g2d,x+60,y,y+120);
	}*/
	
	public void drawHour(Graphics2D g2d) {
		
		switch(hour1) {
		case 0:drawZero(g2d,30,20);
		break;
		case 1:drawOne(g2d,30,20);
		break;
		case 2:drawTwo(g2d,30,20);
		break;
		case 3:drawThree(g2d,30,20);
		break;
		case 4:drawFour(g2d,30,20);
		break;
		case 5:drawFive(g2d,30,20);
		break;
		case 6:drawSix(g2d,30,20);
		break;
		case 7:drawSeven(g2d,30,20);
		break;
		case 9:drawNine(g2d,30,20);
		break;
		case 8:drawEight(g2d,30,20);
		break;
		}
		switch(hour2) {
		case 0:drawZero(g2d,65,20);
		break;
		case 1:drawOne(g2d,65,20);
		break;
		case 2:drawTwo(g2d,65,20);
		break;
		case 3:drawThree(g2d,65,20);
		break;
		case 4:drawFour(g2d,65,20);
		break;
		case 5:drawFive(g2d,65,20);
		break;
		case 6:drawSix(g2d,65,20);
		break;
		case 7:drawSeven(g2d,65,20);
		break;
		case 9:drawNine(g2d,65,20);
		break;
		case 8:drawEight(g2d,65,20);
		break;
		}
	}
	public void drawMinutes(Graphics2D g2d) {
		
		switch(minute1) {
		case 0:drawZero(g2d,120,20);
		break;
		case 1:drawOne(g2d,120,20);
		break;
		case 2:drawTwo(g2d,120,20);
		break;
		case 3:drawThree(g2d,120,20);
		break;
		case 4:drawFour(g2d,120,20);
		break;
		case 5:drawFive(g2d,120,20);
		break;
		case 6:drawSix(g2d,120,20);
		break;
		/*case 7:drawSeven(g2d,200,20);
		break;
		case 9:drawNine(g2d,200,20);
		break;
		case 8:drawEight(g2d,200,20);
		break;*/
		}
		switch(minute2) {
		case 0:drawZero(g2d,155,20);
		break;
		case 1:drawOne(g2d,155,20);
		break;
		case 2:drawTwo(g2d,155,20);
		break;
		case 3:drawThree(g2d,155,20);
		break;
		case 4:drawFour(g2d,155,20);
		break;
		case 5:drawFive(g2d,155,20);
		break;
		case 6:drawSix(g2d,155,20);
		break;
		case 7:drawSeven(g2d,155,20);
		break;
		case 9:drawNine(g2d,155,20);
		break;
		case 8:drawEight(g2d,155,20);
		break;
		}
		
	}
public void drawSeconds(Graphics2D g2d) {
		
		switch(second1) {
		case 0:drawZero(g2d,210,20);
		break;
		case 1:drawOne(g2d,210,20);
		break;
		case 2:drawTwo(g2d,210,20);
		break;
		case 3:drawThree(g2d,210,20);
		break;
		case 4:drawFour(g2d,210,20);
		break;
		case 5:drawFive(g2d,210,20);
		break;
		case 6:drawSix(g2d,210,20);
		break;
		/*case 7:drawSeven(g2d,370,20);
		break;
		case 9:drawNine(g2d,370,20);
		break;
		case 8:drawEight(g2d,370,20);
		break;*/
		}
		switch(second2) {
		case 0:drawZero(g2d,245,20);
		break;
		case 1:drawOne(g2d,245,20);
		break;
		case 2:drawTwo(g2d,245,20);
		break;
		case 3:drawThree(g2d,245,20);
		break;
		case 4:drawFour(g2d,245,20);
		break;
		case 5:drawFive(g2d,245,20);
		break;
		case 6:drawSix(g2d,245,20);
		break;
		case 7:drawSeven(g2d,245,20);
		break;
		case 9:drawNine(g2d,245,20);
		break;
		case 8:drawEight(g2d,245,20);
		break;
		}
		
	}
	public void getSeconds(int seconds) {
		
		if(seconds>=10&&seconds<20) {
			second1=1;
		}
		if(seconds>=20&&seconds<30) {
			second1=2;
		}
		if(seconds>=30&&seconds<40) {
			second1=3;
		}
		if(seconds>=40&&seconds<50) {
			second1=4;
		}
		if(seconds>=50&&seconds<60) {
			second1=5;
		}
		if(seconds==60) {
			second1=6;
		}
		if(seconds<10) {
			second1=0;
		}
		switch(seconds%10) {
		
		case 0:second2=0; break;
		case 1:second2=1; break;
		case 2:second2=2; break;
		case 3:second2=3; break;
		case 4:second2=4; break;
		case 5:second2=5; break;
		case 6:second2=6; break;
		case 7:second2=7; break;
		case 8:second2=8; break;
		case 9:second2=9; break;
		
		
		}
	}
		public void getMinutes(int minutes) {
			
			if(minutes>=10&&minutes<20) {
				minute1=1;
			}
			if(minutes>=20&&minutes<30) {
				minute1=2;
			}
			if(minutes>=30&&minutes<40) {
				minute1=3;
			}
			if(minutes>=40&&minutes<50) {
				minute1=4;
			}
			if(minutes>=50&&minutes<60) {
				minute1=5;
			}
			if(minutes==60) {
				minute1=6;
			}
			if(minutes<10) {
				minute1=0;
			}
			
			switch(minutes%10) {
			
			case 0:minute2=0; break;
			case 1:minute2=1; break;
			case 2:minute2=2; break;
			case 3:minute2=3; break;
			case 4:minute2=4; break;
			case 5:minute2=5; break;
			case 6:minute2=6; break;
			case 7:minute2=7; break;
			case 8:minute2=8; break;
			case 9:minute2=9; break;
			
			
			}
		
		
	}
		
		public void getHours(int hours) {
			
			if(hours>=10&&hours<20) {
				hour1=1;
			}
			if(hours>=20&&hours<30) {
				hour1=2;
			}
			if(hours>=30&&hours<40) {
				hour1=3;
			}
			if(hours>=40&&hours<50) {
				hour1=4;
			}
			if(hours>=50&&hours<60) {
				hour1=5;
			}
			if(hours>=60&&hours<70) {
				hour1=6;
			}
			if(hours>=70&&hours<80) {
				hour1=7;
			}
			if(hours>=80&&hours<90) {
				hour1=8;
			}
			if(hours>=90) {
				hour1=9;
			}
			switch(hours%10) {
			
			case 0:hour2=0; break;
			case 1:hour2=1; break;
			case 2:hour2=2; break;
			case 3:hour2=3; break;
			case 4:hour2=4; break;
			case 5:hour2=5; break;
			case 6:hour2=6; break;
			case 7:hour2=7; break;
			case 8:hour2=8; break;
			case 9:hour2=9; break;
			
			
			}
		
		
	}
		public void rep() {
			this.repaint();
		}
	public static void setKolor(Color kolor) {
		kolorek=kolor;
		
	}
	
	
}
