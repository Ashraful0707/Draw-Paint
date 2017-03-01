package lockerfish.com;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class WestJPanel extends JPanel implements ActionListener {
	JRadioButton RBOnn ;
	JRadioButton RBoff;
	public  WestJPanel(){
		setBackground(Color.red);
		setPreferredSize(new Dimension(75,75));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		JLabel jl = new JLabel("West");
		ButtonGroup jg =new ButtonGroup();
		
		RBOnn = new JRadioButton("ON");
		RBOnn.setSelected(false);
		RBOnn.setActionCommand("shapesON");
		RBOnn.addActionListener(this);
		jg.add(RBOnn);
		
		RBoff = new JRadioButton("Off");
		RBoff.setSelected(false);
		RBoff.setActionCommand("shapesOff");
		RBoff.addActionListener(this);
		jg.add(RBoff);
		
		add(jl);
		add(RBOnn);
		add(RBoff);
		
}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		String btnClicked = e.getActionCommand();
		System.out.println("the command was:"+ btnClicked );
		switch(btnClicked){
		case "shapesON":
			CercleDrawer.drawShapes = true;
			break;
		case "shapesOff":
				
			DrawAndType.drawShapes = false;
				//System.out.println("Only for debugging");
				break;
				default:

					DrawAndType.drawShapes = false;
					break;
			
			
			
		}
	}
}
