import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// public class GameData
// {
//    public static void main(String[] args)
//    {
//       UIManager UI = new UIManager();
//       UI.put("OptionPane.background", Color.BLACK);
//       UI.put("Panel.background",Color.BLACK);
//       Player player = new Player();
//       JFrame frame = new JFrame();
//       SceneFrame frame1,frame2,frame3;
//       MonsterFrame monster1,monster2;
//       MiscFrame misc;
//       TreasureFrame treasure;
//       InventoryFrame inventory = new InventoryFrame(player);
//       KeyFrame key;
//       MouseListener listener1, listener2,listener3;
//       frame1 = new SceneFrame("entryFlowerBed.png");
//       frame2 = new SceneFrame("indoor1TheRuins.png");
//       frame3 = new SceneFrame("indoor1TheRuins.png");
//       monster1 = new MonsterFrame("mediaBlindDogGif.gif","Blind Doggo",player);
//      // monster2 =  new MonsterFrame("mediaMuffetGif.gif","Muffet");
//       treasure = new TreasureFrame("mediaSpaghetti.png", "Moldy Spaghetti Bowl",player);
//       key = new KeyFrame("mediaHeartSoulGif.gif","Human Soul",player);
//       misc = new MiscFrame();
//       misc.setText("Thats you dummy!");
//       listener1 = new MouseListener(frame1, inventory);
//       listener2 = new MouseListener(frame2, inventory);
//       listener3 = new MouseListener(frame3, inventory);
//       
//       listener1.addDoorLocation(669,415,793,503,frame2);
//       listener1.addMonsterLocation(301,300,450,404,monster1);
//       listener1.addMiscLocation(358,300,408,383,misc);
//      
//       listener2.addKeyLocation(240,215,276,252,key);
//       listener2.addTreasureLocation(295,362,502,595,treasure);
//       listener2.addDoorLocation(362,83,428,177,frame3);
//       
//       listener3.addKeyLocation(240,215,276,252,key);
//       listener3.addTreasureLocation(295,362,502,595,treasure);
//       listener3.addDoorLocation(362,83,428,177,frame1);
//       
//       
//       frame1.addMouseListener(listener1);
//       frame2.addMouseListener(listener2);
//       frame3.addMouseListener(listener3);
//       frame1.setVisible(frame);
//    }
// }

class Location
{
   int column1,row1,column2, row2;
   GameFrame room;
   Location()
   {
      column1 = 0;
      column2 = 0;
      row1 = 0;
      row2 = 0;
      room = new GameFrame("");
   }
   Location(int x1,int y1, int x2, int y2, GameFrame room)
   {
      column1 = x1;
      row1 = y1;
      column2 = x2;
      row2 = y2;
      this.room = room;
   }
   public int validate()
   {
      return column1+column2+row1+row2;
   }
   public int getColumn1()
   {
      return column1;
   }
   public int getRow1()
   {
      return row1;
   }
   public int getColumn2()
   {
      return column2;
   }
   public int getRow2()
   {
      return row2;
   }
   public GameFrame getFrame()
   {
      return room;
   }
}
class GameFrame
{
   JFrame frame =  new JFrame();
   JPanel panel =  new JPanel();
   String imageFileName;
   GameFrame(String image)
   {
      imageFileName = image;
      
   }
   public JFrame getFrame()
   {
      return frame;
   }
   public void setVisible(JFrame previousFrame)
   {
   
   }
}

class SceneFrame extends GameFrame
{
   SceneFrame(String imageFileName)
   {
      super(imageFileName);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setupFrame();
   }
   public void setupFrame()
   {
      JLabel imageLabel  = new JLabel();
      imageLabel.setIcon(new ImageIcon(imageFileName));
      panel.add(imageLabel);
      frame.add(panel);
      frame.pack();
      frame.setLocationRelativeTo(null);
   }
   public void setVisible(JFrame previousFrame)
   {
      previousFrame.setVisible(false);
      frame.setVisible(true);
   }
   
