package lockerfish.com;



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class MyExample extends JPanel implements ActionListener {
  
	public MyExample (){
	  
  
	JButton jb = new JButton("color");
	jb.addActionListener(this);
	add(jb);
  }
	@Override
	public void actionPerformed(ActionEvent e) {
		Color color = JColorChooser.showDialog(this,"Choose a color", Color.orange);
		if(color!=null){
			setBackground(color);
		}
	}
}
