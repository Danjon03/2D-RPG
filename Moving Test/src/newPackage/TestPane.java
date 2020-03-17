package newPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;



public class TestPane extends JPanel implements ActionListener, KeyListener 
{
	ArrayList<Item> itemList = new ArrayList<Item>();
	ArrayList<NPC> npcList = new ArrayList<NPC>();
	ArrayList<Quest> questList = new ArrayList<Quest>();
	ArrayList<barrier> barriers = new ArrayList<barrier>();
	Timer t = new Timer(5, this);
	int x = 0, y = 0, velx =0, vely=0;
	boolean textBoxFlag = false, movementFlag = true;
	
	String textBoxText = "default text";
	
	Player playerObj = new Player(980, 493, 80, 80);
	 Image player = new ImageIcon("red.png").getImage();
	String lastPressed;
	boolean collision=false;
	
	
	public TestPane()
	{
		t.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		createAllNPC();
		importItems();
		importQuests();
		importBarriers();
		
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		Image background = new ImageIcon("map2.png").getImage();
        g2.drawImage(background, x, y, 8000, 8000 , this);
        
        
        
        for(NPC z: npcList)
        {	
        	Image NPC = new ImageIcon(z.getImage()).getImage();
        	g2.drawImage(NPC, x + z.getXCoor(), y+ z.getYCoor(), 80, 80, this);
        	
        }
       
        
        for(Item l: itemList)
        {
        	if(l.isDraw() == true)
        	{
        		Image item = new ImageIcon("red.png").getImage();
        		g2.drawImage(item, x + l.getLocationX(), y+ l.getLocationY(), 80, 80, this);
        		
        	}
        }
        
        
        //the player should be the last thing you draw
       
        g2.drawImage(player, 981, 493, 80, 80, this);
        
        if(textBoxFlag == true)
        {
        	drawTextBox(g, textBoxText);
        }
        
        g2.dispose();
        
		
	}
	
	public void drawTextBox(Graphics g, String Text)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		g2.fillRect(200, 800, 1500, 200);
		g2.setColor(Color.WHITE);
		g2.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		
		
		if(Text != null)
			g2.drawString(Text, 250, 850);
			
