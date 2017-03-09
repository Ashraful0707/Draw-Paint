package lockerfish.com;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class eastJapanel extends JPanel {

	public  eastJapanel(){
		
		setBackground(Color.orange);
		JLabel jl = new JLabel("East");
		add(jl);
		setPreferredSize(new Dimension(75,75));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
}
}
