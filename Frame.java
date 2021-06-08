package com;
import javax.swing.JFrame;

public class Frame {
	static JFrame frame;
	public static void main(String[]args) {
		if(frame ==null) {
			frame = new JFrame("Draw a line");
			frame.setSize(400,300);
			frame.setVisible(true);
		}

	}
	public static void printLines(int[] number) {
		int[] board= new int[4];
		board[0]=1;
		board[1]=3;
		board[2]=5;
		board[3]=7;
		Draw draw = new Draw(number,board);
		frame.add(draw);
		frame.setVisible(true);
	}

}