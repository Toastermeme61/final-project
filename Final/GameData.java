/***************************************************************   
***************************************************************    
***************************************************************    
                                                         			    		   	          
                   			ID INFORMATION                         		          
                                                        			    		                      
   		Programmer			:		Cardenas Roberto                
   		Assignment #		:   	Final Escape                   	
   		Assignment Name   :	   Final Escape
   		Course # and Title:	   CISC 190 - Java    	
   		Class Meeting Time:	   TTH 1:00 – 4:05	
  		   Instructor			:	   Professor Forman 
  		   Hours			   	:	   44.5
   		Difficulty			:	   10/10			
   		Completion Date	:	   05/24/2017 	
   		File Name			:  	GameData

***************************************************************/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.NumberFormat;
import java.lang.Math;
import java.applet.*; //Audioclip, Applet
import java.net.URL;
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
   JPanel panel =  new JPanel();
   RobertoFinalEscape object = new RobertoFinalEscape();
   JFrame frame = new JFrame();
   String imageFileName;
   GameFrame(String image)
   {
      imageFileName = image;
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      panel.setBackground(Color.BLACK);
      
   }
   public JFrame getFrame()
   {
      return frame;
   }
   public void setVisible(JFrame previousFrame)
   {
   
   }
   public void setCurrentFrame(GameFrame currentFrame)
   {
      
   }
}

