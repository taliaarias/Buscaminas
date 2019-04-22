package buscaminas;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Procesador implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	
		Botoncico eb =(Botoncico) e.getSource();
		
		eb.setBackground(new Color(220, 220, 220));
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		Botoncico eb =(Botoncico) e.getSource();
		
		eb.setBackground(null);
		
		
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
		
		if (Tablero.finito==0) {

			
			if (SwingUtilities.isLeftMouseButton(e)) {
				
				if (eb.getText()!="F" && eb.isEnabled()) {
				
					Tablero.pisar(eb.getVer(), eb.getHor());
					pan.removeAll();
					Buscaminas.pintaBotones();
					pan.repaint();
					pan.revalidate();
	
				}
					
				
			} else if (SwingUtilities.isRightMouseButton(e)) {
				
				if (eb.isEnabled()) {
					Tablero.flaggear(eb.getVer(), eb.getHor());
					String etiq = Tablero.getTableroInUse()[eb.getVer()][eb.getHor()].toString();
					eb.setText(etiq);
					eb.repaint();
					eb.revalidate();
				}
			
			}

		} else if(Tablero.finito==1)  {
			JOptionPane.showInternalMessageDialog(pan.getParent(), "has perdido!", "has perdido!", JOptionPane.INFORMATION_MESSAGE);
			Launcher.main(null);
		}
		else if(Tablero.finito==2)  {
			JOptionPane.showInternalMessageDialog(pan.getParent(), "has ganado!", "has ganado!", JOptionPane.INFORMATION_MESSAGE);
			Launcher.main(null);
		}
		
	}
}