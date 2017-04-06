/***************************************************************   
***************************************************************    
***************************************************************    
                                                         			    		   	          
                   			ID INFORMATION                         		          
                                                        			    		                      
   		Programmer			:		Cardenas Roberto                
   		Assignment #		:   	Program #1                    	
   		Assignment Name   :	   Are you Game?
   		Course # and Title:	   CISC 190 - Java    	
   		Class Meeting Time:	   TTH 1:00 – 4:05	
  		   Instructor			:	   Professor Forman 
  		   Hours			   	:	   14:00
   		Difficulty			:	   5/10			
   		Completion Date	:	   04/04/2017 	
   		File Name			:  	Interface

***************************************************************
***************************************************************/
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
/******************************************************************************
*******************************************************************************

							START METHOD DECLARATIONS AND DEFINITIONS
								 (Best to appear alphabetically)

*******************************************************************************
******************************************************************************/

/******************************************************************************

  NAME:     runGame()
  DESCRIPTION:  Runs the game by accessing the methods in the Interface class
  CALLS: displayWelcomeProtocols(), startRegistration(), displayExtraTreasureFrame(), displayExtraFeatureFrame(),
         displayExtraKeyFrame(), displayExtraFeatures(), displayExtraFeaturesCost(), displayRegistrationFeeFrame(),
         displayAccountBalanceFrame(), displayExitFrame();
  CALLED BY: Roberto_P_1.runGame()

******************************************************************************/
   public void runGame(JFrame frame)
   {
   ///////////////////////////////////////////////////////////////////////////////////////////////
   
   // Local variable/object declarations and definitions
   
   ///////////////////////////////////////////////////////////////////////////////////////////////
   
      AudioClip audioMain;
      String strPlayerName, strPlayerAlias;
      URL urlMain = Interface.class.getResource("audioMain.wav");
      audioMain = Applet.newAudioClip(urlMain);
      double totalCost;
      Player player = new Player();
      GameParameters game = new GameParameters();
      
   ////////////////////////////////////////////////////////////////////////////////////////////////
   
      audioMain.loop();
      player.setName(displayWelcomeProtocols(frame));
      startRegistration(player.getName(),player);
      displayExtraTreasureFrame(player.getAlias(),frame,game);
      displayExtraCreatureFrame(player.getAlias(),frame,game);
      displayExtraKeyFrame(player.getAlias(),frame,game);
      displayExtraFeatures(frame,player.getAlias(),game.getTreasureAmount(),game.getMonsterAmount(),game.getKeyAmount());
      displayExtraFeatureCost(frame,player.getAlias(),calcExtraFeaturesCost(game),game);
      totalCost = displayRegistrationFeeFrame(frame,player,game);
      displayAccountBalanceFrame(frame,player,totalCost);
      displayExitFrame(frame, player);
      
   }
/*****************************************************************************

  NAME:     displayWelcomeProtocols()
  DESCRIPTION:  Displays the welcome frame, retrieves and displays the users name, and 
  displays the basic welcome information (Purpose and game fees). Returns the players name
  as a string.
  CALLS: displayWelcomeFrame(), getUserName(), displayUserName(), displayInformation()
  CALLED BY: runGame()

******************************************************************************/
   public String displayWelcomeProtocols( JFrame frame)
   {
   ///////////////////////////////////////////////////////////////////
   
   //Local variable declarations
   
   ////////////////////////////////////////////////////////////////////
   
      String name = "";
      int flag = 1;
      
   ////////////////////////////////////////////////////////////////////
   
      displayWelcomeFrame(frame);
      while (flag != 0)
      {
         name = getUserName();
         flag = displayUserName(name);
      }
      displayInformation(name); 
      return name;
   }
