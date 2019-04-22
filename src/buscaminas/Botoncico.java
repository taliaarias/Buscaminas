package buscaminas;

import javax.swing.JButton;

public class Botoncico extends JButton {
		
	//propiedades
	private static final long serialVersionUID = 6582544947194522742L;
	private int ver;
	private int hor;
	
	//constructores
	public Botoncico() {
		super();
	}
	
	public Botoncico(String args) {
		super(args);
	}
	
	public Botoncico(String args, int ver, int hor) {
		super(args);
		this.setVer(ver);
		this.setHor(hor);
		// el constructor de "Botoncico" pinta el botón "pisado" si la etiqueta es "m".
		if (this.getText()=="m") this.setEnabled(true);
	}
	
	//getters and setters
	public int getVer() {
		return this.ver;
	}

	public int getHor() {
		return this.hor;
	}
	
	public void setVer(int ver) {
		this.ver = ver;
	}
	
	public void setHor(int hor) {
		this.hor = hor;
	}

	
}
