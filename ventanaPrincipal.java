package juego;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Rectangle;
import javax.lang.model.type.IntersectionType;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/*Esta clas esta encargada de prácticamente todo en el programa.
 * Vamos a diferenciar las zonas donde se realizan diferentes tareas:
 * -Dar valores
 * -Pintar la imagen
 * -Crear el movimiento y rebote
 * -Restricciones
 * -Casos
 * 
 */




public class ventanaPrincipal extends JPanel{
	
	private ImageIcon fondo,cv1, cv2, cv3, escalerArriba, escalerAbajo, prota, vacuna;
	private Timer timer1, timer2, timer3;

	
	private final int WIDTH=600, HIGH=700;
	private int x,x1,x2,x3,y,y1,y2,y3;
	public int move1 = 3;
	public int move2 = 4;
	public int move3 = 6;
	private final int JUMP = 5, MOVE = 10;

	private Rectangle cuadrado_cv1, cuadrado_cv2, cuadrado_cv3, cuadrado_prota, cuadrado_vacuna;
//---------------------------RESTRICCIONES--------------------------------	
	private class DirectionListener implements KeyListener{
		public void keyPressed(KeyEvent event){
			
			
			if (x>=320 && x<=320+escalerAbajo.getIconWidth()-prota.getIconWidth() && y>=285) {
				switch(event.getKeyCode()){
				case KeyEvent.VK_RIGHT:
					x+=MOVE; break;
				case KeyEvent.VK_LEFT:
					x-=MOVE; break;
				case KeyEvent.VK_UP:
					y -= JUMP; break;
				case KeyEvent.VK_DOWN:
					y += JUMP; break;
				
				
				}
			}
			
			if (x>=50 && x<=50+escalerArriba.getIconWidth()-prota.getIconWidth() && y>=75 && y<=287) {
				switch(event.getKeyCode()){
				case KeyEvent.VK_RIGHT:
					x+=MOVE; break;
				case KeyEvent.VK_LEFT:
					x-=MOVE; break;
				case KeyEvent.VK_UP:
					y -= JUMP; break;
				case KeyEvent.VK_DOWN:
					y += JUMP; break;
				
				}
			}
				
			else {
				switch(event.getKeyCode()){
				
				case KeyEvent.VK_RIGHT:
					x+=MOVE; break;
				case KeyEvent.VK_LEFT:
					x-=MOVE; break;

				}
			}
			
			if(x>=600-prota.getIconWidth()) {
				x -= MOVE;
				}
			if(x<=0) {
				x += MOVE;
				}
			if(y>532){
				y -= JUMP;
				}
			
			if (cuadrado_vacuna.intersects(cuadrado_prota)) { 
				victoria();
			}
			if (cuadrado_cv1.intersects(cuadrado_prota) || cuadrado_cv2.intersects(cuadrado_prota) || cuadrado_cv3.intersects(cuadrado_prota)) { 
				derrota();
			}

			
			repaint();
		}
	
	public void keyTyped(KeyEvent event){}
	public void keyReleased(KeyEvent event){}
	}	
//-------------------------------CASOS-------------------------------------------
	public void derrota() {
		int dialogButton = JOptionPane.showConfirmDialog (null, "¿Otro intento?", "Fin del Juego", JOptionPane.YES_NO_OPTION);
		if(dialogButton == JOptionPane.YES_OPTION) {
			x=0; y=532;
			remove(dialogButton);
		}
		else {
			System.exit(1);
		}
	}
	
	public void victoria() {
		int dialogButton = JOptionPane.showConfirmDialog (null, "Felicidades estas vacunado\n¿Quieres volver a jugar?", "VICTORIA", JOptionPane.YES_NO_OPTION);
		if(dialogButton == JOptionPane.YES_OPTION) {
			x=0; y=532;
			remove(dialogButton);
		}
		else {
			System.exit(1);
		}
	}
	
//-------------------------------CONSTRUCTOR--------------------------------------
	public ventanaPrincipal() {

		//----------------------------------------------
		timer1 = new Timer(20, new ReboundListener1());
		cv1 = new ImageIcon("covid.png");
		x1=410;
		y1=560;
		timer2 = new Timer(20, new ReboundListener2());
		cv2 = new ImageIcon("covid.png");
		x2=150;
		y2=310;
		timer3 = new Timer(20, new ReboundListener3());
		cv3 = new ImageIcon("covid.png");
		x3=50;
		y3=95;

		prota = new ImageIcon("prota.png");
		x=0; 
		y=532;
		fondo = new ImageIcon("background.png");
		escalerArriba = new ImageIcon("escalera1.png");
		escalerAbajo = new ImageIcon("escalera2.png");
		vacuna = new ImageIcon("vacuna.png");
		//----------------------------------------------
				
		addKeyListener(new DirectionListener());
		setPreferredSize(new Dimension(WIDTH, HIGH));
		setBackground(Color.black);
		timer1.start();
		timer2.start(); 
		timer3.start();
		setFocusable(true);
	 }

	
//----------------------------"PINTAR"--------------------------------------------------
	public void paintComponent(Graphics page){
		super.paintComponent(page);
		
		fondo.paintIcon(this,  page,  0,  0);
		vacuna.paintIcon(this, page, 200, 125);
		escalerArriba.paintIcon(this,  page,  50,  176);
		escalerAbajo.paintIcon(this,  page,  320,  389);
		cv1.paintIcon(this, page, x1, y1);
		cv2.paintIcon(this, page, x2, y2);
		cv3.paintIcon(this, page, x3, y3);		
		prota.paintIcon(this, page, x, y);

		cuadrado_cv1 = new Rectangle(x1, 560, cv1.getIconWidth(), cv1.getIconHeight());
		cuadrado_cv2 = new Rectangle(x2, 309, cv1.getIconWidth(), cv1.getIconHeight());
		cuadrado_cv3 = new Rectangle(x3,96, cv1.getIconWidth(), cv1.getIconHeight());
		cuadrado_prota = new Rectangle(x, y, prota.getIconWidth(), prota.getIconHeight());
		cuadrado_vacuna = new Rectangle(200, 125, vacuna.getIconWidth(), vacuna.getIconHeight());
		
		
		requestFocus();
	}
	

//-----------------------------MOVIMIENTO Y REBOTE----------------------------------------------------------
	
	private class ReboundListener1 implements ActionListener{
		public void actionPerformed(ActionEvent event){
			x1 += move1;
			if(x1>=WIDTH-cv1.getIconWidth() || x1<100) {
				move1 = move1 * -1;
			}
			repaint();
		}
	}
	
	private class ReboundListener2 implements ActionListener{
		public void actionPerformed(ActionEvent event){
			x2+=move2;
			if(x2>=600-cv2.getIconWidth() || x2<0) {
				move2 = move2 * -1;
			}
			repaint();
		}
	}
	
	private class ReboundListener3 implements ActionListener{
		public void actionPerformed(ActionEvent event){
			x3+=move3;
			if(x3>=600-cv3.getIconWidth() || x3<0) {
				move3 = move3 * -1;
			}
			repaint();
		}
	}
	
	public int getVel1() {
		return move1;
		}
	public void setVel1(int vl1) {
		this.move1 = vl1;
		}
	

	public int getVel2() {
		return move2;
		}
	public void setVel2(int vl2) {
		this.move2 = vl2;
		}
	
	
	public int getVel3() {
		return move3;
		}
	public void setVel3(int vl3) {
		this.move3 = vl3;
		}	

}
