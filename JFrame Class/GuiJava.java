package lockerfish.com;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GuiJava extends JFrame implements ActionListener{
	
	JButton btn1,btn2,btn3, btn4, btn5,btn6,bBtn, lBtn, eBtn, rBtn, sBtn, fBtn; 
	JPanel panel;
	JSlider tSlider;
    JLabel tLabel;
    Color fontColor;
	
	southJPanel sp;
	NorthPanel np;
	WestJPanel wp;
	eastJapanel ep;
    CercleDrawer cd;
    DrawAndType dt;
    DrawingBoard db;
    ListenForSlider ls;
    DrawingPanel dp;
    ComboBoxListener cm;


  DecimalFormat dec = new DecimalFormat("#.##");
  Graphics2D graphSettings;
     
    int currentAction = 1;
    float transparentVal = 1.0f;
    Color strokeColor=Color.blue, fillColor=Color.blue;
    
     String[] fStyleL = { "Plain", "Bold", "Italic", "Bold&Italic" };
      int BOLDITALIC = Font.BOLD | Font.ITALIC;
      int[] fontStyles = { Font.PLAIN, Font.BOLD, Font.ITALIC, BOLDITALIC };
      String[] fSizeL = { "10", "11", "12", "14", "18", "25","36", "72" };
    JComboBox fBox, fSBox = new JComboBox(fStyleL), 
    		  fSizesBox  = new JComboBox(fSizeL);
   
 
 public GuiJava() 
 {
	JPanel panel = new JPanel();
	panel.setLayout(new BorderLayout());
	
	 np = new NorthPanel();
	 sp = new southJPanel();
	 wp = new WestJPanel();
	 ep = new eastJapanel();
 	 dt = new DrawAndType();
	 db = new DrawingBoard();
	 ls = new ListenForSlider();
	 dp = new DrawingPanel();
	// cm = new ComboBoxListener ();
	
    
	 
	 
	 btn3 = new JButton("Refresh");
     sp.add(btn3);
 	 btn3.addActionListener(this);
 	 
 	 btn1 = new JButton("Color");
     sp.add(btn1);
     btn1.addActionListener(this);
    
     btn2 = new JButton("Color");
     wp.add(btn2);
     btn2.addActionListener(this);
    
	
     btn4 = new JButton("Color");
	 ep.add(btn4);
	 btn4.addActionListener(this);
	 
	 btn5 = new JButton("Color");
	 np.add(btn5);
	 btn5.addActionListener(this);
	
	 btn6 = new JButton("FontCl");
	 wp.add(btn6);
	 btn6.addActionListener(this);
	
   
     bBtn = makeMeButtons("./src/brush.png", 1);
   
     lBtn = makeMeButtons("./src/Line.png", 2);

     eBtn = makeMeButtons("./src/Ellipse.png", 3);

     rBtn = makeMeButtons("./src/Rectangle.png", 4);

      

     // Make all the buttons in makeMeColorButton by passing the

     // button icon and true for stroke color or false for fill

      

     sBtn = makeMeColorButton("./src/Stroke.png", 5, true);

     fBtn = makeMeColorButton("./src/Fill.png", 6, false);
    
    ep.add(bBtn);

    ep.add(lBtn);

    ep.add(eBtn);

    ep.add(rBtn);

    ep.add(sBtn);
    ep.add(fBtn);
   
    
     tLabel = new JLabel("Transparency:");
     tSlider = new JSlider(1, 99, 99);
    

     ListenForSlider lForSlider = new ListenForSlider();// instance of ListenForEvents to handle events
     tSlider.addChangeListener(lForSlider);
     sp.add(tLabel);
     sp.add(tSlider);


     Container container = getContentPane();
     container.add(dp);
     
     fBox= new JComboBox(dp.fFamilyNames);
     fBox.setSelectedItem("Times"); 
     fBox.addActionListener(new ComboBoxListener());
     btn5.add(fBox);
     fSBox.addActionListener(new ComboBoxListener());

     fSizesBox.setSelectedItem("12");
     fSizesBox.addActionListener(new ComboBoxListener());
     np.add(fBox);
     np.add(fSBox);
     np.add(fSizesBox);
     
    container.add(BorderLayout.NORTH, np);
    panel.add(BorderLayout.NORTH,np);
	panel.add(BorderLayout.SOUTH,sp);
	panel.add(BorderLayout.EAST,ep);
	panel.add(BorderLayout.WEST,wp);
	panel.add(BorderLayout.CENTER,dp);
	
	setLayout(new BorderLayout());
	setSize(800,600);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("My Paint App");   
	this.add(panel);
	setVisible(true);	    
	 
 }
 
public class ComboBoxListener extends DrawingBoard implements ActionListener { 
	                                                           // Source Taken from The Java™ Tutorials
	    public void actionPerformed(ActionEvent e) {
	      JComboBox tBox = (JComboBox) e.getSource();

	      if (tBox.equals(fBox)) {
	        dp.fFamilyName = (String) tBox.getSelectedItem();
	        dp.repaint();
	      } else if (tBox.equals(fSBox)) {
	    	  dp.fStyle = fontStyles[tBox.getSelectedIndex()];
	    	  dp.repaint();
	      } else if (tBox.equals(fSizesBox)) {
	    	  dp.fontSize = Integer.parseInt((String) tBox
	            .getSelectedItem());
	    	  dp.repaint();
	      }
	    }
	  }
public class DrawingPanel  extends DrawingBoard implements KeyListener, ActionListener 
{
	
	JButton btn5;
	String fFamilyName;
    int fStyle;
 
    String[ ] fFamilyNames;
    private FontMetrics fm;
  	private int fontSize = 50;
  	Font font =  new Font("Times",Font.ITALIC, fontSize);
   
  	public DrawingPanel() {
    addKeyListener(this);
    fm = getFontMetrics(font);

    fStyle = Font.PLAIN;

    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    fFamilyNames = ge.getAvailableFontFamilyNames();
     
    }

    public void keyTyped(KeyEvent e) {
		
    	String s = String.valueOf(e.getKeyChar());
		
		Graphics g = getGraphics();
		Graphics2D g2D = (Graphics2D) g;

		g2D.setColor(fontColor);

		//g2D.setColor(Color.red);
		
		g2D.setFont(new Font(fFamilyName, fStyle, fontSize));
		record(getlastX()+fm.stringWidth(s),getlastY());
		g2D.drawString(s, getlastX(), getlastY());
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		
//		 if (s == )
//		{
//			 Color color = JColorChooser.showDialog(this,"Choose a color", Color.orange);
//			ep.setBackground(color);
//		
	  }
		
		
	}
    
   
  


	

 public JButton makeMeButtons(String iconFile, final int actionNum)
 {

     JButton btn = new JButton();

     Icon btnIcon = new ImageIcon(iconFile);

     btn.setIcon(btnIcon);

      

     // Make the proper actionPerformed method execute when the

     // specific button is pressed

      

     btn.addActionListener(new ActionListener() 
     {



         public void actionPerformed(ActionEvent e) 
         {

             currentAction = actionNum;

           
         	

         }

     });

     return btn; 

 }
 public JButton makeMeColorButton(String iconFile, final int actionNum, final boolean stroke)
 {

     JButton Jbtn = new JButton();

     Icon btnIcon = new ImageIcon(iconFile);
     Jbtn.setIcon(btnIcon);

      

     Jbtn.addActionListener(new ActionListener() {



         public void actionPerformed(ActionEvent e) {

              

             if(stroke){

                  

                 // JColorChooser is a popup that lets you pick a color

                  

                 strokeColor = JColorChooser.showDialog(null,  "Pick a Stroke", Color.BLACK);

             } else {

                 fillColor = JColorChooser.showDialog(null,  "Pick a Fill", Color.BLACK);

             }

              

         }

     });


     return Jbtn; 

 }
 
 
		public static void main(String[] args) 
        {
	 
	
	     new GuiJava();
	     
}
@Override

public void actionPerformed(ActionEvent e) 
{
	Object source = e.getSource();
	if (source== btn3 )
	{
		dp.repaint();
	}
	else if (source == btn2)
	{
		Color color = JColorChooser.showDialog(this,"Choose a color", Color.blue);
		wp.setBackground(color);
	}
	
	else if (source == btn1)
	{
		Color color = JColorChooser.showDialog(this,"Choose a color", Color.cyan);
		sp.setBackground(color);
    }
	else if (source == btn4)
	{
		Color color = JColorChooser.showDialog(this,"Choose a color", Color.orange);
		ep.setBackground(color);
		
	
     }
	else if (source == btn5)
	{
		Color color = JColorChooser.showDialog(this,"Choose a color", Color.LIGHT_GRAY);
		np.setBackground(color);
		
	
     }
	else if (source == btn6)
	{
		Color color = JColorChooser.showDialog(this,"Choose a color", Color.LIGHT_GRAY);
		ep.setBackground(color);
		fontColor = color;
   }
}
private class DrawingBoard extends CercleDrawer        // Source taken from Youtube

{
 
       
	
	    ArrayList<Shape> shapes = new ArrayList<Shape>();

        ArrayList<Color> shapeFill = new ArrayList<Color>();

        ArrayList<Color> shapeStroke = new ArrayList<Color>();

        ArrayList<Float> transPercent = new ArrayList<Float>();

        Point dStart, dEnd;

        

        public DrawingBoard()

        {

             

       this.addMouseListener(new MouseAdapter()

       {

                     

        public void mousePressed(MouseEvent e)

        {                    

        if(currentAction != 1){
                         

        dStart = new Point(e.getX(), e.getY());

        dEnd = dStart;

        repaint();

                      
        }
                        
                         
        }                    

                        



       public void mouseReleased(MouseEvent e)

       {
 
      if(currentAction != 1){
                   

       Shape shape = null;

                         

                        if (currentAction == 2){

                            shape = drawLine(dStart.x, dStart.y,

                                    e.getX(), e.getY());
                     } else

                         

                        if (currentAction == 3){

                            shape = drawEllipse(dStart.x, dStart.y,

                                    e.getX(), e.getY());

                        } else

                         

                        if (currentAction == 4) {

                             

                            

                             

                       shape = drawRectangle(dStart.x, dStart.y,

                       e.getX(), e.getY());
                       Object source = e.getSource();
                        	
                           

              }               
                       

            shapes.add(shape);

            shapeFill.add(fillColor);

            shapeStroke.add(strokeColor);
                           

           transPercent.add(transparentVal);

                           
           dStart = null;

           dEnd = null;

           repaint();

                           

           }

                           

        }

   } );


     this.addMouseMotionListener(new MouseMotionAdapter()

      {

      public void mouseDragged(MouseEvent e)

      {

                       

       if(currentAction == 1){

       int x = e.getX();

       int y = e.getY();

       Shape shape = null;

                         
       strokeColor = fillColor;

       shape = drawBrush(x,y,5,5);

       shapes.add(shape);

       shapeFill.add(fillColor);

       shapeStroke.add(strokeColor);                 
       transPercent.add(transparentVal);            
                           

      }

                       
       dEnd = new Point(e.getX(), e.getY());  // final x & y position after the mouse is dragged

       repaint();

     }

   } );

}

     public void changeSize(int value) {
			
			
     	}                   

     public void paint(Graphics g)

     {

           

          

             graphSettings = (Graphics2D)g;    // Class used to define the shapes to be drawn
    

             graphSettings.setRenderingHint(RenderingHints.KEY_ANTIALIASING,

                     RenderingHints.VALUE_ANTIALIAS_ON);

             // Antialiasing cleans up the jagged lines and defines rendering rules

             // Defines the line width of the stroke

              
             graphSettings.setStroke(new BasicStroke(4));



             

             Iterator<Color> strokeCounter = shapeStroke.iterator();

             Iterator<Color> fillCounter = shapeFill.iterator();
          
            // Iterators created to cycle through strokes and fills


             Iterator<Float> transCounter = transPercent.iterator();
          

             for (Shape s : shapes)

             {


                 graphSettings.setComposite(AlphaComposite.getInstance(

                         AlphaComposite.SRC_OVER, transCounter.next()));
                       // shapes transparency value
                  

                 

                 graphSettings.setPaint(strokeCounter.next());
              // Grabs the next stroke from the color arraylist
                
                 graphSettings.draw(s);

                 graphSettings.setPaint(fillCounter.next());

                 graphSettings.fill(s);

             }
    

            if (dStart != null && dEnd != null)  // Guide shape used for drawing

            {

            graphSettings.setComposite(AlphaComposite.getInstance(

            AlphaComposite.SRC_OVER, 0.40f));

                     

                    // Make guide shape gray for professional look

                     

                    graphSettings.setPaint(Color.LIGHT_GRAY);

                     

                    Shape aShape = null;

                     

                    if (currentAction == 2){

                        aShape = drawLine(dStart.x, dStart.y,

                                dEnd.x, dEnd.y);

                    } else

                     

                    if (currentAction == 3){

                        aShape = drawEllipse(dStart.x, dStart.y,

                                dEnd.x, dEnd.y);

                    } else

                     

                    if (currentAction == 4) {
                   

                         
                    aShape = drawRectangle(dStart.x, dStart.y,

                                dEnd.x, dEnd.y);

                    }
                         

                        graphSettings.draw(aShape);

                }

        }



        private Rectangle2D.Float drawRectangle(

                int x1, int y1, int x2, int y2)

        {



            

             

                int x = Math.min(x1, x2); // top left hand corner for the shape

                int y = Math.min(y1, y2);
             // Math.min returns the points closest to 0
                 

                
                 int width = Math.abs(x1 - x2);

                int height = Math.abs(y1 - y2);


                return new Rectangle2D.Float(

                        x, y, width, height);

        }

       

         

        private Ellipse2D.Float drawEllipse(

                int x1, int y1, int x2, int y2)

        {

                int x = Math.min(x1, x2);

                int y = Math.min(y1, y2);

                int width = Math.abs(x1 - x2);

                int height = Math.abs(y1 - y2);


                return new Ellipse2D.Float(

                        x, y, width, height);

        }

         

        private Line2D.Float drawLine(

                int x1, int y1, int x2, int y2)

        {



                return new Line2D.Float(

                        x1, y1, x2, y2);

        }

        private Ellipse2D.Float drawBrush(

                int x1, int y1, int brushStrokeWidth, int brushStrokeHeight)

        {

            return new Ellipse2D.Float(

                    x1, y1, brushStrokeWidth, brushStrokeHeight);

             

        }



}



 

private class ListenForSlider extends  DrawingPanel  implements ChangeListener{

	

     

    public void stateChanged(ChangeEvent e) {

    	
        if(e.getSource() == tSlider){
     

            

     

            tLabel.setText("Transparent: " + dec.format(tSlider.getValue() * .01) );

             

          

             

            transparentVal = (float) (tSlider.getValue() * .01);

             

        }
        
        

    }

    }




     }
