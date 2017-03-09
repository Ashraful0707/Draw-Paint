package lockerfish.com;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyJPanels extends JPanel implements ActionListener {
	private JLabel jLabel;
	
	public MyJPanels(){
		setBackground(Color.blue);
		jLabel= new JLabel("General");
		add(jLabel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	
}
}