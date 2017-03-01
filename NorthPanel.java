package lockerfish.com;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JLabel;

public class NorthPanel extends JPanel implements ActionListener {

	public NorthPanel(){
		setBackground(Color.blue);
		setPreferredSize(new Dimension(50,50));
		 //setLayout(new GridLayout(1, 3));
		JLabel jl = new JLabel("North");
		add(jl);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	
	}
	
}
