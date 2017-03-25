import javax.swing.*; //JFrame
import java.net.URL;
import java.applet.*;//AudioClip, Applet
public class Roberto_P_1
{
   Interface objectInterface =  new Interface();
   public static void main (String[] args)
   {
      Roberto_P_1 objectMain = new Roberto_P_1();
      JFrame frameMain = new JFrame();
      
      //Set frameMain properties
      frameMain.setSize(1000,720);
      //frameMain.setIconImage(frameIcon.getImage());
      frameMain.setLocationRelativeTo(null);
      frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //Run Game using the previusly created JFrame
      objectMain.runGame(frameMain);

   }
   public void runGame(JFrame frame)
   {
      AudioClip audioMain;
      URL urlMain = Roberto_P_1.class.getResource("audioMain.wav");
      audioMain = Applet.newAudioClip(urlMain);
      Player objectPlayer = new Player();
      GameParameters gameParameters = new GameParameters();
      
      audioMain.loop();
      objectPlayer.setName(displayWelcomeProtocols(frame));
      startRegistration(objectPlayer.getName(),objectPlayer);
      displayExtraTreasureFrame(objectPlayer.getAlias(),frame,gameParameters);
      displayExtraCreatureFrame(objectPlayer.getAlias(),frame,gameParameters);
      displayExtraKeyFrame(objectPlayer.getAlias(),frame,gameParameters);
      displayExtraFeatures(frame,objectPlayer.getAlias(),gameParameters.getTreasureAmount(),gameParameters.getMonsterAmount(),gameParameters.getKeyAmount());
      displayExtraFeatureCost(frame,objectPlayer.getAlias(),calcExtraFeaturesCost(gameParameters),gameParameters);
      //objectInterface.runGame(frame);
      
   }
   public String displayWelcomeProtocols(JFrame frame)
   {
      String name = "";
      int flag = 1;
      objectInterface.displayWelcomeFrame(frame);
      while (flag != 0)
      {
         name = objectInterface.getUserName();
         flag = objectInterface.displayUserName(name);
      }
      objectInterface.displayInformation(name); 
      return name;
   }
   public void displayInformation(String name)
   {
      objectInterface.displayInformation(name);
   }
   public void startRegistration(String name, Player player)
   {
      //objectInterface.startRegistration(name,player);
      String alias,gender,sign;
      int year;
      double balance;
      player.setAlias(getPlayerAlias(name));
      alias = player.getAlias();
      player.setGender(getPlayerGender(alias));
      gender = player.getGender();
      player.setSign(getPlayerAstroSign(alias));
      sign = player.getSign();
      player.setBirthYear(getPlayerBirthYear(alias));
      year = player.getBirthYear();
      player.setBalance(getPlayerDepositAmount(alias)); 
      balance = player.getBalance();
      displayPlayerInformation(alias,gender,sign,year,balance);
   }
   public String getPlayerAlias(String name)
   {
      return objectInterface.getPlayerAlias(name);
   }
   public String getPlayerGender(String alias)
   {
      return objectInterface.getPlayerGender(alias);
   }
   public String getPlayerAstroSign(String alias)
   {
      return objectInterface.getPlayerAstroSign(alias);
   }
   public int getPlayerBirthYear(String alias)
   {
      return objectInterface.getPlayerBirthYear(alias);
   }
   public double getPlayerDepositAmount(String alias)
   {
      return objectInterface.getPlayerDepositAmount(alias);
   }
   public void displayPlayerInformation(String alias, String gender, String sign, int year, double amount)
   {
      objectInterface.displayPlayerInformation(alias,gender,sign,year,amount);
   }
   public void displayExtraTreasureFrame(String alias, JFrame frame, GameParameters game)
   {
      objectInterface.displayExtraTreasureFrame(alias,frame,game);      
   }
   public void displayExtraCreatureFrame(String alias, JFrame frame, GameParameters game)
   {
      objectInterface.displayExtraCreatureFrame(alias,frame,game);
   }
   public void displayExtraKeyFrame(String alias, JFrame frame, GameParameters game)
   {
      objectInterface.displayExtraKeyFrame(alias,frame,game);
   }
   public void displayExtraFeatures(JFrame frame, String alias, int treasure, int creatures, int keys)
   {
      objectInterface.displayExtraFeatures(frame,alias,treasure,creatures,keys);
   }
   public double calcExtraFeaturesCost(GameParameters game)
   {
      return objectInterface.calcExtraFeaturesCost(game);
   }
   public void displayExtraFeatureCost(JFrame frame, String alias, double cost,GameParameters game)
   {
      objectInterface.displayExtraFeatureCost(frame, alias, cost, game);
   }
}
