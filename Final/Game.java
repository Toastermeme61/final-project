import javax.swing.*;
import java.awt.*;
import java.util.Random;
public class Game
{
   double initialBalance;
   boolean escape = false;
   int clicks = 0;
   SceneFrame entryScene, indoor1Scene, indoor2Scene, indoor3Scene, indoor4Scene, indoor5Scene, indoor6Scene, indoor7Scene, indoor8Scene, indoor9Scene;
   MouseListener entryListener, indoor1Listener, indoor2Listener, indoor3Listener, indoor4Listener, indoor5Listener, indoor6Listener, indoor7Listener, indoor8Listener, indoor9Listener;
   MonsterFrame floweyFrame, blindDogFrame, papyrusFrame, sansFrame, asgoreFrame, undyneFrame;
   TreasureFrame treasureFrame;
   KeyFrame keyFrame;
   JFrame interfaceFrame;
   InventoryFrame inventory;
   ExitGameFrame finalFrame;
   GameFrame startingFrame;
   Player player;
   History gameHistory;
   GameParameters gameParameters;
   Game(JFrame frame, Player player, History gameHistory, GameParameters gameParameters)
   {
      this.player = player;
      interfaceFrame = frame;
      inventory = new InventoryFrame(player, interfaceFrame, gameHistory);
      finalFrame = new ExitGameFrame(interfaceFrame, player, gameHistory);
      this.gameHistory = gameHistory;
      initialBalance = player.getAccountBalance();
      this.gameParameters = gameParameters;
      startingFrame = setup();
   }
   public void playerClick()
   {
      clicks++;
   }
   public int getClicks()
   {
      return clicks;
   }
   public int getKeyAmount()
   {
      return player.getKeyAmount();
   }
   public boolean validateEscape()
   {
      return escape;
   }
   public void setEscape(boolean escape)
   {
      this.escape = escape;
   }
   public void play()
   {
      startingFrame.setVisible(interfaceFrame);
   }
   public void addKeyAtRandom(int keys)
   {
      for(int x =0; x<keys;x++)
      {
         int random = new Random().nextInt(3);
         if(random == 0)
         {
            indoor1Listener.addKeyLocation(240,215,276,252,keyFrame);
            indoor3Listener.addMiscLocation(575,464,611,492,new MiscFrame("No SOULS's here good sir, just a humble star"));
            indoor9Listener.addMiscLocation(388, 446, 420, 471, new MiscFrame("No SOULS's here good sir, just a humble star"));

         }
         else if (random == 1)
         {
            indoor3Listener.addKeyLocation(575,464,611,492,keyFrame);
            indoor9Listener.addMiscLocation(388, 446, 420, 471, new MiscFrame("No SOULS's here good sir, just a humble star"));
            indoor1Listener.addMiscLocation(240,215,276,252,new MiscFrame("No SOULS's here good sir, just a humble star"));

         }
         else
         {
            indoor9Listener.addKeyLocation(388, 446, 420, 471, keyFrame);
            indoor3Listener.addMiscLocation(575,464,611,492,new MiscFrame("No SOULS's here good sir, just a humble star"));
            indoor1Listener.addMiscLocation(240,215,276,252,new MiscFrame("No SOULS's here good sir, just a humble star"));
         }
      }
   }
   public void reset()
   {
      entryListener.reset(); 
      entryListener.addMiscLocation(358,300,408,383, new MiscFrame("Thats you dummy!"));
      entryListener.addMonsterLocation(301,295,450,405,floweyFrame);
      entryListener.addDoorLocation(669,415,793,503,indoor1Scene);
      
      indoor1Listener.reset();
      indoor1Listener.addMiscLocation(202,66,316,141, new MiscFrame("Its a window..."));
      indoor1Listener.addMiscLocation(472,66,588,141, new MiscFrame("OMG! It's just another window..."));
      indoor1Listener.addMiscLocation(353,31,437,70,  new MiscFrame("Important looking writing. If only you could read..."));
      indoor1Listener.addTreasureLocation(295, 362, 502, 595, treasureFrame);
      indoor1Listener.addDoorLocation(362,83,428,177,indoor2Scene);
      
      indoor2Listener.reset();
      indoor2Listener.addMiscLocation(344,397,397,467, new MiscFrame("You again!"));
      indoor2Listener.addTreasureLocation(162,252,305,348,treasureFrame);
      indoor2Listener.addDoorLocation(726,409,800,510,indoor3Scene);
      indoor2Listener.addDoorLocation(25,159,157,457,indoor1Scene);
      indoor2Listener.addMonsterLocation(340,8,789,387,sansFrame);
      
      indoor3Listener.reset();
      indoor3Listener.addMiscLocation(14,205,160,264, new MiscFrame("A snow dog!"));
      indoor3Listener.addMiscLocation(403,434,531,486, new MiscFrame("Another snow dog"));
      indoor3Listener.addMiscLocation(660,195,770,264, new MiscFrame("A deformed snow dog?"));
      indoor3Listener.addMiscLocation(667,446,781,515, new MiscFrame("Oh look...another snow dog..."));
      indoor3Listener.addMiscLocation(374,205,431,280, new MiscFrame("You should know thats you by now"));
      indoor3Listener.addMonsterLocation(204,9,368,350,blindDogFrame);
      indoor3Listener.addDoorLocation(668,322,793,417,indoor4Scene);
      
      indoor4Listener.reset();
      indoor4Listener.addMiscLocation(155,155,612,263, new MiscFrame("Welcome to Snowdin!"));
      indoor4Listener.addMiscLocation(373,272,429,365, new MiscFrame("Its you! Again..."));
      indoor4Listener.addTreasureLocation(621, 203, 668, 267, treasureFrame);
      indoor4Listener.addDoorLocation(5,251,88,383,indoor3Scene);
      indoor4Listener.addDoorLocation(725,272,800,407,indoor5Scene);
      
      indoor5Listener.reset();
      indoor5Listener.addMiscLocation(0,456,339,597, new MiscFrame("A bunch of harmless trees"));
      indoor5Listener.addMiscLocation(383,308,427,376, new MiscFrame("This is getting old..."));
      indoor5Listener.addDoorLocation(0,308,108,450, indoor4Scene);
      indoor5Listener.addDoorLocation(697,302,802,450, indoor6Scene);
      indoor5Listener.addMonsterLocation(32,156,168,298, papyrusFrame);
      
      indoor6Listener.reset();
      indoor6Listener.addMiscLocation(358,162,447,186, new MiscFrame("A nice umbrella for a nice statue"));
      indoor6Listener.addMiscLocation(393,314,446,383, new MiscFrame("You know who that is"));
      indoor6Listener.addDoorLocation(0,303,93,404, indoor5Scene);
      indoor6Listener.addDoorLocation(714,303,800,401,indoor7Scene);
      indoor6Listener.addTreasureLocation(360,190,442,283, treasureFrame);
      
      indoor7Listener.reset();
      indoor7Listener.addMiscLocation(299,241,549,326, new MiscFrame("How much property tax do you pay for a castle?"));
      indoor7Listener.addMiscLocation(348,192,490,240, new MiscFrame("Maybe their renting it on Zillow?"));
      indoor7Listener.addMiscLocation(401,130,442,191, new MiscFrame("Looks like a nice studio apartment"));
      indoor7Listener.addMiscLocation(371,417,430,484, new MiscFrame("Please stop clicking yourself in public..."));
      indoor7Listener.addDoorLocation(0,349,106,489, indoor6Scene);
      indoor7Listener.addDoorLocation(466,351,649,491, indoor8Scene);
      indoor7Listener.addMonsterLocation(652,217,800,494, undyneFrame);
      
      indoor8Listener.reset();
      indoor8Listener.addMiscLocation(0,58,800,394, new MiscFrame("So far, yet so close. (Is that how it goes?)"));
      indoor8Listener.addDoorLocation(0,403,123,526, indoor7Scene);
      indoor8Listener.addDoorLocation(685,404,800,497, indoor9Scene);
      
      indoor9Listener.reset();
      indoor9Listener.addMiscLocation(157,136,301,228, new MiscFrame("A window! (Deja vu?)"));
      indoor9Listener.addMiscLocation(504,136,650,228, new MiscFrame("Yet again, another window! (Have we seen this before?)"));
      indoor9Listener.addMiscLocation(355,85,452,131, new MiscFrame("Looks interesting, too bad you're illiterate"));
      indoor9Listener.setFinalDoorLocation(355,145,453,281, finalFrame);
      indoor9Listener.addDoorLocation(325, 498, 475, 598, indoor8Scene);
      
      if(gameParameters.validateExtraKey())
         addKeyAtRandom(2);
      else
         addKeyAtRandom(1);
      
      
      player.setTreasureAmount(0);
      player.setKeyAmount(0);
      //player.setAccountBalance(initialBalance);
      this.clicks = 0;
   }
   public GameFrame setup()
   {    
      entryScene = new SceneFrame("entryFlowerBed.png");
      indoor1Scene = new SceneFrame("indoor1TheRuins.png");
      indoor2Scene = new SceneFrame("indoor2ExitRuins.png");
      indoor3Scene = new SceneFrame("indoor3OutsideSnowdin.png");
      indoor4Scene = new SceneFrame("indoor4SnowdinTown.png");
      indoor5Scene = new SceneFrame("indoor5SnowdinExit.png");
      indoor6Scene = new SceneFrame("indoor6WaterfallStatue.png");
      indoor7Scene = new SceneFrame("indoor7WaterfallExit.png");
      indoor8Scene = new SceneFrame("indoor8NewHomeOutside.png");
      indoor9Scene = new SceneFrame("indoor9NewHomeEntrance.png");
      
      floweyFrame = setupMonsterFrame("mediaFloweyGif.gif","Flowey");
      blindDogFrame = setupMonsterFrame("mediaBlindDogGif.gif","Blind Doggo");
      papyrusFrame = setupMonsterFrame("mediaPapyrusGif.gif","Papyrus");
      sansFrame = setupMonsterFrame("mediaSansGif.gif","Sans");
      undyneFrame = setupMonsterFrame("mediaUndyneGif.gif", "Undyne");
      asgoreFrame = setupMonsterFrame("mediaTemmyGif.gif","King Asgore");
      
      treasureFrame = setupTreasureFrame("mediaSpaghetti.png", "Moldy Spaghetti Bowl");
      
      keyFrame = setupKeyFrame("mediaHeartSoulGif.gif","Human SOUL");
      
      entryListener = setupMouseListener(entryScene);
      indoor1Listener = setupMouseListener(indoor1Scene);
      indoor2Listener = setupMouseListener(indoor2Scene);
      indoor3Listener = setupMouseListener(indoor3Scene);
      indoor4Listener = setupMouseListener(indoor4Scene);
      indoor5Listener = setupMouseListener(indoor5Scene);
      indoor6Listener = setupMouseListener(indoor6Scene);
      indoor7Listener = setupMouseListener(indoor7Scene);
      indoor8Listener = setupMouseListener(indoor8Scene);
      indoor9Listener = setupMouseListener(indoor9Scene);
      
      entryScene.addMouseListener(entryListener);
      indoor1Scene.addMouseListener(indoor1Listener);
      indoor2Scene.addMouseListener(indoor2Listener);
      indoor3Scene.addMouseListener(indoor3Listener);
      indoor4Scene.addMouseListener(indoor4Listener);
      indoor5Scene.addMouseListener(indoor5Listener);
      indoor6Scene.addMouseListener(indoor6Listener);
      indoor7Scene.addMouseListener(indoor7Listener);
      indoor8Scene.addMouseListener(indoor8Listener);
      indoor9Scene.addMouseListener(indoor9Listener);
      
           
      
      return entryScene;
      
      
   }
   public MouseListener setupMouseListener(SceneFrame frame)
   {
      MouseListener listener = new MouseListener(frame, inventory,this);
      return listener;
   }
   public MonsterFrame setupMonsterFrame(String imageFileName, String monsterName)
   {
      return new MonsterFrame(imageFileName, monsterName, player, gameHistory, interfaceFrame);
   }
   public TreasureFrame setupTreasureFrame(String imageFileName, String monsterName)
   {
      return new TreasureFrame(imageFileName, monsterName, player);
   }
   public KeyFrame setupKeyFrame(String imageFileName, String monsterName)
   {
      return new KeyFrame(imageFileName, monsterName, player);
   }
}