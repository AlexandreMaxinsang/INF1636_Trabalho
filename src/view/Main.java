package view;

import javax.swing.JFrame;




public class Main extends JFrame{


	TelaEscolha telaInicialPlayer1 = new TelaEscolha("Player1");
	TelaEscolha telaInicialPlayer2 = new TelaEscolha("Player2");
	
	Main(){
		
        this.add(telaInicialPlayer1);
	}
	
	public static void main(String[] args) {
		
        Main jFrame = new Main();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(800, 600);
        jFrame.setVisible(true);
		jFrame.setLayout(null);
		

    }

	
	
	
}
