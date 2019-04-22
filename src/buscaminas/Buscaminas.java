package buscaminas;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Buscaminas {
	
	//propiedades		
	static public JFrame frame = new JFrame();
	static public JPanel contentPane = (JPanel) frame.getContentPane();
	static public JPanel interior= new JPanel();
	static Procesador procesador = new Procesador();
 	
	/**
	 * Constructor al que se le pasa el parámetro de dificultad.
	 * @param dif indica el número de minas y el tamaño del tablero en función de la dificultad.
	 */
	public Buscaminas(Dificultad dif) {
		
		Tablero.iniciarTablero(dif);
		Tablero.ponerMinas();
		//Tablero.imprime();
		pintaBotones();
		contentPane.add(interior);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if(dif==Dificultad.FACIL)
		frame.setSize(400,400);
		else if(dif==Dificultad.MEDIA)
		frame.setSize(800,800);
		else if(dif==Dificultad.DIFICIL)
		frame.setSize(1480,800);
		frame.setVisible(true);
	
		frame.setTitle("Buscaminas: Dificultad - "+Tablero.getDificultadInUse());
		
	}
	
	/**
	 * Método que crea los botones dentro del tablero.
	 * @void no devuelve nada.
	 */
	public static void pintaBotones() {
		interior.removeAll();
		Casilla[][] current = Tablero.getTableroInUse();
		interior.setLayout(new GridLayout(current.length,current[0].length,1,1));    
		
		for (int i=0; i<current.length; i++) {
			
			for (int j=0; j<current[i].length; j++) {
			Botoncico botoncico= new Botoncico(current[i][j].toString(), i, j);
			botoncico.addMouseListener(procesador);
			if (current[i][j].isVisible() && botoncico.getText()!="F") {
				
				botoncico.setEnabled(false);
				
			}
			interior.add(botoncico);
			
			}		
		}
	}
	

	/**
	 * Método ejecutor del programa al que se le pasa el parámetro de dificultad.
	 * @param dif Recibe el tipo de dificultad de la partida: fácil, medio o difícil.
	 * @void no devuelve nada.
	 */
	
	public static void execBusca(Dificultad dif) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
		public void run() {
			@SuppressWarnings("unused")
			Buscaminas gui = new Buscaminas(dif);
		}
		});
	}
		
}