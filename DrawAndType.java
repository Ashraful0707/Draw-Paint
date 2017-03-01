package lockerfish.com;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class DrawAndType extends CercleDrawer implements KeyListener  {

	//private FontMetrics fm;
	//private int fontSize = 40;
	//Font font =  new Font("serif",Font.ITALIC, fontSize);
	
	public DrawAndType(){
		super();
		addKeyListener(this);
		//fm = getFontMetrics(font);
	}

	
	@Override
	public void keyTyped(KeyEvent e) {
		String s = String.valueOf(e.getKeyChar());
		Graphics g = getGraphics();
		//g.setColor(Color.RED);
		//g.drawString(s, getlastX(), getlastY());
		//record(getlastX()+fm.stringWidth(s),getlastY());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}


	

}
