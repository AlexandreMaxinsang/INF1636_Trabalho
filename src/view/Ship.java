package view;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Ship implements Entity {
	
	boolean used;
	Game game;
	static boolean selecionado=false;
	Quad q;
	protected Color color;
	protected Orientacao orientacao;
	
	public abstract Point[] requirements();
	public abstract Color getColor();
	public abstract void mudarcor(Color color);
}
