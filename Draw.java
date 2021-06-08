package com;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Draw extends JPanel {
	int[] rows;
	int[] board;

	public Draw(int[] rows, int[] board) {
		this.rows = rows;
		this.board = board;
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int offsetY = 25, offsetX = 20, markerSize = 5, gup = 1;
		Graphics2D g2 = (Graphics2D) g;
		// ptirt board numbers
		for (int i = 1; i <= rows.length; i++) {
			g2.setStroke(new BasicStroke(2));
			g2.setColor(Color.DARK_GRAY);
			g2.drawString(String.valueOf(i), offsetX - 18, offsetY * i + 12);
			g2.setStroke(new BasicStroke(1));
			g2.setColor(Color.LIGHT_GRAY);
			g2.drawLine((offsetX) - 15, offsetY * i - 4, (offsetX) * (getBiggestNumber(board) + 1), offsetY * i - 4);

		}
		for (int i = 1; i <= getBiggestNumber(board); i++) {
			g2.setStroke(new BasicStroke(2));
			g2.setColor(Color.DARK_GRAY);
			g2.drawString(String.valueOf(i), offsetX * i - 2, offsetY - 5);
			g2.setStroke(new BasicStroke(1));
			g2.setColor(Color.LIGHT_GRAY);
			g2.drawLine((offsetX) * i - 8, offsetY - 15, (offsetX) * i - 8, offsetY * (board.length + 1));
		}
		for (int boardY = 1; boardY <= rows.length; boardY++) {
			for (int boardX = 1; boardX <= board[boardY - 1]; boardX++) {
				if (boardX <= rows[boardY - 1]) {
					g2.setStroke(new BasicStroke(2));
					g2.setColor(Color.gray);
					g2.drawLine(offsetX * boardX, offsetY * boardY + 15, offsetX * boardX, offsetY * boardY + gup);

				} else {
					g2.setStroke(new BasicStroke(2));
					g2.setColor(Color.gray);
					g2.drawLine(offsetX * boardX, offsetY * boardY + 15, offsetX * boardX, offsetY * boardY + gup);
					g2.setStroke(new BasicStroke(2));
					g2.setColor(Color.red);
					g2.drawLine(offsetX * boardX - markerSize, offsetY * boardY + 15, offsetX * boardX + markerSize,
							offsetY * boardY + gup);
					g2.setStroke(new BasicStroke(2));
					g2.setColor(Color.red);
					g2.drawLine(offsetX * boardX + markerSize, offsetY * boardY + 15, offsetX * boardX - markerSize,
							offsetY * boardY + gup);
				}
			}
		}
	}

	private int getBiggestNumber(int[] number) {
		int temp = 0;
		for (int i = 0; i < number.length; i++) {
			if (temp < number[i]) {
				temp = number[i];
			}
		}
		return temp;
	}
}