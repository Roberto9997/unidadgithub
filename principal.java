package cv19;

import javax.swing.JFrame;



public class principal  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("juego covid");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new imagen());
		
		frame.pack();
		frame.setVisible(true);
		

	}

}
