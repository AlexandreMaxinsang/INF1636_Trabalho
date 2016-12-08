package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Tabuleiro implements Entity {
	ArrayList<Cell> q;
	MouseEvent event;
	private int tabuleiro_x;
	private int tabuleiro_y;
	private int size;
	
	Tabuleiro(Game game,int qtd_cell_x,int qtd_cell_y,int x,int y,int size){
		q = new ArrayList<Cell>();
		tabuleiro_x=x;
		tabuleiro_y=y;
		this.size=size;
        for(int i=0;i<qtd_cell_x;i++){
            for(int j=0;j<qtd_cell_y;j++){
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
		this.event=e;
		for(int i=0;i<q.size();i++){
	    	if (q.get(i).onclick(e)){
				ret = true;
			};
	    }
		return ret;
	}

	//Retornar a posicao i e j da cell clickada no tabuleiro
	public Point posicaocell()
	{
		int pos_x,pos_y;
		
		if(this.onclick(event))
		{
			
			
			pos_x=(event.getX()-tabuleiro_x)/size;
			pos_y=(event.getY()-tabuleiro_y)/size;
			
			return new Point(pos_x,pos_y);
		}
		
		
		return null;
	}
	
	
}
