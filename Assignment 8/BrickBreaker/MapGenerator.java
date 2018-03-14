package BrickBreaker;

/**
 * Author - Kandarp Desai
 * CWID - 10419687
 * Date - 11/07/2017
 * Description - This program use to generate bricks. 
 **/
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;

public class MapGenerator {
	public int map[ ][ ];
	public int brickWidth;
	public int brickHeight;
	
	public MapGenerator(int row, int column) {
		map = new int[row][column];
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				map[i][j] = 1;					// here 1 detects that ball is not intersected with brick 
			}
		}
		brickWidth = 540/column;
		brickHeight = 150/row;
	}
	// This is used to draw bricks at particular position where value is map[i][j] = 1.
	public void drawBricks(Graphics2D g2d) {
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				// to draw brick at particular position
				if(map[i][j] > 0) {
					g2d.setColor(Color.WHITE);
					g2d.fillRect(j * brickWidth + 80, i *brickHeight + 50, brickWidth, brickHeight);
					
					g2d.setStroke(new BasicStroke(3));
					g2d.setColor(Color.BLACK);
					g2d.drawRect(j * brickWidth + 80, i *brickHeight + 50, brickWidth, brickHeight);
				}
				
			}
		}
	}
	public void setBricks(int value, int row, int column ) {
		map[row][column] = value;
	}
	

}
