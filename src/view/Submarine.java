package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Submarine extends Ship {
	
	
	boolean used;
	
	Submarine(Game game, int x,int  y, int w,int  h){
		color = Color.GREEN;
		q = new Quad(x, y, w, h,color);
		this.game = game;
		used = false;
	}
	
	@Override
	public void draw(Graphics g) {
		q.draw(g);
	}

	@Override
	public boolean onclick(MouseEvent e) {
		
		if(q.onclick(e)){
			if(!used && !selecionado){
				game.setselected(this);
				q.color = Color.gray;
				used = true;
				selecionado=true;
				return true;
				
			}
			
		}
		return false;
	}
	public Point[] requirements() {
		Point[] p = new Point[1];
		p[0] = new Point(0,0,super.color);
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
