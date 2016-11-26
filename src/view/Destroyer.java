package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Destroyer extends Ship {
	
	boolean used;
	Quad q1;
	Quad q2;

	Destroyer(Game game, int x,int  y, int w,int  h){
		color = Color.RED;
		q1 = new Quad(x, y, w, h,color);
		q2 = new Quad(x+w, y, w, h,color);
		this.game = game;
		used = false;
	}
	@Override
	public void draw(Graphics g) {
		q1.draw(g);
		q2.draw(g);

	}
	@Override
	public boolean onclick(MouseEvent e) {
		
		if(q1.onclick(e) || q2.onclick(e)){
			if(!used && !selecionado){
				game.setselected(this);
				q1.color = Color.gray;
				q2.color = Color.gray;
				selecionado=true;
				used = true;
				return true;
			}
			
		}
		return false;
	}
	
	public Point[] requirements() {
		Point[] p = new Point[2];
		p[0] = new Point(0,0,super.color);
		p[1] = new Point(+1,0,super.color);
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