   public void addMouseListener(MouseListener listener)
   {
      panel.addMouseListener(listener);
   }
}
class SubGameFrame extends GameFrame
{
   String objectName;
   Player player;
   SubGameFrame(String imageFileName, String name, Player player)
   {
      super(imageFileName);
      objectName = name;
      this.player = player;
      setupFrame();
   }
   public void setVisible(JFrame previousFrame)
   {
      frame.setVisible(true);
   }
   public void setSubFrameDefaults(String text)
   {
      JLabel imageLabel  = new JLabel();
      JLabel greetingLabel = new JLabel(text);
      
      imageLabel.setIcon(new ImageIcon(imageFileName));
      imageLabel.setBounds(0,0,500,598);
      imageLabel.setHorizontalAlignment(JLabel.CENTER);
      imageLabel.setVerticalAlignment(JLabel.TOP);
      
      greetingLabel.setBounds(0,0,500,598);
      greetingLabel.setHorizontalAlignment(JLabel.CENTER);
      greetingLabel.setVerticalAlignment(JLabel.CENTER);
      greetingLabel.setFont(new Font("Determination Mono", Font.PLAIN, 14));
      greetingLabel.setForeground(Color.WHITE);
      
      
      panel.add(greetingLabel);
      panel.add(imageLabel);
      panel.setLayout(null);
      frame.setSize(500,598);
      frame.setLocationRelativeTo(null);
   }
   public void setupFrame()
   {
      
   }
}
class MonsterFrame extends SubGameFrame
{
   MonsterFrame(String imageFileName, String name, Player player)
   {
      super(imageFileName, name, player);
   }
   public void setupFrame()
   { 
      JButton bribeButton = new JButton("Bribe!");
      JButton feedButton = new JButton("Feed!");
      JButton runButton = new JButton("Run!");
      setSubFrameDefaults("Oh no! "+objectName+" stands in your way!What will you do?");
      bribeButton.setBounds(90,450,150,20);
      feedButton.setBounds(300,450,150,20);
      runButton.setBounds(90,500,150,20);
      bribeButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               
               if (player.bribeMonster(1000))
               {
                  JOptionPane.showMessageDialog(null,"Do you actually think I can be BRIBED human?!?!?!? (Takes money anyway)");
                  //userInterface.showMsgGameDialog(getFrame(),"Do you actually think I can be BRIBED human?","");
                  getFrame().setVisible(false);
               }
               else
                  JOptionPane.showMessageDialog(null,"Not enough dough bro");
            }
         }
         );
      feedButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               if(player.feedMonster())
               {
                  JOptionPane.showMessageDialog(null,"Delicious! (This spaghetti is horrible...)");
                  getFrame().setVisible(false);
               }
               else
                  JOptionPane.showMessageDialog(null,"You don't even have any food...");
            }
         }
         );
      runButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               JOptionPane.showMessageDialog(null,"Run away you sucker!");
               getFrame().setVisible(false);
            }
         }
         );
      panel.add(runButton);
      panel.add(feedButton);
      panel.add(bribeButton);
      
      frame.add(panel);
   }
}
class TreasureFrame extends SubGameFrame
{
   TreasureFrame(String imageFileName, String name, Player player)
   {
      super(imageFileName, name, player); 
   }
   public void setupFrame()
   { 
      JButton okButton = new JButton("Add to Inventory");
      setSubFrameDefaults("Nice! You just found a "+objectName+"!");
      okButton.setBounds(175,450,150,20);
      okButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               player.addTreasureToInventory();
               getFrame().setVisible(false);
            }
         }
         );
      
      panel.add(okButton);
      
      frame.add(panel);
   }
}
class KeyFrame extends SubGameFrame
{
   KeyFrame(String imageFileName, String name, Player player)
   {
      super(imageFileName, name,player); 
   }
   public void setupFrame()
   { 
      JButton okButton = new JButton("Add to inventory");
      setSubFrameDefaults("A "+objectName+"! You can finally open the portal home!");
      
      okButton.setBounds(175,450,150,20);
      okButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               player.addKeyToInventory();
               getFrame().setVisible(false);
            }
         }
         );
      
      panel.add(okButton);
      
      frame.add(panel);
   }
}
class MiscFrame extends GameFrame
{
   JLabel text = new JLabel("");
   JLabel image = new JLabel();
   MiscFrame(String text)
   {
      super("mediaTemmyGif.gif");
      this.text.setText(text);
      setupFrame();
   }
   public void setupFrame()
   {
      JButton okButton = new JButton("Ok");
      image.setIcon(new ImageIcon(imageFileName));
      image.setBounds(0,40,600,350);
      image.setHorizontalAlignment(JLabel.CENTER);
      image.setVerticalAlignment(JLabel.TOP);
      
      text.setBounds(0,30,600,350);
      text.setHorizontalAlignment(JLabel.CENTER);
      text.setVerticalAlignment(JLabel.CENTER);
      text.setFont(new Font ("Determination Mono",Font.BOLD,15));
      text.setForeground(Color.WHITE);
      
      okButton.setBounds(225,280,150,20);
      okButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               
               getFrame().setVisible(false);
            }
         }
         );
      
      panel.add(okButton);
      panel.setLayout(null);
      panel.add(image);
      panel.add(text);
      frame.add(panel);
      frame.setSize(600,350);
      frame.setLocationRelativeTo(null);
   }
   public void setVisible(JFrame previousFrame)
   {
      getFrame().setVisible(true);
   }
}
class InventoryFrame extends GameFrame
{
   Player player;
   JLabel textKeyLabel = new JLabel() ;
   JLabel textTreasureLabel =  new JLabel() ;
   JLabel textBalanceLabel = new JLabel();
      
