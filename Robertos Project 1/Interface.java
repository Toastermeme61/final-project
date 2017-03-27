import javax.swing.*; //JPanel, JFrame, JOptionPane, JLabel, UIManager, ImageIcon, Image
import java.applet.*; //Audioclip, Applet
import java.net.URL;
import java.util.*;//Random, ArrayList
import java.awt.*; //Font, Color, Graphics
import java.text.NumberFormat;

class Interface extends RobertosSwinging
{
   public static void main(String[] args)
   {
      Interface object = new Interface();
      JFrame frameMain = new JFrame();
      
      //Set frameMain properties
      frameMain.setSize(1000,720);
      //frameMain.setIconImage(frameIcon.getImage());
      frameMain.setLocationRelativeTo(null);
      frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      object.runGame(frameMain);
   }
   public void runGame(JFrame frame)
   {
      AudioClip audioMain;
      //String strPlayerName, strPlayerAlias;
      URL urlMain = Interface.class.getResource("audioMain.wav");
      audioMain = Applet.newAudioClip(urlMain);
      Player player = new Player();
      GameParameters game = new GameParameters();
      audioMain.loop();
      player.setName(displayWelcomeProtocols(frame));
      startRegistration(player.getName(),player);
      displayExtraTreasureFrame(player.getAlias(),frame,game);
      displayExtraCreatureFrame(player.getAlias(),frame,game);
      displayExtraKeyFrame(player.getAlias(),frame,game);
      displayExtraFeatures(frame,player.getAlias(),game.getTreasureAmount(),game.getMonsterAmount(),game.getKeyAmount());
      displayExtraFeatureCost(frame,player.getAlias(),calcExtraFeaturesCost(game),game);
 
      //displayRegistrationFee(player,game);    
      
   }
   public String displayWelcomeProtocols( JFrame frame)
   {
      String name = "";
      int flag = 1;
      displayWelcomeFrame(frame);
      while (flag != 0)
      {
         name = getUserName();
         flag = displayUserName(name);
      }
      displayInformation(name); 
      return name;
   }
   public void displayInformation(String name)
   {
      /////////////////////////////////////////////////////////////////////////////////////////////

      //Local variable declarations and definitions

      ////////////////////////////////////////////////////////////////////////////////////////////
      String space = "";
      
      for (int x = 0; x < name.length(); x++)
         space += " ";
         
      String strPurpose = "                                                   "
      +"We play as a human child who has fallen into the unde"
      +"rground, the place where all monsters live. We are trying to find our way back to "
      +" the surface world. In order to get there, we will have to brush up"
      +" on our social skills and befriend, date, outsmart, or bribe every monster we encounter" ;
      
      String strFees = "                                             "
                      +"$2.50 for a lesser doge( ages under 4)       "
                      +"$5.00 for a greater doge( ages 4-12)         "
                      +"$7.50 for an angsty skeleton( ages 13-17)    "
                      +"$9.75 for a lazy bones( ages 18 and above)   "
                      +"$1.25 for each additional feature( item,     "
                      +"monster, extra soul)";
                      
      
      String strProceed = "                                              " + space
                         +"Come on "+name+"! We gotta get you registered."
                         +"                                              " + space
                         +"Press ENTER to continue";
      
                         
      //////////////////////////////////////////////////////////////////////////////////////////////
      
      //Display Purpose
      JOptionPane.showMessageDialog(null,editText("PURPOSE",strPurpose,18),"Purpose",JOptionPane.PLAIN_MESSAGE);
      audioPressOK.play();
      
      //Display Fees
      JOptionPane.showMessageDialog(null,editText("FEES",strFees,CENTER,18,46),"Fees",JOptionPane.PLAIN_MESSAGE);
      audioPressOK.play();
      
      //Display Continue to registrations
      JOptionPane.showMessageDialog(null,editText("CONTINUE TO REGISTRATION", strProceed,CENTER,16,42+name.length()),"Continue",JOptionPane.PLAIN_MESSAGE);
      audioPressOK.play();

   }
   public void startRegistration(String name,Player player)
   {
      String alias,gender,sign;
      int year;
      double balance;
      player.setAlias(getPlayerAlias(name));
      alias = player.getAlias();
      player.setGender(getPlayerGender(alias));
      gender = player.getGender();
      player.setZodiacSign(getPlayerAstroSign(alias));
      sign = player.getZodiacSign();
      player.setBirthYear(getPlayerBirthYear(alias));
      year = player.getBirthYear();
      player.setBalance(getPlayerDepositAmount(alias)); 
      balance = player.getBalance();
      displayPlayerInformation(alias,gender,sign,year,balance);
      
   }
   public String getPlayerAlias(String name)
   {
      String alias, text;
      Random randGenerator = new Random();
      String[] goofyNickNames = {"Poopy McPoopyFace", "Baron VonFart", "Vlad the Inhaler", 
      "President Cheeto", "XX_CringeMaster_XX","Mr. Pink","Dinkleberg","Alaska Young",
      "babezzz4dayzzzz","El_Peje_Es_Mi_Pastor","javasuxxx","KawaiPandax12"};
      
      text = "Make up a nickname for yourself "+name
            +", or I will make one up for you... (For example: Baron VonFart)";
      alias = JOptionPane.showInputDialog(null,editText(text,18),
      "Input Alias",JOptionPane.PLAIN_MESSAGE,null,null,goofyNickNames[randGenerator.nextInt(goofyNickNames.length)]).toString();
      audioPressOK.play();
      return alias;
   }
   public String getPlayerGender(String alias)
   {
      String gender,text;
      text = "So are you a 'Boy' or a 'Girl' "+alias+"? Its really hard to tell";
                   
      gender = JOptionPane.showInputDialog(null,editText(text,18),
               "Input Gender",JOptionPane.PLAIN_MESSAGE,null,null,"Boy").toString();
      audioPressOK.play();
      return gender;
   }
   public String getPlayerAstroSign(String alias)
   {
      int indicator;
      String sign, text;
      String[] zodiacSigns = {"Aquarius : Jan 20/Feb 18","Pisces : Feb 19/March 20","Aries : March 21/April 19",
      "Taurus : April 20/May 20", "Gemini : May 21/June 20", "Cancer : June 21/July 22","Leo : July 23/ August 22",
      "Virgo : August 23/Sep 22","Libra : Sep 23/Oct 22","Scorpio : Oct 23/Nov 21","Sagitarius Nov 22/Dec 21",
      "Capricorn : Dec 22/Jan 19"};
      text = "So "+alias + ", what is your zodiac sign?";
      sign = JOptionPane.showInputDialog(null,editText(text,18),
             "Input Astrological Sign",JOptionPane.PLAIN_MESSAGE,null,zodiacSigns,zodiacSigns[0]).toString();
      indicator = sign.indexOf(' ');
      sign = sign.substring(0,indicator);
      audioPressOK.play();
      return sign;
   }
   public int getPlayerBirthYear(String alias)
   {
      int year;
      String text,strYear;
      text = "Tell me what year you were born in "+alias+"... Why? BECAUSE I SAY SO, THATS WHY!";
      strYear = JOptionPane.showInputDialog(null,editText(text,18),
               "Input Birthyear",JOptionPane.PLAIN_MESSAGE,null,null,"1997").toString();
      year = Integer.parseInt(strYear);
      audioPressOK.play();
      return year;
   }
   public double getPlayerDepositAmount(String alias)
   {
      
      double money;
      String text, strMoney;
      text = "How much dough are you depositing to your account "+alias+"?";
      strMoney =  JOptionPane.showInputDialog(null,editText(text,18),
                  "Input Cash Amount",JOptionPane.PLAIN_MESSAGE,null,null,"1234.567").toString();
      money = Double.parseDouble(strMoney);
      money = robertosRoundToPenny(money);
      audioPressOK.play();
      return money;
   }
   public void displayPlayerInformation(String alias, String gender, String sign, int year, double amount)
   {
      NumberFormat currencyFormater = NumberFormat.getCurrencyInstance();
      String text = "So "+alias+", you're a "+gender+" and a "+sign+" born in "+year+"? I never would have guessed, "
      +"I'm a transgender Capricorn myself. Cool! Looks like your deposit for "+currencyFormater.format(amount)+" went through! ";
      JOptionPane.showMessageDialog(null,editText(text,18),"Confirm Player Information",JOptionPane.PLAIN_MESSAGE);
      audioPressOK.play();
   }
   public void displayExtraTreasureFrame(String alias, JFrame frame, GameParameters game)
   {
      JPanel panel = new JPanel();
      
      JLabel labelExtraTreasure1 = new JLabel("Its a bowl of spaguetti with marinara sauce.");
      JLabel labelExtraTreasure2 = new JLabel("Will you take it " +alias+ "? ");
      JLabel labelSpaghetti = new JLabel();

      //Set labelExtraTreasure1 properties
      labelExtraTreasure1.setForeground(Color.WHITE);
      labelExtraTreasure1.setFont(new Font("Determination Mono",Font.BOLD,35));
      labelExtraTreasure1.setBounds(0,30,1000,200);
      labelExtraTreasure1.setHorizontalAlignment(JLabel.CENTER);
      labelExtraTreasure1.setVerticalAlignment(JLabel.TOP);
      
      //Set labelExtraTreasure2 properties
      labelExtraTreasure2.setForeground(Color.WHITE);
      labelExtraTreasure2.setFont(new Font("Determination Mono",Font.BOLD,35));
      labelExtraTreasure2.setBounds(0,0,1000,200);
      labelExtraTreasure2.setHorizontalAlignment(JLabel.CENTER);
     
      
      //Set labelSpaghetti properties
      labelSpaghetti.setIcon(new ImageIcon(editImage("mediaSpaghetti.png",550,350)));
      labelSpaghetti.setBounds(0,0,1000,550);
      labelSpaghetti.setHorizontalAlignment(JLabel.CENTER);
      
      
      
      
      //Add components to panel
      
      panel.setLayout(null);
      panel.add(labelExtraTreasure1);
      panel.add(labelExtraTreasure2);
      panel.add(labelSpaghetti);
      
      
      //Clean up JFrame, add new panel and set visible
      frame.getContentPane().removeAll();
      frame.setTitle("Extra Features: Treasure");
      
      frame.add(panel);
      frame.setVisible(true);
      
      showMsgGameDialog(frame,"It's old and moldy but you'll probably eat it anyway. Wait. Is that a maggot squirming next to a meatball? On the brightside its only $1.25 per extra bowl...","UNDERTALE");
      game.setTreasureAmount(Integer.parseInt(showInputGameDialog(frame,"How many extra moldy spaghetti bowls would you like? They're only $1.25 each!","UNDERTALE","0")));
   }
   public void displayExtraCreatureFrame(String alias, JFrame frame, GameParameters game)
   {
      JPanel panel = new JPanel();
      
      JLabel labelExtra1 = new JLabel("A group of monsters aproaches to meet you...");
      JLabel labelExtra2 = new JLabel("Will you say hi " +alias+ "? ");
      JLabel labelImage = new JLabel();

      //Set labelExtraTreasure1 properties
      labelExtra1.setForeground(Color.WHITE);
      labelExtra1.setFont(new Font("Determination Mono",Font.BOLD,35));
      labelExtra1.setBounds(0,30,1000,200);
      labelExtra1.setHorizontalAlignment(JLabel.CENTER);
      labelExtra1.setVerticalAlignment(JLabel.TOP);
      
      //Set labelExtraTreasure2 properties
      labelExtra2.setForeground(Color.WHITE);
      labelExtra2.setFont(new Font("Determination Mono",Font.BOLD,30));
      labelExtra2.setBounds(0,0,1000,200);
      labelExtra2.setHorizontalAlignment(JLabel.CENTER);
     // labelExtraTreasure2.setVerticalAlignment(JLabel.TOP);
      
      //Set labelSpaghetti properties
      labelImage.setIcon(new ImageIcon(editImage("mediaMuffetGif.gif",500,350)));
      labelImage.setBounds(0,0,1000,550);
      labelImage.setHorizontalAlignment(JLabel.CENTER);
      
      
      
      
      //Add components to panel
      
      panel.setLayout(null);
      panel.add(labelExtra1);
      panel.add(labelExtra2);
      panel.add(labelImage);
      //panel.add(labelExtraTreasure3);
      
      //Clean up JFrame
      frame.getContentPane().removeAll();
      frame.setTitle("Extra Features: Creatures");
      
      frame.add(panel);
      frame.setVisible(true);
      
      showMsgGameDialog(frame,"A few other monsters heard you were coming and wanted to know if they could join the party...","UNDERTALE");
      game.setMonsterAmount(Integer.parseInt(showInputGameDialog(frame,"How many extra potential friends (or enemies) would you like stalking you? It's $1.25 per monster!","UNDERTALE","0")));
   }
   public void displayExtraKeyFrame(String alias, JFrame frame, GameParameters game)
   {
      JPanel panel = new JPanel();
      
      JLabel labelExtra1 = new JLabel("You see a small beating heart in the distance");
      JLabel labelExtra2 = new JLabel(alias+", you are filled with DETERMINATION!!!");
      JLabel labelImage = new JLabel();

      //Set labelExtraTreasure1 properties
      labelExtra1.setForeground(Color.WHITE);
      labelExtra1.setFont(new Font("Determination Mono",Font.BOLD,32));
      labelExtra1.setBounds(0,30,1000,200);
      labelExtra1.setHorizontalAlignment(JLabel.CENTER);
      labelExtra1.setVerticalAlignment(JLabel.TOP);
      
      //Set labelExtraTreasure2 properties
      labelExtra2.setForeground(Color.WHITE);
      labelExtra2.setFont(new Font("Determination Mono",Font.BOLD,25));
      labelExtra2.setBounds(0,0,1000,200);
      labelExtra2.setHorizontalAlignment(JLabel.CENTER);
     
      
      //Set labelSpaghetti properties
      labelImage.setIcon(new ImageIcon(editImage("mediaHeartSoulGif.gif",300,300)));
      labelImage.setBounds(0,0,1000,580);
      labelImage.setHorizontalAlignment(JLabel.CENTER);
      
      
      //Add components to panel
      
      panel.setLayout(null);
      panel.add(labelExtra1);
      panel.add(labelExtra2);
      panel.add(labelImage);
      
      //Clean up JFrame
      frame.getContentPane().removeAll();
      frame.setTitle("Extra Features: Key");
      frame.add(panel);
      frame.setVisible(true);
      showMsgGameDialog(frame,"That beating heart is a human SOUL, you need to find one in order to open the portal back home...","UNDERTALE");
      game.setKeyAmount(Integer.parseInt(showInputGameDialog(frame,"How many extra SOULS will you need to make your journey easier? ($1.25 per extra SOUL)","UNDERTALE","0")));
   }
   public void displayExtraFeatures(JFrame frame, String alias, int treasures, int creatures, int keys)
   {
      
      String text = "So "+alias+", you've decided to buy "+treasures+" extra bowl(s) of moldy spaghetti, invite " 
      +creatures+" other monster(s) to join you on your quest, and have "+keys+" extra SOUL(S) for you to find";
      showMsgGameDialog(frame, text, "UNDERTALE");
   }
   public double calcExtraFeaturesCost(GameParameters game)
   {
      final double price = 1.25;
      double ans;
      ans = game.getTreasureAmount()*price + game.getMonsterAmount()*price + game.getKeyAmount()*price;
      return ans;
   }
   public void displayExtraFeatureCost(JFrame frame, String alias, double cost, GameParameters game)
   {
      NumberFormat currencyFormater = NumberFormat.getCurrencyInstance();
      int amount = game.getTreasureAmount()+game.getKeyAmount()+game.getMonsterAmount();
      String text = "Having these extra features ain't come cheap "+alias+", "
      +currencyFormater.format(cost)+" to be exact. What? You don't believe me? It's $1.2"
      +"5 per extra feature, "+amount+" times $1.25 is "+currencyFormater.format(cost)+"! Sigh...humans";
      showMsgGameDialog(frame,text,"UNDERTALE");
   }
   public int getUserAge(int year)
   {
      return 2017 - year;
   }
   public double getUserFee(int age)
   {
      //return Math.min((age-8)/5.0-2.5,9.75);
      int number;
      double ans;
      number = age-8;
      number = number/5;
      ans = number * 2.5;
      ans+= 5.0;
      ans = Math.min(ans,9.75);
      return ans;
   }
   public double robertosRoundToPenny(double amount)
   {
      amount = amount*100;
      amount = Math.round(amount);
      amount = amount/100;
      return amount;
   }
//    public void displayRegistrationFee(Player player, GameParameters game)
//    {
//       JLabel line1,line2,line3,line4,line5,line6,line7,line8,line9line10,line11;
//       
//       int extraFeatures = game.getMonsterAmount()+game.getKeyAmount()+game.getTreasureAmount();
//       double basicCost,extraFeaturesCost,subtotal, fee, total;
//       basicCost = getUserFee(getUserAge(player.getBirthYear())); 
//       extraFeaturesCost =  extraFeatures * 1.25;
//       subtotal = basicCost + extraFeaturesCost;
//       fee = robertosRoundToPenny(subtotal*0.1);
//       total = subtotal + fee;
//       line1 = new JLabel(player.getName()+", aka "+player.getAlias()+", here's your tab:");
//       line2 = new JLabel(""+basicCost+" - Basic Registration Fee - based on your age");
//       line3 = new JLabel(""+extraFeaturesCost+ " - At $1.25 per feature for "+extraFeatures+" Extra Game Features of:");
//       line4 = new JLabel(""+game.getTreasureAmount()+ " Moldy Spaghetti Bowl(s)");
//       line5 = new JLabel(""+game.getMonsterAmount()+ " Monster(s)");
//       line6 = new JLabel(""+game.getKeyAmount()+ " Key(s)");
//       line7 = new JLabel("==============");
//       line8 = new JLabel(""+subtotal+" - Subtotal");
//       line9 = new JLabel(""+fee+" - Rounded ESCAPE Service Fee of 10%");
//       line10 = new JLabel("==============");
//       line11 = new JLabel(""+total+" - Total ESCAPE Registration Fee");
//       JLabel[] lines = {line1,line2,line3,line4,line5,line6,line7,line8,line9line10,line11};
//    }
//    
   public void showMsgGameDialog(JFrame frame, String text, String title)
   {
      ArrayList<JLabel> list = new ArrayList<JLabel>();
      JPanel container = new JPanel();
      PanelPainter panel = new PanelPainter();
      cutText(text,68,list);
      setTextProperties(panel,list,16,JLabel.CENTER,660);
      panel.setLayout(null);
      container.setBounds(157,478,685,200);
      frame.add(container);
      UI.put("OptionPane.minimumSize",new Dimension(680,180));
      JOptionPane.showMessageDialog(container, panel,title, JOptionPane.PLAIN_MESSAGE);
      audioPressOK.play();   
   }
   public String showInputGameDialog(JFrame frame, String text,String title, String defValue)
   {
      ArrayList<JLabel> list = new ArrayList<JLabel>();
      JPanel container = new JPanel();
      PanelPainter panel = new PanelPainter();
      String ans;
      cutText(text,68,list);
      setTextProperties(panel,list,16,JLabel.CENTER,660);
      panel.setLayout(null);
      container.setBounds(157,478,685,200);
      frame.add(container);
      UI.put("OptionPane.minimumSize",new Dimension(680,180));
      ans = JOptionPane.showInputDialog(container, panel,title, JOptionPane.PLAIN_MESSAGE,null,null,defValue).toString();
      audioPressOK.play();
      return ans;
   }
}
class PanelPainter extends JPanel
{
   public void paintComponent(Graphics pen)
   {
      pen.setColor(Color.WHITE);
      for (int x =0; x<4; x++)
         pen.drawRect(0+x,0+x,658-2*x,100-2*x);
   }
}
class Player
{
   String name, alias, gender, zodiacSign;
   int year;
   double money;
   Player(String name, String alias, String gender, String zodiacSign,int year, double money)
   {
      setName(name);
      setAlias(alias);
      setGender(gender);
      setZodiacSign(zodiacSign);
      setBirthYear(year);
      setBalance(money);
   }
   Player(){};
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
   public void setZodiacSign(String sign)
   {
      zodiacSign = sign;
   }
   public void setBirthYear(int year)
   {
      this.year = year;
   }
   public void setBalance(double amount)
   {
      money = amount;
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
   public String getZodiacSign()
   {
      return zodiacSign;
   }
   public int getBirthYear()
   {
      return year;
   }
   public double getBalance()
   {
      return money;
   }
}
class GameParameters
{
   int monsters, treasures, keys;
   GameParameters(){}
   GameParameters(int monsters, int treasures, int keys)
   {
      setMonsterAmount(monsters);
      setTreasureAmount(treasures);
      setKeyAmount(keys);
   }
   public void setMonsterAmount(int number)
   {
      monsters = number;
   }
   public void setTreasureAmount(int number)
   {
      treasures = number;
   }
   public void setKeyAmount(int number)
   {
      keys = number;
   }
   public int getMonsterAmount()
   {
      return monsters;
   }
   public int getTreasureAmount()
   {
      return treasures;
   }
   public int getKeyAmount()
   {
      return keys;
   }
}
