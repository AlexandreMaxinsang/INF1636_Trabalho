package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Destroyer implements Ship {
	Game game;
	boolean used;
	Quad q;
	Quad q2;
	Color color;
	Destroyer(Game game, int x,int  y, int w,int  h){
		color = Color.RED;
		q = new Quad(x, y, w, h,color);
		q2 = new Quad(x+w, y, w, h,color);
		this.game = game;
		used = false;
	}
	@Override
	public void draw(Graphics g) {
		q.draw(g);
		q2.draw(g);

	}

	@Override
	public boolean onclick(MouseEvent e) {
		if(q.onclick(e) || q2.onclick(e)){
			if(!used){
				game.select(this);
				q.color = Color.gray;
				q2.color = Color.gray;
				used = true;
				return true;
			}
			
		}
		return false;
	}
	public Point[] requirements() {
		Point[] p = new Point[2];
		p[0] = new Point(0,0);
		p[1] = new Point(+1,0);
		return p;
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return color;
	}

}
