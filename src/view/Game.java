package view;

import java.awt.Color;

public class Game {
	
	Entity selected;
	Object Board1[][];
	Object Board2[][];
	Tela tela;
	Game(Tela tela){
		Board1 = new Object[15][15];
		Board2 = new Object[15][15];
		this.tela= tela;
	}
	boolean isWater(int player,int i,int j){
		//if i,j inside board talvez com trycatch
		if(player == 1 && Board1[i][j]!=null){
			return false;
		}
		if(player == 2 && Board2[i][j]!=null){
			return false;
		}
		return true;
	}
	void select(Entity q){
		selected = q;
		System.out.println("selecionou");
	}
	Entity getselect(){
		return selected;
	}
	public void setship(Object ship,int player, int i, int j) {
		// TODO Auto-generated method stub
		System.out.println("set");
		//pede o requirements e muda todos
		Point[] p = ((Ship)ship).requirements();
		if(player == 1){
			
			for(int k=0;k<p.length;k++){
				Board1[i+p[k].x][j+p[k].y] = ship;
			}
		}
		if(player == 2){
			Board2[i][j] = ship;
		}
		tela.update();
	}
	public Object getcell(int player, int i, int j) {
		if(player == 1){
			return Board1[i][j];
		}
		if(player == 2){
			return Board2[i][j];
		}
		return null;
	}
}
