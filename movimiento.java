package cv19;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class movimiento extends JPanel{
	private final int WIDTH = 600, HEIGHT = 700;
	private final int DELAY = 20;
	
	private ImageIcon image,fondo;
	private Timer timer;
	private int x, y, moveX, moveY;
	
	public movimiento(){
		timer = new Timer(DELAY, new ReboundListener());
		
		image = new ImageIcon("covid.png");
		fondo = new ImageIcon("background.png");
		x = 0;
		y = 550;
		moveX = 2;
		moveY =0 ;
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.black);
		timer.start();
	}
	public void paintComponent(Graphics page){
		super.paintComponent(page);
		fondo.paintIcon(this,  page,  0,  0);
		image.paintIcon(this,  page,  x,  y);
		
	}
	private class ReboundListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			x+=moveX;
			y+=moveY;
			if(x>=WIDTH-image.getIconWidth() | x<0) moveX = moveX * -1;
			if(y>=HEIGHT-image.getIconHeight() | y<0) moveY = moveY * -1;
			repaint();
		}
	}
	
	
}