/*****************************************************************************

  NAME:     displayInformation()
  DESCRIPTION:  Displays the welcome information using JOptionPane and the users name
  CALLS: editText()
  CALLED BY: displayWelcomeProtocols()

******************************************************************************/
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
/*****************************************************************************

  NAME:     startRegistration()
  DESCRIPTION:  Uses the players name and the corresponding Player object to register their
  alias, gender, astrological sign, birth year and monetary amount they are depositing.
  CALLS: Player.setAlias(),Player.getAlias(),Player.setGender(),Player.getGender(),Player.setZodiacSign(),
         Player.getZodiacSign(), Player.setBirthYear, Player.getBirthYear(), Player.setBalance(), Player.getBalance(),
         getPlayerAlias(), getPlayerGender(), getPlayerAstroSign(), getPlayerBirthYear(), getPlayerDepositAmount(), 
         displayPlayerInformation()
  CALLED BY: runGame()

******************************************************************************/
   public void startRegistration(String name,Player player)
   {
   ///////////////////////////////////////////////////////////
   
   //Local Variable delcarations
   
   ///////////////////////////////////////////////////////////
   
      String alias,gender,sign;
      int year;
      double balance;
      
   ///////////////////////////////////////////////////////////
   
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
/*****************************************************************************

  NAME:     getPlayerAlias()
  DESCRIPTION:  Uses the players name to promp for there Alias and return it as a string
  CALLS: editText()
  CALLED BY: startRegistration()

******************************************************************************/
   public String getPlayerAlias(String name)
   {
   //////////////////////////////////////////////////////////////////////////////
   
   //Local variable/object declarations an definitions
   
   //////////////////////////////////////////////////////////////////////////////
   
      String alias, text;
      Random randGenerator = new Random();
      String[] goofyNickNames = {"Poopy McPoopyFace", "Baron VonFart", "Vlad the Inhaler", 
      "President Cheeto", "XX_CringeMaster_XX","Mr. Pink","Dinkleberg","Alaska Young",
      "babezzz4dayzzzz","El_Peje_Es_Mi_Pastor","javasuxxx","KawaiPandax12"};
      
      text = "Make up a nickname for yourself "+name
            +", or I will make one up for you... (For example: Baron VonFart)";
      
   ///////////////////////////////////////////////////////////////////////////
      
      alias = JOptionPane.showInputDialog(null,editText(text,18),
      "Input Alias",JOptionPane.PLAIN_MESSAGE,null,null,goofyNickNames[randGenerator.nextInt(goofyNickNames.length)]).toString();
      audioPressOK.play();
      
      return alias;
   }
/*****************************************************************************

  NAME:     getPlayerGender()
  DESCRIPTION:  Uses the players alias to prompt for there gender and return it as a string
  CALLS: editText()
  CALLED BY: startRegistration()

******************************************************************************/
   public String getPlayerGender(String alias)
   {
   ///////////////////////////////////////////////////////////////////////////////
   
   //Local variable declarations and definitions
   
      String gender,text;
      text = "So are you a 'Boy' or a 'Girl' "+alias+"? Its really hard to tell";
      
   ///////////////////////////////////////////////////////////////////////////////
                   
      gender = JOptionPane.showInputDialog(null,editText(text,18),
               "Input Gender",JOptionPane.PLAIN_MESSAGE,null,null,"Boy").toString();
      audioPressOK.play();
      return gender;
   }
/*****************************************************************************

  NAME:     getPlayerAstroSign()
  DESCRIPTION:  Uses the players alias to prompt for there astrological sign and return it as a string
  CALLS: editText()
  CALLED BY: startRegistration()

******************************************************************************/
   public String getPlayerAstroSign(String alias)
   {
   //////////////////////////////////////////////////////////////////////////////////
   
   //Local variable declarations an definitions
   
   /////////////////////////////////////////////////////////////////////////////////
   
      int indicator;
      String sign, text;
      String[] zodiacSigns = {"Aquarius : Jan 20/Feb 18","Pisces : Feb 19/March 20","Aries : March 21/April 19",
      "Taurus : April 20/May 20", "Gemini : May 21/June 20", "Cancer : June 21/July 22","Leo : July 23/ August 22",
      "Virgo : August 23/Sep 22","Libra : Sep 23/Oct 22","Scorpio : Oct 23/Nov 21","Sagitarius Nov 22/Dec 21",
      "Capricorn : Dec 22/Jan 19"};
      text = "So "+alias + ", what is your zodiac sign?";
      
   /////////////////////////////////////////////////////////////////////////////////////
   
      sign = JOptionPane.showInputDialog(null,editText(text,18),
             "Input Astrological Sign",JOptionPane.PLAIN_MESSAGE,null,zodiacSigns,zodiacSigns[0]).toString();
      indicator = sign.indexOf(' ');
      sign = sign.substring(0,indicator);
      audioPressOK.play();
      return sign;
   }
/*****************************************************************************

  NAME:     getPlayerBirthYear()
  DESCRIPTION:  Uses the players alias to prompt for there birth year and return it as an int
  CALLS: editText()
  CALLED BY: startRegistration()

******************************************************************************/
   public int getPlayerBirthYear(String alias)
   {
   /////////////////////////////////////////////////////////////////////////////////////////////////
   
   //Local variable declarations and definitions
   
   ////////////////////////////////////////////////////////////////////////////////////////////////
   
      int year;
      String text,strYear;
      text = "Tell me what year you were born in "+alias+"... Why? BECAUSE I SAY SO, THATS WHY!";
   
   //////////////////////////////////////////////////////////////////////////////////////////////////
   
      strYear = JOptionPane.showInputDialog(null,editText(text,18),
               "Input Birthyear",JOptionPane.PLAIN_MESSAGE,null,null,"1997").toString();
      year = Integer.parseInt(strYear);
      audioPressOK.play();
      return year;
   }
/*****************************************************************************

  NAME:     getPlayerDepositAmount()
  DESCRIPTION:  Uses the players alias to prompt for the amount of money they are 
  depositing and return it as a double
  CALLS: editText()
  CALLED BY: startRegistration()

******************************************************************************/
   public double getPlayerDepositAmount(String alias)
   {
      //////////////////////////////////////////////////////////////////////////
      
      //Local variable declarations and definitions
      
      /////////////////////////////////////////////////////////////////////////
      
      double money;
      String text, strMoney;
      text = "How much dough are you depositing to your account "+alias+"?";
      
      //////////////////////////////////////////////////////////////////////////
      
      strMoney =  JOptionPane.showInputDialog(null,editText(text,18),
                  "Input Cash Amount",JOptionPane.PLAIN_MESSAGE,null,null,"1234.567").toString();
      money = Double.parseDouble(strMoney);
      money = robertosRoundToPenny(money);
      audioPressOK.play();
      return money;
   }
/*****************************************************************************

  NAME:     displayPlayerInformation()
  DESCRIPTION:  Displays the players alias, gender, astrological sign, birth year and account balance in a friendly way
  CALLS: editText()
  CALLED BY: startRegistration()

******************************************************************************/
   public void displayPlayerInformation(String alias, String gender, String sign, int year, double amount)
   {
      NumberFormat currencyFormater = NumberFormat.getCurrencyInstance();
      String text = "So "+alias+", you're a "+gender+" and a "+sign+" born in "+year+"? I never would have guessed, "
      +"I'm a transgender Capricorn myself. Cool! Looks like your deposit for "+currencyFormater.format(amount)+" went through! ";
      JOptionPane.showMessageDialog(null,editText(text,18),"Confirm Player Information",JOptionPane.PLAIN_MESSAGE);
      audioPressOK.play();
   }
/*****************************************************************************

  NAME:     displayExtraTreasureFrame()
  DESCRIPTION:  Clears the JFrame and displays the Extra Features Frame, using the players alias
  to prompt them for how many extras treasures they would like, storing the value in the GameParameters
  object
  CALLS: editImage(), showMsgGameDialog(), showInputGameDialog(), GameParameters.setTreasureAmount()
  CALLED BY: runGame()

******************************************************************************/
   public void displayExtraTreasureFrame(String alias, JFrame frame, GameParameters game)
   {
      /////////////////////////////////////////////////////////////////////
      
      //Local variable/object declarations and definitions
      
      /////////////////////////////////////////////////////////////////////
      
      JPanel panel = new JPanel();
      
      JLabel labelExtraTreasure1 = new JLabel("Its a bowl of spaguetti with marinara sauce.");
      JLabel labelExtraTreasure2 = new JLabel("Will you take it " +alias+ "? ");
      JLabel labelSpaghetti = new JLabel();
      
      /////////////////////////////////////////////////////////////////////

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
/*****************************************************************************

  NAME:     displayExtraCreatureFrame()
  DESCRIPTION:  Clears the JFrame and displays the Extra Creatures Frame, using the players alias
  to prompt them for how many extras creatures they would like, storing the value in the GameParameters
  object
  CALLS: editImage(), showMsgGameDialog(), showInputGameDialog(), GameParameters.setMonsterAmount()
  CALLED BY: runGame()

******************************************************************************/
   public void displayExtraCreatureFrame(String alias, JFrame frame, GameParameters game)
   {
   //////////////////////////////////////////////////////////////////////////////////////
   
   //Local variable/object declarations and definitions
   
   /////////////////////////////////////////////////////////////////////////////////////
   
      JPanel panel = new JPanel();
      
      JLabel labelExtra1 = new JLabel("A group of monsters aproaches to meet you...");
      JLabel labelExtra2 = new JLabel("Will you say hi " +alias+ "? ");
      JLabel labelImage = new JLabel();
   
   //////////////////////////////////////////////////////////////////////////////////////

      //Set labelExtra1 properties
      labelExtra1.setForeground(Color.WHITE);
      labelExtra1.setFont(new Font("Determination Mono",Font.BOLD,35));
      labelExtra1.setBounds(0,30,1000,200);
      labelExtra1.setHorizontalAlignment(JLabel.CENTER);
      labelExtra1.setVerticalAlignment(JLabel.TOP);
      
      //Set labelExtra2 properties
      labelExtra2.setForeground(Color.WHITE);
      labelExtra2.setFont(new Font("Determination Mono",Font.BOLD,30));
      labelExtra2.setBounds(0,0,1000,200);
      labelExtra2.setHorizontalAlignment(JLabel.CENTER);
     // labelExtraTreasure2.setVerticalAlignment(JLabel.TOP);
      
      //Set labelImage properties
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
/*****************************************************************************

  NAME:     displayExtraKeyFrame()
  DESCRIPTION:  Clears the JFrame and displays the Extra Key Frame, using the players alias
  to prompt them for how many extras keys they would like, storing the value in the GameParameters
  object
  CALLS: editImage(), showMsgGameDialog(), showInputGameDialog(), GameParameters.setKeyAmount()
  CALLED BY: runGame()

******************************************************************************/
   public void displayExtraKeyFrame(String alias, JFrame frame, GameParameters game)
   {
   ////////////////////////////////////////////////////////////////////////////////////
   
   //Local variable/object declarations and definitions
   
   ////////////////////////////////////////////////////////////////////////////////////
   
      JPanel panel = new JPanel();
      
      JLabel labelExtra1 = new JLabel("You see a small beating heart in the distance");
      JLabel labelExtra2 = new JLabel(alias+", you are filled with DETERMINATION!!!");
      JLabel labelImage = new JLabel();
   
   ////////////////////////////////////////////////////////////////////////////////////
   
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
/*****************************************************************************

  NAME:     displayExtraFeatures()
  DESCRIPTION:  Uses the users alias, and the amount of units treasures, creatures and keys selected by the user to confirm
  these amounts with the user.
  CALLS: showMsgGameDialog()
  CALLED BY: runGame()

******************************************************************************/
   public void displayExtraFeatures(JFrame frame, String alias, int treasures, int creatures, int keys)
   {
      //////////////////////////////////////////////////////////////
      
      //Local variable/object declarations
      
      //////////////////////////////////////////////////////////////
      
      String text = "So "+alias+", you've decided to buy "+treasures+" extra bowl(s) of moldy spaghetti, invite " 
      +creatures+" other monster(s) to join you on your quest, and have "+keys+" extra SOUL(S) for you to find";
      
      //////////////////////////////////////////////////////////////
      
      showMsgGameDialog(frame, text, "UNDERTALE");
   }
/*****************************************************************************

  NAME:     calcExtraFeaturesCost()
  DESCRIPTION:  Calculates and returns the total ExtraFeaturesCost, by multiplying the values stored in 
  the GameParameters object times 1.25.
  CALLS: GameParameters.getTreasureAmount(), GameParameters.getMonsterAmount(), GameParameters.getKeyAmount()
  CALLED BY: runGame()

******************************************************************************/
   public double calcExtraFeaturesCost(GameParameters game)
   {
   /////////////////////////////////////////////////////////////////////////////////////////////////////
   
   //Local variable/object declarations and definitions
   
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   
      final double price = 1.25;
      double ans;
      ans = game.getTreasureAmount()*price + game.getMonsterAmount()*price + game.getKeyAmount()*price;
      
   /////////////////////////////////////////////////////////////////////////////////////////////////////
   
      return ans;
   }
/*****************************************************************************

  NAME:     displayExtraFeatureCost()
  DESCRIPTION:  Uses the players alias and the GameParamters object to display the extra features cost
  in an engaging way.
  CALLS: GameParameters.getTreasureAmount(),GameParameters.getKeyAmount(), GameParameters.getMonsterAmount(), showMsgGameDialog()
  CALLED BY: runGame()

******************************************************************************/
   public void displayExtraFeatureCost(JFrame frame, String alias, double cost, GameParameters game)
   {
   /////////////////////////////////////////////////////////////////////////////////////////////
   
   //Local variable/object declarations and definitions
   
   /////////////////////////////////////////////////////////////////////////////////////////////
   
      NumberFormat currencyFormater = NumberFormat.getCurrencyInstance();
      
      int amount = game.getTreasureAmount()+game.getKeyAmount()+game.getMonsterAmount();
      
      String text = "Having these extra features ain't come cheap "+alias+", "
      +currencyFormater.format(cost)+" to be exact. What? You don't believe me? It's $1.2"
      +"5 per extra feature, "+amount+" times $1.25 is "+currencyFormater.format(cost)+"! Sigh...humans";
      
   ///////////////////////////////////////////////////////////////////////////////////////////////////////
   
      showMsgGameDialog(frame,text,"UNDERTALE");
   }
/*****************************************************************************

  NAME:     getUserAge()
  DESCRIPTION:  uses the users Birth year to calculate and return the users age
  CALLS: 
  CALLED BY: displayRegistrationFeeFrame()

******************************************************************************/
   public int getUserAge(int year)
   {
      return 2017 - year;
   }
/*****************************************************************************

  NAME:     getUserFee()
  DESCRIPTION:  uses the users age to calculate and return the the corresponding basic
  registration fee
  CALLS: 
  CALLED BY: displayRegistrationFeeFrame()

******************************************************************************/
   public double getUserFee(int age)
   {
      ////////////////////////////////////////////////////////////
      
      //Local variable declarations
      
      ///////////////////////////////////////////////////////////
      
      int number;
      double ans;
      
      ///////////////////////////////////////////////////////////
      
      number = age-8;
      number = number/5;
      ans = number * 2.5;
      ans+= 5.0;
      ans = Math.min(ans,9.75);
      return ans;
   }
/*****************************************************************************

  NAME:     robertosRoundToPenny()
  DESCRIPTION:  rounds the given amount to the nearest penny adn returns it
  CALLS: 
  CALLED BY: displayRegistrationFeeFrame()

******************************************************************************/
   public double robertosRoundToPenny(double amount)
   {
      amount = amount*100;
      amount = Math.round(amount);
      amount = amount/100;
      return amount;
   }
/*****************************************************************************

  NAME:     displayRegistrationFee()
  DESCRIPTION:  Clears the JFrame and uses the Player object and GameParamters object to
  calculate and display and return the final registration fee
  CALLS: GameParameters.getMonsterAmount, GameParamters.getKeyAmount, GameParameters.getTreasureAmount,
  getUserFee, getUserAge, Player.getBirthYear, robertosRoundToPenny, Player.getName, Player.getAlias,
  editImage, showMsgGameDialog
  CALLED BY: runGame()

******************************************************************************/
   public double displayRegistrationFeeFrame(JFrame frame, Player player, GameParameters game)
   {
   //////////////////////////////////////////////////////////////////////////////////////////////////
   
   //Local variable/object declarations an definitions
   
   /////////////////////////////////////////////////////////////////////////////////////////////////
   
      NumberFormat currencyFormater = NumberFormat.getCurrencyInstance();
      JLabel line1,line2,line3,line4,line5,line6,line7,line8,line9,line10,line11,labelSoldier,labelBox;
      labelSoldier = new JLabel();
      labelBox = new JLabel();
      JPanel panel = new JPanel();
      int extraFeatures = game.getMonsterAmount()+game.getKeyAmount()+game.getTreasureAmount();
      double basicCost,extraFeaturesCost,subtotal, fee, total;
      basicCost = getUserFee(getUserAge(player.getBirthYear())); 
      extraFeaturesCost =  extraFeatures * 1.25;
      subtotal = basicCost + extraFeaturesCost;
      fee = robertosRoundToPenny(subtotal*0.1);
      total = subtotal + fee;
      line1 = new JLabel(player.getName()+", aka "+player.getAlias()+", here's your tab:");
      line2 = new JLabel(""+currencyFormater.format(basicCost)+" - Basic Registration Fee - based on your age");
      line3 = new JLabel(""+currencyFormater.format(extraFeaturesCost)+ " - At $1.25 per feature for "+extraFeatures+" Extra Game Features of:");
      line4 = new JLabel(""+game.getTreasureAmount()+ " Moldy Spaghetti Bowl(s)");
      line5 = new JLabel(""+game.getMonsterAmount()+ " Monster(s)");
      line6 = new JLabel(""+game.getKeyAmount()+ " Key(s)");
      line7 = new JLabel("==============");
      line8 = new JLabel(""+currencyFormater.format(subtotal)+" - Subtotal");
      line9 = new JLabel(""+currencyFormater.format(fee)+" - Rounded ESCAPE Service Fee of 10%");
      line10 = new JLabel("==============");
      line11 = new JLabel(""+currencyFormater.format(total)+" - Total ESCAPE Registration Fee");
      JLabel[] lines = {line1,line2,line3,line4,line5,line6,line7,line8,line9,line10,line11};
      
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
      for(int x = 0; x<lines.length;x++)
      {
         lines[x].setBounds(0,200+x*20,1000,30);
         lines[x].setHorizontalAlignment(JLabel.CENTER);
         lines[x].setFont(new Font("Determination Mono",Font.BOLD,18));
         lines[x].setForeground(Color.WHITE);
         panel.add(lines[x]);
      }
      labelBox.setIcon(new ImageIcon(editImage("dialogueBox.png",700,250)));
      labelBox.setBounds(0,22,1000,600);
      labelBox.setHorizontalAlignment(JLabel.CENTER);
      labelSoldier.setIcon(new ImageIcon(editImage("mediaSoldierGif.gif",200,190)));
      labelSoldier.setBounds(0,0,1000,300);
      labelSoldier.setVerticalAlignment(JLabel.TOP);
      labelSoldier.setHorizontalAlignment(JLabel.CENTER);
      panel.add(labelBox);
      panel.add(labelSoldier);
      panel.setLayout(null);
      frame.getContentPane().removeAll();
      frame.setTitle("Registration Fee");
      frame.add(panel);
      frame.setVisible(true);
      showMsgGameDialog(frame,"Press ENTER to continue, "+player.getAlias()+"...","UNDERTALE");
      return total;
      
   }
/*****************************************************************************

  NAME:     displayAccountBalance()
  DESCRIPTION:  Clears the JFrame and uses the Player object, GameParameters object and the total
  registration fee to calculate and display the the current account balance
  CALLS: Player.getName, Player.getAlias, Player.getBalance, robertosRoundToPenny, editImage, showMsgGameDialog
  CALLED BY: displayRegistrationFeeFrame()

******************************************************************************/
   public void displayAccountBalanceFrame(JFrame frame,Player player, double total)
   {
      ///////////////////////////////////////////////////////////////////////////
      
      //Local variable/object declarations and definitions
      
      ///////////////////////////////////////////////////////////////////////////
      
      NumberFormat currencyFormater = NumberFormat.getCurrencyInstance();
      JLabel line1,line2,line3,line4,line5,line6,line7,line8,line9,line10,line11,labelBox;
      labelBox = new JLabel();
      JPanel panel = new JPanel();
      line1 =  new JLabel("UNDERTALE Escape from the Underground Account Balance");
      line2 = new JLabel("===========================");
      line3 = new JLabel("");
      line4 = new JLabel("Summary of Account for "+player.getName()+", aka "+player.getAlias()+":");
      line5 = new JLabel("");
      line6 = new JLabel(currencyFormater.format(player.getBalance())+" - Amount deposited into your account");
      line7 = new JLabel(currencyFormater.format(total)+" - Total ESCAPE Registration Fee");
      line8 = new JLabel("================");
      line9 = new JLabel(currencyFormater.format(robertosRoundToPenny(player.getBalance()-total))+" - Current Account Balance");
      line10 = new JLabel("");
      line11 = new JLabel("Have a nice day human, or not. I don't care...");
      JLabel[] lines = {line1,line2,line3,line4,line5,line6,line7,line8,line9,line10,line11};
      
      /////////////////////////////////////////////////////////////////////////////////////////////
      
      for(int x = 0; x<lines.length;x++)
      {
         lines[x].setBounds(0,200+x*20,1000,30);
         lines[x].setHorizontalAlignment(JLabel.CENTER);
         lines[x].setFont(new Font("Determination Mono",Font.BOLD,18));
         lines[x].setForeground(Color.WHITE);
         panel.add(lines[x]);
      }
      labelBox.setIcon(new ImageIcon(editImage("dialogueBox.png",700,250)));
      labelBox.setBounds(0,22,1000,600);
      labelBox.setHorizontalAlignment(JLabel.CENTER);
      panel.add(labelBox);
      panel.setLayout(null);
      frame.getContentPane().removeAll();
      frame.setTitle("Account Balance");
      frame.add(panel);
      frame.setVisible(true);
      showMsgGameDialog(frame,"Press ENTER to continue, "+player.getAlias()+"...","UNDERTALE");
   }
/*****************************************************************************

  NAME:     displayExitFrame()
  DESCRIPTION:  Clears the JFrame and uses the Player object to display the Farewell Frame and the corresponding documentation
  CALLS: Player.getName, displayFarewellFrame, displayDocumentation
  CALLED BY: runGame()

******************************************************************************/
   public void displayExitFrame(JFrame frame, Player player)
   {
      displayFarewellFrame(frame, player.getName());
      displayDocumentation();
      System.exit(0);
   }
/*****************************************************************************

  NAME:     showMsgGameDialog()
  DESCRIPTION:  Creates a JOptionPane.showMessageDialog window located at the bottom of the specified frame using the specified text and title
  CALLS: cutText, setTextProperties
  CALLED BY: displayRegistrationFeeFrame(), displayAccountBalanceFrame(), displayExtraTreasureFrame(), displayExtraCreatureFrame()
  displayExtraKeyFrame()

******************************************************************************/
   public void showMsgGameDialog(JFrame frame, String text, String title)
   {
   /////////////////////////////////////////////////////////////
   
   //Local variable/object declarations and definitions
   
   /////////////////////////////////////////////////////////////
   
      ArrayList<JLabel> list = new ArrayList<JLabel>();
      JPanel container = new JPanel();
      PanelPainter panel = new PanelPainter();
      
   /////////////////////////////////////////////////////////////
   
      cutText(text,68,list);
      setTextProperties(panel,list,16,JLabel.CENTER,660);
      panel.setLayout(null);
      container.setBounds(157,478,685,200);
      frame.add(container);
      UI.put("OptionPane.minimumSize",new Dimension(680,180));
      JOptionPane.showMessageDialog(container, panel,title, JOptionPane.PLAIN_MESSAGE);
      audioPressOK.play();   
   }
/*****************************************************************************

  NAME:     showInputGameDialog()
  DESCRIPTION:  Creates a JOptionPane,showInputDialog window located at the bottom of the specified frame using the specified text, title
  and default value
  CALLS: cutText, setTextProperties
  CALLED BY: displayRegistrationFeeFrame(), displayAccountBalanceFrame(), displayExtraTreasureFrame(), displayExtraCreatureFrame()
  displayExtraKeyFrame()

******************************************************************************/
   public String showInputGameDialog(JFrame frame, String text,String title, String defValue)
   {
   ///////////////////////////////////////////////////////////////
   
   //Local variable/object declarations and definitions
   
   ///////////////////////////////////////////////////////////////
   
      ArrayList<JLabel> list = new ArrayList<JLabel>();
      JPanel container = new JPanel();
      PanelPainter panel = new PanelPainter();
      
   ///////////////////////////////////////////////////////////////
   
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
/******************************************************************************
*******************************************************************************

							END METHOD DECLARATIONS AND DEFINITIONS

*******************************************************************************
******************************************************************************/
}
/******************************************************************************
*******************************************************************************

							START CUSTOM CLASS DECLARATIONS AND DEFINITIONS
								 (Best to appear alphabetically)

*******************************************************************************
******************************************************************************/
class PanelPainter extends JPanel
{
/******************************************************************************
*******************************************************************************

							START METHOD DECLARATIONS AND DEFINITIONS

*******************************************************************************
******************************************************************************/
/*****************************************************************************

  NAME:     paintComponent()
  DESCRIPTION:  Uses the graphics object to draw on the panel
  CALLS: 
  CALLED BY: showMsgGameDialog, showInputGameDialog

******************************************************************************/
   public void paintComponent(Graphics pen)
   {
      pen.setColor(Color.WHITE);
      for (int x =0; x<4; x++)
         pen.drawRect(0+x,0+x,658-2*x,100-2*x);
   }
/******************************************************************************
*******************************************************************************

							END METHOD DECLARATIONS AND DEFINITIONS

*******************************************************************************
******************************************************************************/
}
class Player
{
////////////////////////////////////////////////////////////

//Instance variable/ object declarations

///////////////////////////////////////////////////////////

   String name, alias, gender, zodiacSign;
   int year;
   double money;
   
//////////////////////////////////////////////////////////////
/*****************************************************************************

  NAME:     Player()
  DESCRIPTION:  Assigns each parameter to its corresponding instance variable
  CALLS: setName, setAlias, setGender, setZodiacSign, setBirthYear, setBalance
  CALLED BY: 

******************************************************************************/
   Player(String name, String alias, String gender, String zodiacSign,int year, double money)
   {
      setName(name);
      setAlias(alias);
      setGender(gender);
      setZodiacSign(zodiacSign);
      setBirthYear(year);
      setBalance(money);
   }
/*****************************************************************************

  NAME:     Player()
  DESCRIPTION:  Initializes the Player object instance without parameters
  CALLED BY: runGame()

******************************************************************************/
   Player(){};
/******************************************************************************
*******************************************************************************

							START METHOD DECLARATIONS AND DEFINITIONS

*******************************************************************************
******************************************************************************/
/*****************************************************************************

  NAME:     setName()
  DESCRIPTION:  Assigns name to its corresponding instance variable
  CALLS: 
  CALLED BY: Player

******************************************************************************/
   public void setName(String name)
   {
      this.name = name;
   }
/*****************************************************************************

  NAME:     setAlias()
  DESCRIPTION:  Assigns alias to its corresponding instance variable
  CALLS: 
  CALLED BY: Player

******************************************************************************/
   public void setAlias(String alias)
   {
      this.alias = alias;
   }
/*****************************************************************************

  NAME:     setGender()
  DESCRIPTION:  Assigns gender to its corresponding instance variable
  CALLS: 
  CALLED BY: Player

******************************************************************************/
   public void setGender(String gender)
   {
      this.gender = gender;
   }
/*****************************************************************************

  NAME:     setZodiacSign()
  DESCRIPTION:  Assigns sign to its corresponding instance variable
  CALLS: 
  CALLED BY: Player

******************************************************************************/
   public void setZodiacSign(String sign)
   {
      zodiacSign = sign;
   }
/*****************************************************************************

  NAME:     setBirthYear()
  DESCRIPTION:  Assigns year to its corresponding instance variable
  CALLS: 
  CALLED BY: Player

******************************************************************************/
   public void setBirthYear(int year)
   {
      this.year = year;
   }
/*****************************************************************************

  NAME:     setBalance()
  DESCRIPTION:  Assigns amount to its corresponding instance variable
  CALLS: 
  CALLED BY: Player

******************************************************************************/
   public void setBalance(double amount)
   {
      money = amount;
   }
/*****************************************************************************

  NAME:     getName()
  DESCRIPTION:  returns the instance variable name
  CALLS: 
  CALLED BY:

******************************************************************************/
   public String getName()
   {
      return name;
   }
/*****************************************************************************

  NAME:     getAlias()
  DESCRIPTION:  Returns the instance variable alias
  CALLS: 
  CALLED BY: 

******************************************************************************/
   public String getAlias()
   {
      return alias;
   }
/*****************************************************************************

  NAME:     getGender()
  DESCRIPTION:  Returns the instance variable gender
  CALLS: 
  CALLED BY: 

******************************************************************************/
   public String getGender()
   {
      return gender;
   }
/*****************************************************************************

  NAME:     getZodiacSign()
  DESCRIPTION:  Returns the instance variable zodiacSign
  CALLS: 
  CALLED BY:

******************************************************************************/
   public String getZodiacSign()
   {
      return zodiacSign;
   }
/*****************************************************************************

  NAME:     getBirthYear()
  DESCRIPTION:  Returns the instance variable year
  CALLS: 
  CALLED BY:

******************************************************************************/
   public int getBirthYear()
   {
      return year;
   }
/*****************************************************************************

  NAME:     getBalance()
  DESCRIPTION:  Returns the instance variable money
  CALLS: 
  CALLED BY:

******************************************************************************/
   public double getBalance()
   {
      return money;
   }
/******************************************************************************
*******************************************************************************

							END METHOD DECLARATIONS AND DEFINITIONS

*******************************************************************************
******************************************************************************/
}
class GameParameters
{
////////////////////////////////////////////////////////////////

//Instance variable declarations

////////////////////////////////////////////////////////////////

   int monsters, treasures, keys;

////////////////////////////////////////////////////////////////
/*****************************************************************************

  NAME:     GameParameters()
  DESCRIPTION:  Initializes the GameParameters object instance without parameters
  CALLS:
  CALLED BY: runGame()

******************************************************************************/
   GameParameters(){}
/*****************************************************************************

  NAME:     GameParameters()
  DESCRIPTION:  Initializes the GameParameters object instance with thw monster, teasure and key amounts
  CALLS: setMonsterAmount, setTreasureAmount, setKeyAmount
  CALLED BY: 

******************************************************************************/
   GameParameters(int monsters, int treasures, int keys)
   {
      setMonsterAmount(monsters);
      setTreasureAmount(treasures);
      setKeyAmount(keys);
   }
/******************************************************************************
*******************************************************************************

							START METHOD DECLARATIONS AND DEFINITIONS

*******************************************************************************
******************************************************************************/
/*****************************************************************************

  NAME:     setMonsterAmount()
  DESCRIPTION:  Assigns number to to the instance variable monsters
  CALLS: 
  CALLED BY: GameParameters

******************************************************************************/
   public void setMonsterAmount(int number)
   {
      monsters = number;
   }
/*****************************************************************************

  NAME:     setTreasureAmount()
  DESCRIPTION:  Assigns number to the instance variable treasures
  CALLS: 
  CALLED BY: GameParameters

******************************************************************************/
   public void setTreasureAmount(int number)
   {
      treasures = number;
   }
/*****************************************************************************

  NAME:     setKeyAmount()
  DESCRIPTION:  Assigns number to the instance variable keys
  CALLS: 
  CALLED BY: GameParameters

******************************************************************************/
   public void setKeyAmount(int number)
   {
      keys = number;
   }
/*****************************************************************************

  NAME:     getMonsterAmount()
  DESCRIPTION:  Returns the instance variable monsters
  CALLS: 
  CALLED BY:

******************************************************************************/
   public int getMonsterAmount()
   {
      return monsters;
   }
/*****************************************************************************

  NAME:     getTreasureAmount()
  DESCRIPTION:  Returns the instance variable treasures
  CALLS: 
  CALLED BY:

******************************************************************************/
   public int getTreasureAmount()
   {
      return treasures;
   }
/*****************************************************************************

  NAME:     getKeyAmount()
  DESCRIPTION:  Returns the instance variable keys
  CALLS: 
  CALLED BY:

******************************************************************************/
   public int getKeyAmount()
   {
      return keys;
   }
/******************************************************************************
*******************************************************************************

							END METHOD DECLARATIONS AND DEFINITIONS

*******************************************************************************
******************************************************************************/
}
/******************************************************************************
*******************************************************************************

							END CUSTOM-DEFINED CLASSES

*******************************************************************************
******************************************************************************/