package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Cell extends Quad implements Entity {
	Game game;
	int i,j,player;
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
			Entity ship = game.getselect();
			if(ship!=null){
				System.out.println("ship");

				Point[] p = ((Ship)ship).requirements();
				boolean ok = true;
				for(int i=0;i<p.length;i++){
					if(!game.isWater(this.player,this.i+ p[i].x,this.j+p[i].y)){
						ok = false;
					}
				}
				System.out.println(ok);

				if(ok){
					game.setship(ship,this.player,this.i,this.j);
					//super.color = Color.CYAN;
					game.select(null);
				}
			};
			return true;
		}
		return false;
	}
	public void update(){
		Ship s = (Ship)(game.getcell(player,i,j));
		if(s != null){
			Color c = s.getColor();
			super.color = c;
		}
		else{
			super.color = color;
		}
		
	}
}
