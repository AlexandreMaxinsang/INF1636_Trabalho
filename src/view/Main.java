package view;

import javax.swing.JFrame;




public class Main extends JFrame{

	
	Main(){
		
		TelaEscolha tela = new TelaEscolha();
        this.add(tela);
        
	}
	
	public static void main(String[] args) {
		
        Main jFrame = new Main();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(800, 600);
        jFrame.setVisible(true);
		jFrame.setLayout(null);

    }

	
	
	
}
