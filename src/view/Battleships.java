package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Battleships extends Ship {
	boolean used;
	Quad q1;
	Quad q2;
	Quad q3;
	Quad q4;
	Quad q5;
	
	Battleships(Game game, int x,int  y, int w,int  h){
		color = Color.orange;
		q1 = new Quad(x, y, w, h,color);
		q2 = new Quad(x+w, y, w, h,color);
		q3 = new Quad(x+2*w, y, w, h,color);
		q4 = new Quad(x+3*w, y, w, h,color);
		q5 = new Quad(x+4*w, y, w, h,color);
		this.game = game;
		used = false;
	}
	@Override
	public void draw(Graphics g) {
		q1.draw(g);
		q2.draw(g);
		q3.draw(g);
		q4.draw(g);
		q5.draw(g);
	}
	@Override
	public boolean onclick(MouseEvent e) {
		
		if(q1.onclick(e) || q2.onclick(e)||q3.onclick(e) || q4.onclick(e)||q5.onclick(e)){
			if(!used && !selecionado){
				game.setselected(this);
				q1.color = Color.gray;
				q2.color = Color.gray;
				q3.color = Color.gray;
				q4.color = Color.gray;
				q5.color = Color.gray;
				
				selecionado=true;
				used = true;
				return true;
			}
			
		}
		return false;
	}
	
	public Point[] requirements() {
		Point[] p = new Point[5];
		p[0] = new Point(0,0);
		p[1] = new Point(+1,0);
		p[2] = new Point(+2,0);
		p[3] = new Point(+3,0);
		p[4] = new Point(+4,0);
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
