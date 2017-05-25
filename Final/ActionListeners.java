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
   		File Name			:  	ActionListeners
         
****************************************************************
                  Methods List
     mouseClicked()
     reset()
     addMiscLocation()
     addDoorLocation()
     addMonsterLocation
     addTreasureLocation
     addKeyLocation
     setFinalDoorLocation
     setEntranceDoorLocation
     moveToRoom
     validateLocation
     

***************************************************************/
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*; //Audioclip, Applet
import java.net.URL;
class MouseListener extends MouseAdapter
{
   GameFrame currentFrame;
   Game game;
   ArrayList<Location> doorLocationList = new ArrayList<Location>();
   ArrayList<Location> treasureLocationList = new ArrayList<Location>();
   ArrayList<Location> monsterLocationList =  new ArrayList<Location>();
   ArrayList<Location> keyLocationList = new ArrayList<Location>();
   ArrayList<Location> inventoryLocationList = new ArrayList<Location>();
   ArrayList<Location> miscLocationList = new ArrayList<Location>();
   ArrayList<Location> finalLocationList = new ArrayList<Location>();
   ArrayList<Location> entranceLocationList = new ArrayList<Location>();
   URL url = MouseListener.class.getResource("audioDoor.wav");
   AudioClip doorClip = Applet.newAudioClip(url);
   URL url2 = MouseListener.class.getResource("audioMonster.wav");
   AudioClip monsterClip = Applet.newAudioClip(url2);
   URL url3 = MouseListener.class.getResource("audioItem.wav");
   AudioClip itemClip = Applet.newAudioClip(url3);
   MouseListener(SceneFrame frame, InventoryFrame inventory, Game game)
   {
      this.game = game;
      currentFrame = frame;
      inventoryLocationList.add(new Location(700,498,800,598,inventory));
   }
   public void mouseClicked(MouseEvent e)
   {
      int x,y;
      x = e.getX();
      y = e.getY();
      Location doorLocation, monsterLocation, treasureLocation, keyLocation, inventoryLocation, miscLocation, finalDoorLocation, entranceDoorLocation;
      doorLocation = validateLocation(doorLocationList,x,y);
      treasureLocation = validateLocation(treasureLocationList,x,y);
      monsterLocation = validateLocation(monsterLocationList,x,y);
      keyLocation = validateLocation(keyLocationList,x,y);
      inventoryLocation = validateLocation(inventoryLocationList,x,y);
      miscLocation = validateLocation(miscLocationList,x,y);
      entranceDoorLocation = validateLocation(entranceLocationList,x,y);
      finalDoorLocation = validateLocation(finalLocationList,x,y);
      
      if (doorLocation.validate() != 0)
      {
         
         doorClip.play();
         moveToRoom(doorLocation.getFrame());
      }
      else if (keyLocation.validate() != 0)
      {
         itemClip.play();
         keyLocationList.remove(keyLocationList.indexOf(keyLocation));
         moveToRoom(keyLocation.getFrame());
      }
      else if (treasureLocation.validate() != 0)
      {
         itemClip.play();
         treasureLocationList.remove(treasureLocationList.indexOf(treasureLocation));
         moveToRoom(treasureLocation.getFrame());
      }
      else if (monsterLocation.validate() != 0)
      {
         monsterClip.play();
         monsterLocationList.remove(monsterLocationList.indexOf(monsterLocation));
         moveToRoom(monsterLocation.getFrame());
      }
      else if(miscLocation.validate() != 0)
      {
         moveToRoom(miscLocation.getFrame());
      }
      
      else if (inventoryLocation.validate() != 0)
      {
         moveToRoom(inventoryLocation.getFrame());
         inventoryLocation.getFrame().setCurrentFrame(currentFrame);
      }
      else if (finalDoorLocation.validate() != 0)
      {
         if(game.getKeyAmount()>=1)
         {
            URL url = MouseListener.class.getResource("audioEscape.wav");
            AudioClip clip = Applet.newAudioClip(url);
            
            moveToRoom(new MiscFrame("FREEDOM!"));
            game.setEscape(true);
            game.setAccountBalance(game.getAccountBalance()+100);
            moveToRoom(finalDoorLocation.getFrame());
            clip.play();
         }
         else
         {
            moveToRoom(new MiscFrame("You need a key to ESCAPE Dummy"));
         }
      }
      else if (entranceDoorLocation.validate() != 0)
      {
         double balance = game.getAccountBalance();
         
         if(balance-25>=0)
         {
            doorClip.play();
            game.setAccountBalance(balance-25);
            moveToRoom(new MiscFrame("Welcome "+game.getName()+"! (Steals $25 from your pocket)"));
            moveToRoom(entranceDoorLocation.getFrame());
         }
         else
         {
            moveToRoom(new MiscFrame("Less than $25?! Your not even worth the effort"));
            double deposit = Double.parseDouble(JOptionPane.showInputDialog(null,"Deposit money to play"));
            game.setAccountBalance(game.getAccountBalance()+deposit);
            // currentFrame.getFrame().setVisible(false);
//             game.interfaceFrame.setVisible(true);
         }
         
      }
      else
      {
         String[] messages = {"Nothing here!","Are you even trying?","I think you found something! Lol wait nope","Try looking in the source code","The way out? Im just a cat, figure it out",};
         moveToRoom(new MiscFrame(messages[new Random().nextInt(messages.length)]));
      }
      game.playerClick();
   }
   public void reset()
   {
      miscLocationList.clear();
      monsterLocationList.clear();
      keyLocationList.clear();
      treasureLocationList.clear();
      doorLocationList.clear();
   }
   public void addMiscLocation(int x1, int y1, int x2, int y2, GameFrame frame)
   {
      miscLocationList.add(new Location(x1,y1,x2,y2,frame));
   }
   public void addDoorLocation(int x1, int y1, int x2, int y2, GameFrame frame)
   {
      doorLocationList.add(new Location(x1,y1,x2,y2,frame));
   }
   public void addMonsterLocation(int x1, int y1, int x2, int y2, GameFrame frame)
   {
      monsterLocationList.add(new Location(x1,y1,x2,y2,frame));
   }
   public void addTreasureLocation(int x1, int y1, int x2, int y2, GameFrame frame)
   {
      treasureLocationList.add(new Location(x1,y1,x2,y2,frame));
   }
   public void addKeyLocation(int x1, int y1, int x2, int y2, GameFrame frame)
   {
      keyLocationList.add(new Location(x1,y1,x2,y2,frame));
   }
   public void setFinalDoorLocation(int x1, int y1, int x2, int y2, GameFrame frame)
   {
      finalLocationList.add( new Location(x1,y1,x2,y2,frame));
   }
   public void setEntranceDoorLocation(int x1, int y1, int x2, int y2, GameFrame frame)
   {
      entranceLocationList.add(new Location(x1,y1,x2,y2, frame));
   }
   public void moveToRoom(GameFrame newFrame)
   {
      newFrame.setVisible(currentFrame.getFrame());
   }
   public Location validateLocation(ArrayList<Location> locationList,int column, int row)
   {
      Location location = new Location();
      for(int x =0; x<locationList.size(); x++)
      {
         location = locationList.get(x);
         if ((column > location.getColumn1())&& (column < location.getColumn2())&&
            (row > location.getRow1()) && (row < location.getRow2()))
         {
            break;
         }
         location = new Location();
      }
      return location;
   }

}