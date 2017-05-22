import java.util.*;
import java.awt.event.*;
import javax.swing.*;
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
      Location doorLocation, monsterLocation, treasureLocation, keyLocation, inventoryLocation, miscLocation;
      doorLocation = validateLocation(doorLocationList,x,y);
      treasureLocation = validateLocation(treasureLocationList,x,y);
      monsterLocation = validateLocation(monsterLocationList,x,y);
      keyLocation = validateLocation(keyLocationList,x,y);
      inventoryLocation = validateLocation(inventoryLocationList,x,y);
      miscLocation = validateLocation(miscLocationList,x,y);
      
      if (doorLocation.validate() != 0)
      {
         moveToRoom(doorLocation.getFrame());
      }
      else if(miscLocation.validate() != 0)
      {
         moveToRoom(miscLocation.getFrame());
      }
      else if (treasureLocation.validate() != 0)
      {
         treasureLocationList.remove(treasureLocationList.indexOf(treasureLocation));
         moveToRoom(treasureLocation.getFrame());
      }
      else if (monsterLocation.validate() != 0)
      {
         monsterLocationList.remove(monsterLocationList.indexOf(monsterLocation));
         moveToRoom(monsterLocation.getFrame());
      }
      else if (keyLocation.validate() != 0)
      {
         keyLocationList.remove(keyLocationList.indexOf(keyLocation));
         moveToRoom(keyLocation.getFrame());
      }
      else if (inventoryLocation.validate() != 0)
      {
         moveToRoom(inventoryLocation.getFrame());
         inventoryLocation.getFrame().setCurrentFrame(currentFrame);
      }
      else
      {
         //counter ++;
         moveToRoom(new MiscFrame("Nothing here!"));
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