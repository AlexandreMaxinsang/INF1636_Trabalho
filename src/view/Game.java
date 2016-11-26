package view;

import java.awt.Color;

public class Game {
	
	Ship selected;
	Ship Board1[][];
	Ship Board2[][];
	Tela tela;
	
	Game(Tela tela){
		Board1 = new Ship[15][15];
		Board2 = new Ship[15][15];
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
	
	void setselected(Ship q){
		
		selected = q;
		System.out.println("selecionou");
	}
	
	Ship getselected(){
		return selected;
	}
	
	public void uptade(int player,int a ,int b){
		
		Ship ship = getselected();
		if(ship!=null){
			
			System.out.println("ship");
			Point[] p = ((Ship)ship).requirements();
			boolean ok = true;
			
			for(int i=0;i<p.length;i++){
				if(!isWater(player,a+ p[i].x,b+p[i].y)){
					ok = false;
				}
			}
			
			System.out.println(ok);

			if(ok){
				
				setship(ship,p,player,a,b);
				ship.selecionado=false;
				setselected(null);
			}
		};
		
	}
	
	
	public void setship(Ship ship,Point[] p,int player, int i, int j) {
	
		System.out.println("set");
		
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
	
	public Ship getcell(int player, int i, int j) {
		if(player == 1){
			return Board1[i][j];
		}
		if(player == 2){
			return Board2[i][j];
		}
		return null;
	}
}