   InventoryFrame(Player player)
   {
      super("mediaInventory.png");
      this.player = player;
      setupFrame();
   }
   public void setupFrame()
   {
      JButton okButton = new JButton("Back To Game");
      JLabel imageKeyLabel  = new JLabel();
      JLabel imageTreasureLabel = new JLabel();
      JLabel imageLabel = new JLabel();
     
      imageLabel.setIcon(new ImageIcon(imageFileName));
      imageLabel.setBounds(0,0,500,598);
      imageLabel.setHorizontalAlignment(JLabel.CENTER);
      imageLabel.setVerticalAlignment(JLabel.TOP);
      
      // imageKeyLabel.setIcon(new ImageIcon("mediaHeartSoulGif.gif"));
//       imageKeyLabel.setBounds(0,0,500,598);
//       imageKeyLabel.setHorizontalAlignment(JLabel.CENTER);
//       imageKeyLabel.setVerticalAlignment(JLabel.TOP);
      
      textKeyLabel.setBounds(0,180,500,598);
      textKeyLabel.setHorizontalAlignment(JLabel.CENTER);
      textKeyLabel.setVerticalAlignment(JLabel.TOP);
      textKeyLabel.setFont(new Font("Determination Mono", Font.PLAIN, 15));
      textKeyLabel.setForeground(Color.WHITE);
      
      textTreasureLabel.setBounds(0,50,500,598);
      textTreasureLabel.setHorizontalAlignment(JLabel.CENTER);
      textTreasureLabel.setVerticalAlignment(JLabel.CENTER);
      textTreasureLabel.setFont(new Font("Determination Mono", Font.PLAIN, 15));
      textTreasureLabel.setForeground(Color.WHITE);
      
      textBalanceLabel.setBounds(0,80,500,598);
      textBalanceLabel.setHorizontalAlignment(JLabel.CENTER);
      textBalanceLabel.setVerticalAlignment(JLabel.CENTER);
      textBalanceLabel.setFont(new Font("Determination Mono", Font.PLAIN, 15));
      textBalanceLabel.setForeground(Color.WHITE);
      
      okButton.setBounds(175,530,150,20);
      okButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               getFrame().setVisible(false);
            }
         }
         );
      
      panel.add(okButton);
      panel.add(textKeyLabel);
      panel.add(textTreasureLabel);
      panel.add(textBalanceLabel);
      panel.add(imageLabel);
      panel.setLayout(null);
      frame.setSize(500,598);
      frame.setLocationRelativeTo(null);
      frame.setBackground(Color.BLACK);
      frame.add(panel);
   }
   public void setVisible(JFrame previousFrame)
   {
      textKeyLabel.setText("You have "+player.getKeyAmount()+" SOUL's");
      textTreasureLabel.setText("You have "+player.getTreasureAmount()+" Moldy Spaghetti Bowls");
      textBalanceLabel.setText("Your account balance is $"+player.getAccountBalance());
      frame.setVisible(true);
   }
}
class Player
{
   int treasures = 0, souls = 0;
   double accountBalance = 1203.67;
   
   public void addTreasureToInventory()
   {
      treasures++;
   }
   public void removeTreasureFromInventory()
   {
      treasures--;
   }
   public void addKeyToInventory()
   {
      souls ++;
   }
   public void setAccountBalance(double amount)
   {
      accountBalance = amount;
   }
   public boolean feedMonster()
   {
      boolean indicator = false;
      if (getTreasureAmount()-1>=0)
      {
         removeTreasureFromInventory();
         indicator = true;
      }
      return indicator;
   }
   public boolean bribeMonster(double bribe)
   { 
      boolean indicator = false;
      if(getAccountBalance()-bribe >= 0)
      {
         setAccountBalance(getAccountBalance()-bribe);
         indicator = true;
      }
      return indicator;
   }
   public double getAccountBalance()
   {
      return accountBalance;
   }
   public int getTreasureAmount()
   {
      return treasures;
   }
   public int getKeyAmount()
   {
      return souls;
   }
}
