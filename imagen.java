package cv19;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class imagen  extends JPanel {
	
	private ImageIcon fondo, covid, prota;
	
	//private int x, y;
	public imagen(){
		
		fondo = new ImageIcon("background.png");
		covid = new ImageIcon("covid.png");
		prota = new ImageIcon("prota.png");
		
		//moveX = moveY = 3;
		setPreferredSize(new Dimension(600, 700));
		setBackground(Color.black);
		//timer.start();
	}
	
	
	public void paintComponent(Graphics page){
		super.paintComponent(page);
		fondo.paintIcon(this,  page,  0,  0);
		
		covid.paintIcon(this, page, 50, 50);
		
		prota.paintIcon(this,page, 10, 10);
	}
	
}
