package view;

import java.awt.Color;

public class Game {
	
	private static int numeroShip=0;
	Ship selected;
	Ship Board1[][];
	Ship Board2[][];
	Color cellColor1[][];
	Color cellColor2[][];
	
	TelaEscolha tela;
	
	Game(TelaEscolha tela){
		Board1 = new Ship[15][15];
		Board2 = new Ship[15][15];
		cellColor1=new Color [15][15];
		cellColor2=new Color [15][15];
		this.tela= tela;
	}
	Ship[][] getBoard(int player){
		if(player ==1) return Board1;
		if(player ==2) return Board2;
		return null;
	}
	boolean isWater(int player,int i,int j){
		Ship[][] b = getBoard(player);
		if(b!=null && b[i][j]!=null){
				return false;
		}
		return true;
	}
	
	void setselected(Ship q){
		System.out.println("selecionou");
		selected = q;
		
	}
	
	Ship getselected(){
		return selected;
	}
	
	public void update(int player,int i ,int j){
		
		Ship ship = getselected();
		if(ship!=null){
			
			System.out.println("ship");
			Point[] req = ((Ship)ship).requirements();
			boolean ok = true;
			
			for(int tmp=0;tmp<req.length;tmp++){
				System.out.println(tmp);
				System.out.println(req);
				System.out.println(req[tmp]);
				System.out.println(req[tmp].x);

				int px=req[tmp].x;
				int py=req[tmp].y;
				if(px>=0 && px<15 && py>=0 && py<15)
				{	
					if(!isWater(player,px,py)){
						ok = false;
					}
					//checar vizinhos
				}
				else{
					ok=false;
				}
			}
			
			System.out.println(ok);

			if(ok){
				numeroShip++;
				setship(ship,player,i,j);
				Ship.selecionado=false;
				setselected(null);
				
			}
			

		}
		else{
			if(!isWater(player,i,j)){
				setship(null,player,i,j);
				//pego o ship de i,j
				//vai no ship e poe used como false
				//board[i][j] e botar null
				//p cada req do ship, muda cor p agua

			}
		}
		
	}
	
	public void changeOrientation(Ship s){
		
		if(s.orientacao==Orientacao.Norte)
			s.orientacao=Orientacao.Leste;
		else if(s.orientacao==Orientacao.Leste)
			s.orientacao=Orientacao.Sul;
		else if(s.orientacao==Orientacao.Sul)
			s.orientacao=Orientacao.Oeste;
		else if(s.orientacao==Orientacao.Oeste)
			s.orientacao=Orientacao.Norte;
		
	}
	
	public int getnumeroShip(){
		
		return numeroShip;
		
	}
	public Point coord2index(Point p){
		return tela.getBoard().coord2index(p);
	}
	public void setship(Ship ship,int player, int i, int j) {
		Ship[][] b = getBoard(player);

		if(ship!=null){
			Point[] p = ship.requirements();
			for(int k=0;k<p.length;k++){
				b[i+p[k].x][j+p[k].y] = ship;
			}
		}
		else{
			Ship s = getcell(player,i,j);
			if(s!=null){
				Point[] p = s.requirements();
				for(int k=0;k<p.length;k++){
					b[i+p[k].x][j+p[k].y] = null;
				}
			}
			
		}
		tela.update();

	}
	
	public Ship getcell(int player, int i, int j) {
		Ship[][] b = getBoard(player);
		if(b!=null){
				return b[i][j];
		}
		return null;
	}
	
}
