package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Tabuleiro implements Entity {
	ArrayList<Cell> q;
	
	Tabuleiro(Game game,int numx,int numy,int x,int y,int size){
		q = new ArrayList<Cell>();
        for(int i=0;i<numx;i++){
            for(int j=0;j<numy;j++){
            	q.add(new Cell(game,x+size*i,y+size*j,size,size,Color.BLUE,i,j));
            }
        }
	}
	public void update(){
		for(int i=0;i<q.size();i++){
        	q.get(i).update();
        }
	}
	public void draw(Graphics g) {
		for(int i=0;i<q.size();i++){
        	q.get(i).draw(g);
        }
	}
	
	public boolean onclick(MouseEvent e) {
		boolean ret = false;
		for(int i=0;i<q.size();i++){
	    	if (q.get(i).onclick(e)){
				ret = true;
			};
	    }
		return ret;
	}

}
