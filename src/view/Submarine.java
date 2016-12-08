package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Submarine extends Ship {
	
	
	
	Submarine(Game game, int x,int  y, int w,int  h,Orientacao orientacao){
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
				mudarcor(Color.gray);
				used = true;
				selecionado=true;
				return true;
				
			}
			
		}
		return false;
	}
	public Point[] requirements() {
		Point[] p = new Point[1];
		p[0] = new Point(0,0);
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

	@Override
	public void mudarcor(Color color) {
		// TODO Auto-generated method stub
		q.color = color;
		
	}
	
	
}
