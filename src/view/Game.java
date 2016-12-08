package view;


public class Game {
	
	private static int numeroShip=0;
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
		if(player == 1 && Board1[i][j]!=null)
			return false;
		
		if(player == 2 && Board2[i][j]!=null)
			return false;
		
		return true;
	}
	
	
	public void uptade(int player,int posx ,int posy){
		
		Ship ship = getselected();
		
		if(ship!=null){
			
			System.out.println("ship");
			
			Point[] p = ((Ship)ship).requirements();
			boolean ok = true;
			
			for(int i=0;i<p.length;i++){
				int px=posx+p[i].x;
				int py=posy+p[i].y;
				if(px>=0 && px<15 && py>=0 && py<15)
				{	
					if(!isWater(player,px,py)){
						ok = false;
					}
				}
				else
					ok=false;
			}
			
			System.out.println(ok);

			if(ok){
				numeroShip++;
				setship(ship,player,posx,posy);
				Ship.selecionado=false;
				setselected(null);
				
			}
		}
		else{
			Ship aux=Board1[posx][posy];
			if(aux!=null){
				aux.used=false;
				for(int i=0;i<15;i++)
					for(int j=0;j<15;j++)
						if(aux==Board1[i][j]){
							
							Board1[i][j].mudarcor(Board1[i][j].getColor());
							
							Board1[i][j]=null;
							
						}
				   numeroShip--;

					tela.update();
					
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
	
	void setselected(Ship q){
		System.out.println("selecionou");
		selected = q;
		
	}
	
	Ship getselected(){
		return selected;
	}
	
	
	
	public void setship(Ship ship,int player, int i, int j) {
	
		System.out.println("set");
		Point[] p=ship.requirements();
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
