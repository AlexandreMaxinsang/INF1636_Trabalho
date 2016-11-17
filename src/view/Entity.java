package view;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
/*
 * qualquer coisa que pode ser desenhada na tela ou que pode interagir com o mouse
 * */
public interface Entity {
	public void draw(Graphics g);
	public void update();
	public boolean onclick(MouseEvent e);
}
