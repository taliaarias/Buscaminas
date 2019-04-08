package buscaminas;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingUtilities;

public class Procesador implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	
		
	}

	/**
	 * Método que sobreescribe los eventos que suceden al hacer "click" con el ratón.
	 */
	
	@Override
	public void mouseReleased(MouseEvent e) {
		Botoncico eb =(Botoncico) e.getSource();
		Container pan = eb.getParent();
		if (SwingUtilities.isLeftMouseButton(e)) {
			if (Tablero.getTableroInUse()[eb.getVer()][eb.getHor()].hasMine() && 
					!Tablero.getTableroInUse()[eb.getVer()][eb.getHor()].isFlagged()) {
				Tablero.mostrar();
				pan.removeAll();
				Buscaminas.pintaBotones();
				pan.repaint();
				pan.revalidate();

			}
			
			else {
				Tablero.pisar(eb.getVer(), eb.getHor());
				String etiq = Tablero.getTableroInUse()[eb.getVer()][eb.getHor()].toString();
				eb.setEnabled(false);
				eb.setText(etiq);
				
			}
			
			
		} else
			if (SwingUtilities.isRightMouseButton(e)) {
				Tablero.flaggear(eb.getVer(), eb.getHor());
				String etiq = Tablero.getTableroInUse()[eb.getVer()][eb.getHor()].toString();
				eb.setText(etiq);
				eb.getParent().repaint();
				eb.getParent().revalidate();
			}	
	}
	
}