package view;

public class Game {
	
	Ship selected;
	Ship Board1[][];
	Ship Board2[][];
	TelaEscolha tela;
	
	Game(TelaEscolha tela){
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
				int px=a+p[i].x;
				int py=b+p[i].y;
				if(px>=0 && px<15 && py>=0 && py<15)
				{	if(!isWater(player,px,py)){
						ok = false;
					}
				}
				else
					ok=false;
			}
			
			System.out.println(ok);

			if(ok){
				
				setship(ship,p,player,a,b);
				Ship.selecionado=false;
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