		repaint();
	
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		x += velx;
		y += vely;
		collision();
		repaint();
	}
	
	
	boolean pressVertical;
	public void up()
	{
		
		
		
		
			vely = 1;
			velx = 0;
			pressVertical = true;
			//collision();
			
		
	}
	
	public void down() {
		
		
			vely = -1;
			velx=0;
			pressVertical = true;
			//collision();
			
		
	}
	
	public void left() {
		
		
			velx = 1;
			vely = 0;
			pressVertical = false;
			
			//collision();
		
		
		
		}
	
	public void right()
	{
		
		
		velx = -1;
		vely = 0;
		pressVertical = false;
		//collision();
		
		}
	
	@Override
	public void keyPressed(KeyEvent e)

	{
		
		
			
			int code = e.getKeyCode();
			if (code == KeyEvent.VK_UP ) {
				
				//collision();
					up();
					
					
				
				
			}
			if (code == KeyEvent.VK_DOWN ) {
				
				//collision();
					down();
					
				
			}
			if (code == KeyEvent.VK_LEFT ) {
				//collision();
				left();
					
				
			}
			if (code == KeyEvent.VK_RIGHT ) {
				//collision();
					right();
					
				
					
				
			}
			
			
		
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) 
	{
		char code = e.getKeyChar();
		if(code == 'e')
		{
			
			for(NPC l: npcList )
			{
				if((980 >= ((x + l.getXCoor()) - 100) && 980 <= ((x + l.getXCoor()) + 100) ) && (493 >= ((y + l.getYCoor()) - 100) && 493 <= ((y + l.getYCoor()) + 100) ))
				{
					if(textBoxFlag == false)
					{
								
						textBoxText = "Please Help";
						textBoxFlag= true;
						movementFlag = false;
						
						
					}
					else
					{
						textBoxFlag=false;
						movementFlag=true;
						
					}
				}
			}
			
			for(Item m: itemList)
			{
				if((980 >= ((x + m.getLocationX()) - 100) && 980 <= ((x + m.getLocationX()) + 100) ) && (493 >= ((y + m.getLocationY()) - 100) && 493 <= ((y + m.getLocationY()) + 100) ))
				{
					
					
					if(textBoxFlag == false)
					{
						textBoxFlag= true;
						movementFlag = false;
						textBoxText = "You Picked Up An " + m.getName();
						m.setInInventory(true);
						m.setDraw(false);
					}
					else
					{
						
						textBoxFlag=false;
						movementFlag=true;
						
					}
					
					
					
					
				}
			}
				
		}
			
		else
		{
			System.out.println("You typed something else");
		}
		
		
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		velx =0;
		vely=0;
		
		
		
		
	}
	
	public void createAllNPC()
	{
		 String csvFile = "NPCs.csv";
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";

	        try {

	            br = new BufferedReader(new FileReader(csvFile));
	            while ((line = br.readLine()) != null) {

	                // use comma as separator
	                String[] npc = line.split(cvsSplitBy);

	                //System.out.println("NPC [name= " + npc[0] + " , text=" + npc[1] + "]");
	                npcList.add(new NPC(npc[0], Integer.parseInt(npc[1]), npc[2], npc[3], Integer.parseInt(npc[4]), Integer.parseInt(npc[5])));
	            }

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
		
		//
	}
	
    public void importQuests()
    {
    	String csvFile = "Quests.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] npc = line.split(cvsSplitBy);

                //System.out.println("NPC [name= " + npc[0] + " , text=" + npc[1] + "]");
                questList.add(new Quest(npc[0], Integer.parseInt(npc[1]), npc[2], npc[3], Boolean.parseBoolean(npc[4]), Boolean.parseBoolean(npc[5]), Boolean.parseBoolean(npc[6])));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void importItems()
    {
    	String csvFile = "Items.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] npc = line.split(cvsSplitBy);

                //System.out.println("NPC [name= " + npc[0] + " , text=" + npc[1] + "]");
                itemList.add(new Item(npc[0], Integer.parseInt(npc[1]), npc[2], Integer.parseInt(npc[3]), Integer.parseInt(npc[4]), Boolean.parseBoolean(npc[5]), Boolean.parseBoolean(npc[6])));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void importBarriers()
    {
    	String csvFile = "barriers.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] npc = line.split(cvsSplitBy);

                //System.out.println("NPC [name= " + npc[0] + " , text=" + npc[1] + "]");
                barriers.add(new barrier( Integer.parseInt(npc[0]), Integer.parseInt(npc[1]), 80, 80));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void questing(NPC n)
    {
    	System.out.println("I am within");
    	int npcId = n.getId();
    	System.out.println(npcId);
    	for(Quest x: questList)
    	{
    		if(x.getId() == npcId)
    		{
    			for(Item y: itemList)
    			{
    				if(y.getId() == x.getId())
    				{
    					if(y.isInInventory() == true)
    					{
    						textBoxText ="Thank You Very Much";
    					}
    				}
    			}
    		}
    	}
    	
    }
    
    public void collision()
    {
    	
    	
    	
    	
    	for(barrier z: barriers)
    	{
    		Rectangle barrier = new Rectangle((x) + z.getX(), y+z.getY(), z.getWidth(), z.getHeight());
    		Rectangle playerRect = new Rectangle(playerObj.getX() - velx, playerObj.getY() - vely, playerObj.getWidth(), playerObj.getHeight());
    	
    		
    		
    		if(playerRect.intersects(barrier))
    		{
    			System.out.println("will intersect");
    			//collision=true;
    			
    			if(pressVertical == true)
    			{
    				y=y + (vely * -1);
    			}
    			else
    			{
    				x=x + (velx*-1);
    			}
    			
    			
    			velx = 0;
    			vely = 0;
    			break;
    		}
    		else
    		{
    			collision=false;
    		}
    		
    		
    		
    		
    	}
    	
    	
    	
    }
    
    
    
    
    
    
}