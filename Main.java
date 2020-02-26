package newPackage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

	//player
	
	
	

    public static void main(String[] args) {
        new Main();
    }

    //sets up anything I want set up.
    public void setup()
    {
    	
    }
    
    
    
    
    
    //classes
    public Main() {
    	
    	
    	
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {
    	
    	
    	
    	
        private int xDelta = 0;
        private int yDelta = 0;
        private int keyPressCount = 0;
        private Timer repaintTimer;
        private Timer yRepaintTimer;
        private int xPos = 0;
        private int yPos = 0;
        private int radius = 10;

        public TestPane() {
            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = getActionMap();

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "pressed.left");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "pressed.right");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "released.left");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "released.right");

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "pressed.up");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "pressed.down");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "released.up");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "released.down");

            
            am.put("pressed.left", new MoveAction(-2, true));
            am.put("pressed.right", new MoveAction(2, true));
            am.put("released.left", new MoveAction(0, false));
            am.put("released.right", new MoveAction(0, false));
            
            am.put("pressed.up", new MoveAction(-1, true));
            am.put("pressed.down", new MoveAction(1, true));
            am.put("released.up", new MoveAction(0, false));
            am.put("released.down", new MoveAction(0, false));

           

            
            repaintTimer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                 
                    
                    //
                    if(xDelta == -2 || xDelta == 2)
                    {
                    	
                    	xPos += xDelta;
                    	if(xPos < 0) {
                            xPos = 0;
                        }
                        else if (xPos + radius > getWidth()) {
                            xPos = getWidth() - radius;
                        }
                        repaint();
                    	
                    }
                    
                    else if(yDelta == -1 || yDelta == 1)
                    {
                    	
                    	yPos += yDelta;
                    	 if(yPos < 0) {
                             yPos = 0;
                         }
                         else if (yPos + radius > getHeight()) {
                             yPos = getHeight() - radius;
                         }
                         repaint();
                    	
                    }
                    
                    
                    
                    
                    
                    //
                    
                   
                }
            });
            repaintTimer.setInitialDelay(0);
            repaintTimer.setRepeats(true);
            repaintTimer.setCoalesce(true);
            
            
            
            
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 800);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            //g2d.setColor(Color.RED);
            
            Image background = new ImageIcon("background.jpg").getImage();
            g2d.drawImage(background, 0, 0, this);
            
            
            Image image = new ImageIcon("red.png").getImage();
            g2d.drawImage(image,xPos,yPos, 30, 30, this);
            
            g2d.dispose();
        }

        public class MoveAction extends AbstractAction {

            private int direction;
            private boolean keyDown;

            public MoveAction(int direction, boolean down) {
                this.direction = direction;
                keyDown = down;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
            	xDelta = direction;
            	yDelta = direction;
               
                
               
                	
                	if (keyDown) 
                	{
                		if (!repaintTimer.isRunning()) 
                		{
                			repaintTimer.start();
                			
                		}
                	}	 
                	else 
                	{
                		repaintTimer.stop();
                		
                	}
                
                
            }
        }
    }


    

}