package view;

import java.awt.Color;

public interface Ship extends Entity {
	public Point[] requirements();
	public Color getColor();
}
