package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Destroyer extends Ship {
	
	
	Quad q1;
	Quad q2;
	
	Destroyer(Game game, int x,int  y, int w,int  h,Orientacao orientacao){
		color = Color.RED;
		q1 = new Quad(x, y, w, h,color);
		q2 = new Quad(x+w, y, w, h,color);
		this.game = game;
		this.orientacao=orientacao;
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
				 mudarcor(Color.gray);
				selecionado=true;
				used = true;
				return true;
			}
			
		}
		return false;
	}
	
	public Point[] requirements() {
		Point[] p = new Point[2];
		p[0] = new Point(0,0);
		if(orientacao==Orientacao.Norte)
			p[1] = new Point(0,-1);
		else if(orientacao==Orientacao.Leste)
			p[1] = new Point(+1,0);
		else if(orientacao==Orientacao.Sul)
			p[1] = new Point(0,+1);
		else if(orientacao==Orientacao.Oeste)
			p[1] = new Point(-1,0);
		
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
		
	}

}
