package juego;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class principal {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Covid Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane ventana = new JTabbedPane(); 
		ventanaPrincipal main = new ventanaPrincipal();
		ventana.addTab("Game",  main);
		ventana.addTab("Settings",  new settings(main));
		frame.getContentPane().add(ventana);
		
		frame.pack();
		frame.setVisible(true);
		
	}

}
/*
El metodo main simplemente ejecuta con JFrame ventanaPrincipal y settings.
En mi caso settings es una clase dedicada a la segunda ventana cuya funcion es configurar las velocidades.
Luego tenemos ventanaPrincipal donde reside el funcionamiento mas puro del programa.

*/