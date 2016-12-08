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
	
	
<<<<<<< HEAD
	public void uptade(int player,int posx ,int posy){
=======
	public void update(int player,int i ,int j){
>>>>>>> origin/master
		
		Ship ship = getselected();
		
		if(ship!=null){
			
			System.out.println("ship");
<<<<<<< HEAD
			
			Point[] p = ((Ship)ship).requirements();
			boolean ok = true;
			
			for(int i=0;i<p.length;i++){
				int px=posx+p[i].x;
				int py=posy+p[i].y;
=======
			Point[] req = ((Ship)ship).requirements();
			boolean ok = true;
			
			for(int tmp=0;tmp<req.length;tmp++){
				System.out.println(tmp);
				System.out.println(req);
				System.out.println(req[tmp]);
				System.out.println(req[tmp].x);

				int px=req[tmp].x;
				int py=req[tmp].y;
>>>>>>> origin/master
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
<<<<<<< HEAD
				setship(ship,player,posx,posy);
=======
				setship(ship,player,i,j);
>>>>>>> origin/master
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

<<<<<<< HEAD
					tela.update();
					
			}
					
			
			
			
			
=======
		}
		else{
			if(!isWater(player,i,j)){
				setship(null,player,i,j);
				//pego o ship de i,j
				//vai no ship e poe used como false
				//board[i][j] e botar null
				//p cada req do ship, muda cor p agua

			}
>>>>>>> origin/master
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
<<<<<<< HEAD
	
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
=======
	public Point coord2index(Point p){
		return tela.getBoard().coord2index(p);
	}
	public void setship(Ship ship,int player, int i, int j) {
		Ship[][] b = getBoard(player);

		if(ship!=null){
			Point[] p = ship.requirements();
			for(int k=0;k<p.length;k++){
				b[i+p[k].x][j+p[k].y] = ship;
>>>>>>> origin/master
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
<<<<<<< HEAD
		if(player == 1){
			return Board1[i][j];
		}
		if(player == 2){
			return Board2[i][j];
		}
		return null;
	}

=======
		Ship[][] b = getBoard(player);
		if(b!=null){
				return b[i][j];
		}
		return null;
	}
	
>>>>>>> origin/master
}
