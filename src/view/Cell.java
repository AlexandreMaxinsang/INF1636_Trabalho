package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Cell extends Quad implements Entity {

	int i,j,player;
	Game game;
	Color color;
	
	Cell(Game game, int x,int  y, int w,int  h,Color color,int i,int j){
		super(x, y, w, h,color);
		this.color = color;
		this.game = game;
		this.player = 1;
		this.i = i;
		this.j = j;
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
	}

	@Override
	public boolean onclick(MouseEvent e) {
		
		if(super.onclick(e)){
<<<<<<< HEAD
			//game.uptade(player, i, j); nao ser para nada
=======
			game.update(player, i, j);
>>>>>>> origin/master
			return true;
		}
		
		
		return false;
	}
	
	@Override
	public void update(){
		Ship s = game.getcell(player,i,j);
		if(s != null){
<<<<<<< HEAD
			Color c =s.color;
			super.color = c;
=======
			super.color = s.getColor();;
>>>>>>> origin/master
		}
		else{
			super.color = color;
		}
		
	}
<<<<<<< HEAD

=======
	public Point getPos(){
		System.out.print("a");
		return new Point(i,j);
	}
>>>>>>> origin/master
}
