package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Battleships extends Ship {
	
	Quad q1;
	Quad q2;
	Quad q3;
	Quad q4;
	Quad q5;
	
	Battleships(Game game, int x,int  y, int w,int  h,Orientacao orientacao){
		color = Color.orange;
		q1 = new Quad(x, y, w, h,color);
		q2 = new Quad(x+w, y, w, h,color);
		q3 = new Quad(x+2*w, y, w, h,color);
		q4 = new Quad(x+3*w, y, w, h,color);
		q5 = new Quad(x+4*w, y, w, h,color);
		this.orientacao=orientacao;
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
				mudarcor(Color.gray);
				
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
		
		if(orientacao==Orientacao.Norte){
			p[1] = new Point(0,-1);
			p[2] = new Point(0,-2);
			p[3] = new Point(0,-3);
			p[4] = new Point(0,-4);
		}
		else if(orientacao==Orientacao.Leste){
			p[1] = new Point(+1,0);
			p[2] = new Point(+2,0);
			p[3] = new Point(+3,0);
			p[4] = new Point(+4,0);
		}
		else if(orientacao==Orientacao.Sul){
			p[1] = new Point(0,+1);
			p[2] = new Point(0,+2);
			p[3] = new Point(0,+3);
			p[4] = new Point(0,+4);
		}
		else if(orientacao==Orientacao.Oeste){
			p[1] = new Point(-1,0);
			p[2] = new Point(-2,0);
			p[3] = new Point(-3,0);
			p[4] = new Point(-4,0);
		}
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
		q1.color = color;
		q2.color = color;
		q3.color = color;
		q4.color = color;
		q5.color = color;
		
		
	}

}