class SceneFrame extends GameFrame
{
   SceneFrame(String imageFileName)
   {
      super(imageFileName);
      setupFrame();
   }
   public void setupFrame()
   {
      JLabel imageLabel  = new JLabel();
      imageLabel.setIcon(new ImageIcon(imageFileName));
      
      panel.add(imageLabel);
      frame.getContentPane().removeAll();
      frame.add(panel);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
      frame  =  new JFrame();
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
   History gameHistory;
   JFrame rootFrame;
   MonsterFrame(String imageFileName, String name, Player player, History history, JFrame frame)
   {
      super(imageFileName, name, player);
      gameHistory = history;
      rootFrame = frame;
   }
   public void setupFrame()
   { 
      MiscFrame msgFrame = new MiscFrame("");
      JButton bribeButton = new JButton("Bribe!");
      JButton feedButton = new JButton("Feed!");
      JButton runButton = new JButton("Run!");
      setSubFrameDefaults("Oh no! "+objectName+" stands in your way,"+player.getAlias());
      
      object.setupButton(bribeButton, 90, 450);
      object.setupButton(feedButton, 300,450);
      object.setupButton(runButton, 90, 500);
      bribeButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               
               if (player.bribeMonster())
               {
                  
                  msgFrame.setText("Takes everything you have. Except $2.50 for the bus");
                  msgFrame.setupMAL(getFrame());
                  msgFrame.setVisible(getFrame());
                  
                  
               }
               else
               {
                  gameHistory.addLog(new Log(player));
                  msgFrame.setText("Sorry, you dont have the funds");
                  msgFrame.setupMAL(getFrame(), rootFrame);
                  msgFrame.setVisible(getFrame());
               }
            }
         }
         );
      feedButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               if(player.feedMonster())
               {
                  msgFrame.setText("Eats spaghetti and gets tomato sauce everywhere");
                  msgFrame.setupMAL(getFrame());
                  msgFrame.setVisible(getFrame());
                  
               }
               else
               {
                  gameHistory.addLog(new Log(player));
                  msgFrame.setText("You don't have any food! Liar!");
                  msgFrame.setupMAL(getFrame(), rootFrame);
                  msgFrame.setVisible(getFrame());
               }
               
            }
         }
         );
      runButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               int randomInt = new Random().nextInt(3);
               if (randomInt == 1)
               {
                  msgFrame.setText(objectName+" tried to follow but got lazy and did'nt");
                  msgFrame.setupMAL(getFrame());
                  msgFrame.setVisible(getFrame());
               }
               else
               {
                  gameHistory.addLog(new Log(player));
                  msgFrame.setText("HA! You're not getting away that easily!");
                  msgFrame.setupMAL(getFrame(),rootFrame);
                  msgFrame.setVisible(getFrame());
               }
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
      JButton okButton = new JButton("Pick up");
      setSubFrameDefaults("Nice! You just found a "+objectName+"!");
      object.setupButton(okButton,175,450);
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
      JButton okButton = new JButton("Pick up");
      setSubFrameDefaults("A "+objectName+"! You can finally open the portal home!");
      
      object.setupButton(okButton, 175, 450);
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
   JButton okButton = new JButton("Ok");
   MiscFrame(String text)
   {
      super("mediaTemmyGif.gif");
      frame  =  new JFrame();
      this.text.setText(text);
      setupFrame();
   }
   public void setupMAL(JFrame frame)
   {
      okButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {               
               getFrame().setVisible(false);
               frame.setVisible(false);
            }
         }
         );
   }
   public void setupMAL(JFrame currentFrame, JFrame rootFrame)
   {
      okButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {               
               getFrame().setVisible(false);
               currentFrame.setVisible(false);
               rootFrame.setVisible(true);
            }
         }
         );
   }
   public void setupFrame()
   {
      image.setIcon(new ImageIcon(imageFileName));
      image.setBounds(0,40,600,350);
      image.setHorizontalAlignment(JLabel.CENTER);
      image.setVerticalAlignment(JLabel.TOP);
      
      text.setBounds(0,30,600,350);
      text.setHorizontalAlignment(JLabel.CENTER);
      text.setVerticalAlignment(JLabel.CENTER);
      text.setFont(new Font ("Determination Mono",Font.BOLD,15));
      text.setForeground(Color.WHITE);
      
      object.setupButton(okButton, 225,280);
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
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
   }
   public void setVisible(JFrame previousFrame)
   {
      getFrame().setVisible(true);
   }
   public void setText(String text)
   {
      this.text.setText(text);
   }
}
class InventoryFrame extends GameFrame
{
   Player player;
   JLabel textKeyLabel = new JLabel() ;
   JLabel textTreasureLabel =  new JLabel() ;
   JLabel textBalanceLabel = new JLabel();
   JButton quitButton = new JButton("Quit Game");
   GameFrame currentFrame;
   JFrame rootFrame;
   History history;
   InventoryFrame(Player player, JFrame rootFrame, History history)
   {
      super("mediaInventory.png");
      this.rootFrame = rootFrame;
      this.player = player;
      this.history = history;
      setupFrame();
   }
   public void setCurrentFrame(GameFrame currentFrame)
   {
      this.currentFrame = currentFrame;
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
      
      object.setupButton(okButton,175,490);
      okButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               getFrame().setVisible(false);
            }
         }
         );
         
      object.setupButton(quitButton,175,530);
      quitButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               history.addLog(new Log(player));
               getFrame().setVisible(false);
               currentFrame.getFrame().setVisible(false);
               rootFrame.setVisible(true);
       
            }
         }
         );
      
      panel.add(okButton);
      panel.add(quitButton);
      panel.add(textKeyLabel);
      panel.add(textTreasureLabel);
      panel.add(textBalanceLabel);
      panel.add(imageLabel);
      panel.setLayout(null);
      panel.setBackground(Color.BLACK);
      frame.setSize(500,598);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      frame.setLocationRelativeTo(null);
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
class ExitGameFrame extends GameFrame
{
   JFrame rootFrame;
   Player player;
   History history;
   ExitGameFrame(JFrame frame, Player player, History history)
   {
      super("");
      rootFrame = frame;
      this.player = player;
      this.history = history;
      setupFrame();
   }
   public void setupFrame()
   {
      JButton menuButton = new JButton("Main Menu");
      JButton exitButton = new JButton("Exit");
      JTextArea textArea = new JTextArea();
      JLabel image = new JLabel();
      RobertoFinalEscape object = new RobertoFinalEscape();
      NumberFormat currencyFormater = NumberFormat.getCurrencyInstance();
      String text;
     
      image.setIcon(new ImageIcon(object.editImage("exitEscape.jpg",700,300)));
      image.setBounds(0,0,800,300);
      image.setHorizontalAlignment(JLabel.CENTER);
      
      object.setupButton(menuButton, 325,350 );
      menuButton.addActionListener( new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            history.addLog(new Log(player));
            getFrame().setVisible(false);
            rootFrame.setVisible(true);
            
         }
      }
      );
      object.setupButton(exitButton,325,450);
      exitButton.addActionListener( new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            object.showExitFrame(rootFrame);
         }
      }
      );
      panel.setLayout(null);
      panel.setBackground(Color.BLACK);
      panel.add(image);
      panel.add(exitButton);
      panel.add(menuButton);
      
      frame.setSize(800,598);
      frame.add(panel);
      frame.setLocationRelativeTo(null);
   }
   public void setVisible(JFrame previousFrame)
   {
      previousFrame.setVisible(false);
      frame.setVisible(true);
   }
}
class GameParameters
{
   boolean extraTreasure, extraKey, extraMonster, masterGameType;
   GameParameters()
   {
      extraTreasure = false;
      extraKey = false;
      extraMonster = false;
      masterGameType = false;
   }
   public void enableExtraMonster()
   {
      extraMonster = true;
   }
   public void enableExtraKey()
   {
      extraKey = true;
   }
   public void enableExtraTreasure()
   {
      extraTreasure = true;
   }
   public void enableMaster()
   {
      masterGameType = true;     
   }
   public boolean validateMaster()
   {
      return masterGameType;
   }
   public boolean validateExtraMonster()
   {
      return extraMonster;
   }
   public boolean validateExtraKey()
   {
      return extraKey;
   }
   public boolean validateExtraTreasure()
   {
      return extraTreasure;
   }
}
class Player
{
   int birthYear, treasures, souls;
   double accountBalance;
   String name, alias, gender, astrologicalSign;
   Game game;
   public void setGame(Game game)
   {
      this.game = game;
   }
   public int getClicks()
   {
      return game.getClicks();
   }
   public boolean validateEscape()
   {
      return game.validateEscape();
   }
   public void setName(String name)
   {
      this.name = name;
   }
   public void setAlias(String alias)
   {
      this.alias = alias;
   }
   public void setGender(String gender)
   {
      this.gender = gender;
   }
   public void setAstrologicalSign(String astrologicalSign)
   {
      this.astrologicalSign = astrologicalSign;
   }
   public void setBirthYear(int birthYear)
   {
      this.birthYear = birthYear;
   }
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
   public void setTreasureAmount(int amount)
   {
      treasures = amount;
   }
   public void setKeyAmount(int amount)
   {
      souls = amount;
   }
   public void setAccountBalance(double amount)
   {
      
      double balance = Math.round(amount*100);
      balance = balance/100.0;
      accountBalance = balance;
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
   public boolean bribeMonster()
   { 
      boolean indicator = false;
      if(getAccountBalance() > 2.5)
      {
         setAccountBalance(2.50);
         indicator = true;
      }
      return indicator;
   }
   public String getName()
   {
      return name;
   }
   public String getAlias()
   {
      return alias;
   }
   public String getGender()
   {
      return gender;
   }
   public String getAstrologicalSign()
   {
      return astrologicalSign;
   }
   public int getBirthYear()
   {
      return birthYear;
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
class Log
{
   boolean escape;
   int clicks;
   double accountBalance;
   Log(Player player)
   {
      escape = player.validateEscape();
      clicks = player.getClicks();
      accountBalance = player.getAccountBalance();
   }
   public int getClicks()
   {
      return clicks;
   }
   public boolean validateEscape()
   {
      return escape;
   }
   public double getAccountBalance()
   {
      return accountBalance;
   }
}
class History
{
   Player player;
   ArrayList<Log> logList = new ArrayList<Log>();
   double initialBalance;
   int wins, losses;
   String name;
   History(Player player)
   {
      this.player = player;
      name = player.getName();
      initialBalance = player.getAccountBalance();
      
   }
   public String getGameLogsAsString()
   {
      String logs = "";
      NumberFormat currencyFormater = NumberFormat.getCurrencyInstance();
      for(int x = 0; x< logList.size(); x++)
      {
         Log log = logList.get(x);
         logs += "Game #"+(x+1)+" ended with "+name+" "
         +escapeOrNot(log.validateEscape())+" after "+log.getClicks()
         +" clicks - now has "+currencyFormater.format(log.getAccountBalance())+"\n";
         
         
      }
      return logs;
   }
   public String escapeOrNot(boolean escape)
   {
      String ans = ""; 
      if(escape)
         ans = "escaping";
      else
         ans = "not escaping";
      return ans;
   }
   public double getInitialBalance()
   {
      return initialBalance;
   }
   public int getWins()
   {
      return wins;
   }
   public int getLosses()
   {
      return losses;
   }
   public String getName()
   {
      return name;
   }
   public Log getLog(int index)
   {
      return logList.get(index);
   }
   public void update()
   {
      wins = calculateWins();
      losses = logList.size()-wins;
   }
   public void addLog(Log log)
   {
      logList.add(log);
      update();
   }
   public int calculateWins()
   {
      int wins = 0;
      for(int x=0; x<logList.size(); x++)
      {
         if(logList.get(x).validateEscape())
            wins++;
      }
      return wins;
   }
}
