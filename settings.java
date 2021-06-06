package juego;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class settings extends JPanel{

	private ventanaPrincipal speed;
	private JSlider CovidAlto, CovidMedio,CovidBajo ;
	private JLabel EtiquetaCovidAlto, EtiquetaCovidMedio, EtiquetaCovidBajo;
	private JPanel manage;

	
	/*Absoulamente todo de esta clase esta inspirado en uno de los paquetes que nos dieron en el aula virtual.
	 * Solamente qye adaptado en este caso a la velocidad 
	 */
	public settings(ventanaPrincipal main){
	
		 CovidAlto = new JSlider(JSlider.HORIZONTAL, 0, 10, 6);
		 CovidAlto.setMajorTickSpacing(1);
		 CovidAlto.setMinorTickSpacing(1);
		 CovidAlto.setPaintTicks(true);
		 CovidAlto.setPaintLabels(true);
		 CovidAlto.setAlignmentX(Component.LEFT_ALIGNMENT);

		 CovidMedio = new JSlider(JSlider.HORIZONTAL, 0, 10, 4);
		 CovidMedio.setMajorTickSpacing(1);
		 CovidMedio.setMinorTickSpacing(1);
		 CovidMedio.setPaintTicks(true);
		 CovidMedio.setPaintLabels(true);
		 CovidMedio.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		CovidBajo = new JSlider(JSlider.HORIZONTAL,0, 10, 3);
		CovidBajo.setMajorTickSpacing(1);
		CovidBajo.setMinorTickSpacing(1);
		CovidBajo.setPaintTicks(true);
		CovidBajo.setPaintLabels(true);
		CovidBajo.setAlignmentX(Component.LEFT_ALIGNMENT);
			

		

		SliderListener listener = new SliderListener();
		CovidBajo.addChangeListener(listener);
		CovidMedio.addChangeListener(listener);
		CovidAlto.addChangeListener(listener);
		
		EtiquetaCovidAlto = new JLabel("Covid Tercer Nivel: 6");
		EtiquetaCovidAlto.setAlignmentX(Component.LEFT_ALIGNMENT);
		EtiquetaCovidMedio = new JLabel("Covid Segundo Nivel: 4");
		EtiquetaCovidMedio.setAlignmentX(Component.LEFT_ALIGNMENT);
		EtiquetaCovidBajo = new JLabel("Covid Primer Nivel: 3");
		EtiquetaCovidBajo.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		manage = new JPanel();
		BoxLayout layout = new BoxLayout(manage, BoxLayout.PAGE_AXIS);
		manage.setLayout(layout);
		
		manage.add(Box.createRigidArea(new Dimension(0, 10)));
		manage.add(EtiquetaCovidAlto);
		manage.add(CovidAlto);
		manage.add(Box.createRigidArea(new Dimension(0, 20)));
		manage.add( EtiquetaCovidMedio);
		manage.add(CovidMedio);
		manage.add(Box.createRigidArea(new Dimension(0,30)));
		manage.add(EtiquetaCovidBajo);
		manage.add(CovidBajo);
	
		speed = main; 
		speed.setVel1(3);
		speed.setVel2(4);
		speed.setVel3(6);
		
		add(manage);
	}
	
	
	private class SliderListener implements ChangeListener{
		public int speed1, speed2, speed3;
		public void stateChanged(ChangeEvent event){
			
			speed1 = CovidBajo.getValue();
			speed2 = CovidMedio.getValue();
			speed3 = CovidAlto.getValue();
			
			EtiquetaCovidAlto.setText("Covid Tercer Nivel: " + speed3);		
			EtiquetaCovidMedio.setText("Covid Segundo Nivel: "+ speed2);
			EtiquetaCovidBajo.setText("Covid Primer Nivel: "+ speed1);
			
			speed.setVel1(speed1);
			speed.setVel2(speed2);
			speed.setVel3(speed3);
			
		}
	}
	
	
}