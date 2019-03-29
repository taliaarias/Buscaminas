package buscaminas;

import javax.swing.JButton;

public class Botoncico extends JButton {
		

	private static final long serialVersionUID = 6582544947194522742L;
	private int ver;
	private int hor;
	
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
	}
	
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
