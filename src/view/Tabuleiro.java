package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Tabuleiro implements Entity {
	ArrayList<Cell> quads;
	
	Tabuleiro(Game game,int numx,int numy,int x,int y,int size){
		quads = new ArrayList<Cell>();
        for(int i=0;i<numx;i++){
            for(int j=0;j<numy;j++){
            	quads.add(new Cell(game,x+size*i,y+size*j,size,size,Color.BLUE,i,j));
            }
        }
	}
	public void update(){
		for(int i=0;i<quads.size();i++){
        	quads.get(i).update();
        }
	}
	public void draw(Graphics g) {
		for(int i=0;i<quads.size();i++){
        	quads.get(i).draw(g);
        }
	}
	public Point coord2index(Point p){
		System.out.print("coord no tab");

		for(int i=0;i<quads.size();i++){
	    	if (quads.get(i).collide(p.x,p.y)){
	    		System.out.print("collide");
				return quads.get(i).getPos();
			};
	    }
		return null;
	}
	public boolean onclick(MouseEvent e) {
		boolean ret = false;
		for(int i=0;i<quads.size();i++){
	    	if (quads.get(i).onclick(e)){
				ret = true;
			};
	    }
		return ret;
	}

}
