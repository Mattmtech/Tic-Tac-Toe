package TicTacToeGame;
import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tictactoe extends JFrame {

	private char currentTurn = 'X';
	
	private Cell[][] board = new Cell[3][3];
	
	JLabel jlStatus = new JLabel("X's turn");
	
	public Tictactoe() {
		JPanel panel = new JPanel(new GridLayout(3, 3, 0, 0));
		for (int i = 0; i < 3; i++)
	           for (int j = 0; j < 3; j++)
	               panel.add(board[i][j] = new Cell());
		
		add(panel, BorderLayout.CENTER);
		add(jlStatus, BorderLayout.SOUTH);
	}
	
	



	public boolean checkFull() {
		for ( int i = 0; i < 3; i++) 
			for (int j = 0; j < 3; i++) 
				if(board[i][j].getSymbol() == ' ') {
					return false;
				}
			
		
		return true;
	}
	
	public boolean checkWin(char symbol) {
		boolean check = false;
		
		check = checkRow(symbol);
		if (check == true) {
			return check;
		}
		
		check = checkCol(symbol);
		if (check == true) {
			return check;
		}
		check = checkDiag(symbol);
		if (check == true) {
			return check;
		}
		return check;
	}
	
	public boolean checkRow(char symbol) {
		for(int i = 0; i < 3; i++) {
			if (board[i][0].getSymbol() == symbol && board[i][1].getSymbol() == symbol && board[i][2].getSymbol() == symbol)
				return true;
		}
		return false;
	}
	
	public boolean checkCol(char symbol) {
		for ( int i = 0; i < 3; i++) {
			if(board[0][i].getSymbol() == symbol && board[1][i].getSymbol() == symbol && board[2][i].getSymbol() == symbol) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkDiag(char symbol) {
		if(board[0][0].getSymbol() == symbol && board[1][1].getSymbol() == symbol && board[2][2].getSymbol() == symbol) {
			return true;
		}
		if(board[0][2].getSymbol() == symbol && board[1][1].getSymbol() == symbol && board[2][0].getSymbol() == symbol) {
			return true;
		}
		
		return false;
	}

	
	
	public class Cell extends JPanel{
		private char symbol = ' ';
		
		public Cell() {
			addMouseListener (new MouseListener());
		}

		
		public char getSymbol() {
			return symbol;
		}
		
		public void setSymbol(char c) {
			symbol = c;
			repaint();
		}
		
	
	
	
	
	
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(19));
		if(symbol == 'X') {
			g2.setColor(Color.green);
			g2.drawLine(10, 10, getWidth()-10, getHeight()-10);
			g2.drawLine(getWidth()-10, 10, 10, getHeight()-10);
		}
		if (symbol == 'O') {
			g2.setColor(Color.red);
			g2.drawOval(10, 10, getWidth()-20, getHeight()-20);
		}
		
		
	}
	
	private class MouseListener extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			//if a cell is empty fill it with the symbol of the current turn
			if(symbol == ' ' && currentTurn != ' ') {
				setSymbol(currentTurn);
			}
			if (checkWin(currentTurn)) {
				jlStatus.setText(currentTurn + " Won! Game Over!");
				//set currentturn to X
			}
			else if (checkFull()) {
				jlStatus.setText("Game Over! Tie Game.");
			}else {
			currentTurn = (currentTurn == 'X') ? 'O' : 'X';
			jlStatus.setText(currentTurn + "'s turn.");
			}
		}
	}
  }
	
	
	
	
	
}

