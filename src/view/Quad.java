package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Quad implements Entity {
	int x, y, w, h;
	Color color;
	
	Quad(int x,int  y, int w,int  h,Color color){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.color = color;
	}
	public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, w, h);
        g.setColor(Color.WHITE);
        g.drawRect(x, y, w, h);
    }
	public boolean onclick(MouseEvent e) {
		return collide(e.getX(),e.getY());
	}
	public boolean collide(int mx,int my){
		if((mx>x && mx<x+w)&&(my>y && my<y+h)){
			return true;
		}
		return false;
	}
	@Override
	public void update() {
		
	}
	public Point getCoord(){
		return new Point(x+w/2,y+h/2);
	}
	

}
