package TicTacToeGame;

import javax.swing.JFrame;

public class ticTacToeGame {

	public static void main(String[] args) {
		JFrame ttt = new Tictactoe();
		ttt.setTitle("Tic-Tac-Toe");
		ttt.setSize(600, 600);
		ttt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ttt.setLocationRelativeTo(null);
		ttt.setVisible(true);
		ttt.setResizable(false);
	}
}
