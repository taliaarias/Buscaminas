package buscaminas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Launcher {

	
	private JFrame frame;

	/**
	 * Método main para lanzar la aplicación.
	 * @void no devuelve nada.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Launcher window = new Launcher();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor vacío para inicializar la aplicación.
	 */
	public Launcher() {
		initialize();
	}

	/**
	 * Método que desarrolla toda la parte gráfica, muestra los
	 * botones de dificultad, el tablero, y el mensaje. 
	 * @void no devuelve nada.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 337, 110);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnEasy = new JButton("Fácil");
		btnEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscaminas.execBusca(Dificultad.EASY);
			}
		});
		btnEasy.setBounds(10, 38, 89, 23);
		frame.getContentPane().add(btnEasy);
		
		JButton btnMedium = new JButton("Media");
		btnMedium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscaminas.execBusca(Dificultad.MEDIUM);
			}
		});
		btnMedium.setBounds(109, 38, 89, 23);
		frame.getContentPane().add(btnMedium);
		
		JButton btnHard = new JButton("Dificil");
		btnHard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscaminas.execBusca(Dificultad.HARD);
			}
		});
		btnHard.setBounds(208, 38, 89, 23);
		frame.getContentPane().add(btnHard);
		
		JLabel lblBienvenidoABuscaminas = new JLabel("Bienvenido a buscaminas, escoge una dificultad:");
		lblBienvenidoABuscaminas.setBounds(10, 13, 287, 14);
		frame.getContentPane().add(lblBienvenidoABuscaminas);
	}
}
