package view;

import java.awt.Color;

public abstract class Ship implements Entity {
	
	Game game;
	static boolean selecionado=false;
	Quad q;
	Color color;
	
	public abstract Point[] requirements();
	public abstract Color getColor();
	
}
