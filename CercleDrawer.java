package lockerfish.com;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;



public class CercleDrawer extends JPanel implements MouseListener, MouseMotionListener {
	 
	int size;
	public int circleSize = 50;
	int lastX = 0, lastY=0;
	private int times =0;
	public static boolean drawShapes= false;
	
	public CercleDrawer(){
		setSize(400,400);
		setBackground(Color.white);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		 record(x,y);
		
		if (drawShapes){
			times++;
			record (e.getX(), e.getY());
		
		
		
		
		Graphics g =  getGraphics();
		Graphics2D g2d = (Graphics2D)g;
		g2d.fillOval(lastX-(circleSize/2), lastY-(circleSize/2), circleSize, circleSize);
		
		
	}

		
		}	
	

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		requestFocus();
		record(e.getX(), e.getY());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		int x = e.getX();
		int y = e.getY();
		Graphics g =  getGraphics();
		Graphics2D g2d = (Graphics2D)g;
		((Graphics2D)g2d).setStroke(new BasicStroke(size));// use a variable that will have the line width
		g2d.setColor(Color.blue);// use a variable that will have the drawing color
		g2d.drawLine(lastX, lastY, x, y);
		record(x,y);
		
		
		
	}
	
	protected void record ( int x,int y){
		lastX =x;
		lastY = y;
	}
	
	public int getlastX(){
		return lastX;
	}
	public int getlastY(){
		return lastY;
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		record(e.getX(),e.getY());
		
	}

}
