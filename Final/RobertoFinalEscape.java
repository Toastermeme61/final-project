import javax.swing.*;//JFrame, JLabel, JButton, JOPtionPane
import java.util.*;//Date
import java.awt.*;//Color, Font
import java.awt.event.*;//ActionListener
public class RobertoFinalEscape
{
   //UIManager UI = new UIManager();
   DialogueManager DM = new DialogueManager();
   Player player =  new Player();
   GameParameters gameParameters = new GameParameters();
   public static void main(String[] args)
   {
      JFrame frameMain = new JFrame("Undertale");
      RobertoFinalEscape finalEscape = new RobertoFinalEscape();
      frameMain.setSize(1000,720);
      frameMain.setLocationRelativeTo(null);
      frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      finalEscape.showWelcomeFrame(frameMain);
      //finalEscape.showFeatureSelectFrame(frameMain);
      //finalEscape.showRegistrationInfoFrame(frameMain, 9.75, "Lazy Bones");
   }
/******************************************************************************
*******************************************************************************

							START METHOD DECLARATIONS AND DEFINITIONS
								 (Best to appear alphabetically)

*******************************************************************************
******************************************************************************/

/******************************************************************************

	NAME:          showWelcomeFrame
	DESCRIPTION:    Takes the original JFrame as a parameter, adding components 
   and displaying them to the user in a friendly way.
   
******************************************************************************/

   public void showWelcomeFrame(JFrame frame)
   {
      ////////////////////////////////////////////////////////////////

      //Local variable/Object declarations and definions

      ////////////////////////////////////////////////////////////////////////////////////

      Date date = new Date();
      JPanel panel = new JPanel();
      JLabel labelDate = new JLabel(date.toString());
      JLabel labelBackground = new JLabel();
      JLabel labelSans = new JLabel();
      JLabel labelPapyrus = new JLabel();
      JLabel labelTitle = new JLabel("Escape from the Underground");
      JLabel labelWelcome = new JLabel("Welcome! You're a long way from home, human...");
      JButton overviewButton = new JButton("Overview");
      JButton exitButton = new JButton("Exit");
      JButton loginButton = new JButton("Login");
      
      ////////////////////////////////////////////////////////////////////////////////////
           
      
      
      //Set labelDate properties
      labelDate.setBounds(0,600,1000,50);
      labelDate.setHorizontalAlignment(JLabel.CENTER);
      labelDate.setForeground(Color.WHITE);
      labelDate.setFont(new Font("Determination Mono",Font.BOLD,20));
      
      //Set labelTitle properties
      labelTitle.setBounds(0,90,1000,80);
      labelTitle.setHorizontalAlignment(JLabel.CENTER);
      labelTitle.setForeground(Color.WHITE);
      labelTitle.setFont(new Font("Determination Mono",Font.BOLD,40));
      
      //Set labelWelcome properties
      labelWelcome.setBounds(0,480,1000,80);
      labelWelcome.setHorizontalAlignment(JLabel.CENTER);
      labelWelcome.setForeground(Color.WHITE);
      labelWelcome.setFont(new Font("Determination Mono",Font.BOLD,30));
      
      //Set labelBackground properties
      labelBackground.setIcon(new ImageIcon("mediaBackground.jpg"));
      labelBackground.setBounds(-15,-290,1000,700);
      
      //Set labelSans properties
      labelSans.setIcon(new ImageIcon("mediaSansGif.gif"));
      labelSans.setBounds(0,0,1000,670);
      labelSans.setHorizontalAlignment(JLabel.LEFT);
      labelSans.setVerticalAlignment(JLabel.CENTER);
      
      //Set labelPapyrus properties
      labelPapyrus.setIcon(new ImageIcon("mediaPapyrusGif.gif"));
      labelPapyrus.setBounds(0,0,1000,620);
      labelPapyrus.setHorizontalAlignment(JLabel.RIGHT);
      labelPapyrus.setVerticalAlignment(JLabel.CENTER);
      
      setupButton(overviewButton, 225, 320);
      overviewButton.addActionListener( new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               showOverviewFrame(frame);
            }
         }
      );
      
      setupButton(loginButton,425,320);
      loginButton.addActionListener( new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               showLoginFrame(frame);
            }
         }
      );
      
      setupButton(exitButton,625,320);
      exitButton.addActionListener( new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               showExitFrame(frame);
            }
         }
      );
      
      //Set panel properties and add components
      panel.setLayout(null);
      panel.setBackground(Color.BLACK);
      panel.add(overviewButton);
      panel.add(loginButton);
      panel.add(exitButton);
      panel.add(labelTitle);
      panel.add(labelWelcome);
      panel.add(labelSans);
      panel.add(labelPapyrus);
      panel.add(labelBackground);
      panel.add(labelDate);
      
      //Set frame properties and add panel
      frame.getContentPane().removeAll();
      frame.setTitle("Welcome to Roberto's Escape from the Undergound!!!");
      frame.add(panel);
      frame.setVisible(true);      
   }
/******************************************************************************

	NAME:          showOverviewFrame
	DESCRIPTION:    
   
******************************************************************************/
   public void showOverviewFrame(JFrame frame)
   {
      JLabel feesLabel = new JLabel();
      JLabel purposeLabel = new JLabel();
      JButton backButton = new JButton("Back");
      JPanel panel =  new JPanel();
      
      feesLabel.setIcon(new ImageIcon("mediaFees.png"));
      feesLabel.setBounds(0,15,1000,700);
      feesLabel.setHorizontalAlignment(JLabel.CENTER);
      feesLabel.setVerticalAlignment(JLabel.TOP);
      
      purposeLabel.setIcon(new ImageIcon("mediaPurpose.png"));
      purposeLabel.setBounds(0,210,1000,700);
      purposeLabel.setHorizontalAlignment(JLabel.CENTER);
      purposeLabel.setVerticalAlignment(JLabel.TOP);
      
      setupButton(backButton,425,600);
      backButton.addActionListener( new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               showWelcomeFrame(frame);
            }
         }
      );
      
      
      panel.setLayout(null);
      panel.setBackground(Color.BLACK);
      panel.add(backButton);
      panel.add(feesLabel);
      panel.add(purposeLabel);
      
      
      frame.getContentPane().removeAll();
      frame.setTitle("Overview");
      frame.add(panel);
      frame.setVisible(true); 
   }
/******************************************************************************

	NAME:          showLoginFrame
	DESCRIPTION:    
   
******************************************************************************/
   public void showLoginFrame(JFrame frame)
   {
      JPanel panel = new JPanel();
      JTextField pinTxtField = new JTextField();
      JTextField passTxtField = new JTextField();
      JLabel passLabel = new JLabel("Enter Password:");
      JLabel pinLabel = new JLabel("Enter PIN Number:");
      JLabel warningLabel = new JLabel("");
      JButton submitButton = new JButton("Submit");
      JButton exitButton = new JButton("Exit");
      
      pinTxtField.setBounds(500,150, 150, 20);
      
      pinLabel.setBounds(330,115,1000,80);
      pinLabel.setHorizontalAlignment(JLabel.LEFT);
      pinLabel.setForeground(Color.WHITE);
      pinLabel.setFont(new Font("Determination Mono",Font.BOLD,16));
      
      passTxtField.setBounds(500, 250, 150, 20);
      
      passLabel.setBounds(350,215,1000,80);
      passLabel.setHorizontalAlignment(JLabel.LEFT);
      passLabel.setForeground(Color.WHITE);
      passLabel.setFont(new Font("Determination Mono",Font.BOLD,16));
      
      warningLabel.setBounds(0,500,1000,80);
      warningLabel.setHorizontalAlignment(JLabel.CENTER);
      warningLabel.setForeground(Color.WHITE);
      warningLabel.setFont(new Font("Determination Mono",Font.BOLD,16));
      
      setupButton(submitButton,425,400);
      submitButton.addActionListener( new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               String pin = pinTxtField.getText();
               String password = passTxtField.getText();
               if (validateLogin(pin,password))
               {
                  player.setName(setUserName(pin));
                  if (password.equalsIgnoreCase("master"))
                  {
                     gameParameters.enableMaster();
                  }
                  showRegistrationFrame(frame);
               }
               else
               {
                  warningLabel.setText("One or both of your entries was incorrect. Try again");
                  pinTxtField.setText("");
                  passTxtField.setText("");
               }
            }
         }
      );
      
      setupButton(exitButton,425,470);
      exitButton.addActionListener( new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               showExitFrame(frame);
            }
         }
      );
      
      

      panel.setBackground(Color.BLACK);
      panel.setLayout(null);
      panel.add(warningLabel);
      panel.add(passLabel);
      panel.add(pinLabel);
      panel.add(pinTxtField);
      panel.add(passTxtField);
      panel.add(submitButton);
      panel.add(exitButton);
      
      frame.getContentPane().removeAll();
      frame.setTitle("Login");
      frame.add(panel);
      frame.setVisible(true); 
   }
/******************************************************************************

	NAME:          validateLogin
	DESCRIPTION:    
   
******************************************************************************/
   public boolean validateLogin(String pin, String password)
   {
      boolean answer = false;
      if((pin.equals("1111")||pin.equals("2222")||pin.equals("3333")||pin.equals("4444")||pin.equals("5555"))
         &&(password.equalsIgnoreCase("master")||password.equalsIgnoreCase("escape")))
      {
         answer = true;
      }
      return answer;
   }
/******************************************************************************

	NAME:          setUserName()
	DESCRIPTION:    
   
******************************************************************************/

   public String setUserName(String pin)
   {
      String answer = "";
      switch(pin)
      {
         case "1111": 
            answer = "Albert Einstein";
            break;
         case "2222":
            answer = "Marie Curie";
            break;
         case "3333":
            answer = "Roberto Cardenas";
            break;
         case "4444":
            answer = "Natalia Lafourcade";
            break;
         case "5555":
            answer = "Alex Turner";
            break;
      }
      return answer;
   }
/******************************************************************************

	NAME:          showExitFrame
	DESCRIPTION:    
   
******************************************************************************/
   public void showExitFrame(JFrame frame)
   {
      /////////////////////////////////////////////////////////////////////////////////////////

      //Local variable/Object declarations and definitions

      /////////////////////////////////////////////////////////////////////////////////////////
      
      JLabel labelFarewellOne = new JLabel("Thank you for visiting! And remember:");
      JLabel labelFarewellTwo = new JLabel("STAY DETERMINED!!!");
      JLabel labelSansAndPapyrus = new JLabel();
      JLabel labelFlowey = new JLabel();
      JLabel labelBlindDog = new JLabel();
      JLabel labelTemmy = new JLabel();
      JLabel labelMettaton = new JLabel();
      JPanel panel = new JPanel();
      
      /////////////////////////////////////////////////////////////////////////////////////////
      
      //Set labelFarewellOne properties
      labelFarewellOne.setForeground(Color.WHITE);
      labelFarewellOne.setFont(new Font("Determination Mono",Font.BOLD,25));
      labelFarewellOne.setBounds(0,30,1000,200);
      labelFarewellOne.setHorizontalAlignment(JLabel.CENTER);
      labelFarewellOne.setVerticalAlignment(JLabel.TOP);

      
      //Set labelFarewellTwo properties
      labelFarewellTwo.setForeground(Color.WHITE);
      labelFarewellTwo.setFont(new Font("Determination Mono",Font.BOLD,45));
      labelFarewellTwo.setBounds(0,0,1000,200);
      labelFarewellTwo.setHorizontalAlignment(JLabel.CENTER);
      
      //Set labelSansAndPapyrus properties
      labelSansAndPapyrus.setIcon(new ImageIcon(DM.editImage("mediaSansAndPapyrusGif.gif",250,190)));
      labelSansAndPapyrus.setBounds(0,0,1000,690);
      labelSansAndPapyrus.setHorizontalAlignment(JLabel.CENTER);
      labelSansAndPapyrus.setVerticalAlignment(JLabel.BOTTOM);
      
      //Set labelFlowey properties
      
      labelFlowey.setIcon(new ImageIcon(DM.editImage("mediaFloweyGif.gif",170,200)));
      labelFlowey.setBounds(5,0,1000,500);
      labelFlowey.setHorizontalAlignment(JLabel.LEFT);
      labelFlowey.setVerticalAlignment(JLabel.CENTER);
      
      //Set labelBlindDog properties
      
      labelBlindDog.setIcon(new ImageIcon("mediaBlindDogGif.gif"));
      labelBlindDog.setBounds(0,0,950,510);
      labelBlindDog.setHorizontalAlignment(JLabel.RIGHT);
      labelBlindDog.setVerticalAlignment(JLabel.CENTER);
      
      //Set labelTemmy properties
      
      labelTemmy.setIcon(new ImageIcon(DM.editImage("mediaTemmyGif.gif",180,180)));
      labelTemmy.setBounds(20,0,1000,680);
      labelTemmy.setHorizontalAlignment(JLabel.LEFT);
      labelTemmy.setVerticalAlignment(JLabel.BOTTOM);
      
      //Set labelMettaton properties
      
      labelMettaton.setIcon(new ImageIcon(DM.editImage("mediaMettatonGif.gif",190,190)));
      labelMettaton.setBounds(0,0,980,680);
      labelMettaton.setHorizontalAlignment(JLabel.RIGHT);
      labelMettaton.setVerticalAlignment(JLabel.BOTTOM);
      
      //Add components to panel
      panel.setLayout(null);
      panel.setBackground(Color.BLACK);
      panel.add(labelFarewellOne);
      panel.add(labelFarewellTwo);
      panel.add(labelSansAndPapyrus);
      panel.add(labelFlowey);
      panel.add(labelBlindDog);
      panel.add(labelTemmy);
      panel.add(labelMettaton);
      
      //Clean up JFrame, add new panel and set visible
      frame.getContentPane().removeAll();
      frame.setTitle("Farewell from Roberto's Escape from the Underground!!!");
      frame.add(panel);
      frame.setVisible(true); 
   }
/******************************************************************************

	NAME:          showRegistrationFrame
	DESCRIPTION:    
   
******************************************************************************/
   public void showRegistrationFrame(JFrame frame)
   {
      String[] astroSigns; 
      astroSigns = new String[] {"Aries","Taurus","Gemini","Cancer","Leo","Virgo","Libra","Scorpio","Sagittarius","Capricorn","Aquarius","Pisces"};
      JLabel greetingLabel, aliasLabel, genderLabel, astroSignLabel, birthYearLabel, depositLabel, confirmLabel;
      JTextField aliasTxtField, genderTxtField, birthYearTxtField, depositTxtField;
      JComboBox astroSignComboBox = new JComboBox(astroSigns);
      JPanel panel = new JPanel();
      JButton submitButton = new JButton("Submit");
      JButton continueButton = new JButton("Continue");
      JButton resetButton = new JButton("Reset");
      String playerName, playerAlias, playerGender, playerAstroSign, playerBirthYear, playerDeposit;
      
      playerName = player.getName();
      playerAlias = "";
      playerGender = "";
      playerAstroSign = "";
      playerBirthYear = "";
      playerDeposit = "";
      
      greetingLabel = new JLabel("Why hello there "+playerName+". Could you fill out this form please?");
      aliasLabel = new JLabel("Enter your preferred nickname:");
      genderLabel= new JLabel("Enter your gender:");
      astroSignLabel= new JLabel("Enter your astrological sign:");
      birthYearLabel= new JLabel("Enter your birth year:");
      depositLabel= new JLabel("Enter the amount fo money you want to deposit:");
      confirmLabel= new JLabel("");
      
      aliasTxtField = new JTextField();
      genderTxtField = new JTextField();
      birthYearTxtField = new JTextField();
      depositTxtField = new JTextField();
      
      greetingLabel.setBounds(0,60,1000,700);
      greetingLabel.setHorizontalAlignment(JLabel.CENTER);
      greetingLabel.setVerticalAlignment(JLabel.TOP);
      greetingLabel.setForeground(Color.WHITE);
      greetingLabel.setFont(new Font("Determination Mono",Font.BOLD,16));
     
      setupRegistrationLabel(aliasLabel, 150);
      aliasTxtField.setBounds(560,182,150,20);
      
      setupRegistrationLabel(genderLabel, 200);
      genderTxtField.setBounds(560,232,150,20);
      
      setupRegistrationLabel(astroSignLabel, 250);
      astroSignComboBox.setBounds(560,282,150,20);
      
      setupRegistrationLabel(birthYearLabel, 300);
      birthYearTxtField.setBounds(560,332,150,20);
      
      setupRegistrationLabel(depositLabel, 350);
      depositTxtField.setBounds(560,382,150,20);
      
      confirmLabel.setBounds(0,450,1000,300);
      confirmLabel.setHorizontalAlignment(JLabel.CENTER);
      confirmLabel.setVerticalAlignment(JLabel.TOP);
      confirmLabel.setForeground(Color.WHITE);
      confirmLabel.setFont(new Font("Determination Mono",Font.BOLD,16));
      
      setupButton(submitButton, 250, 620);
      submitButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               player.setAlias(aliasTxtField.getText());
               player.setGender(genderTxtField.getText());
               player.setAstrologicalSign(astroSignComboBox.getSelectedItem().toString());
               player.setBirthYear(Integer.parseInt(birthYearTxtField.getText()));
               player.setAccountBalance(Double.parseDouble(depositTxtField.getText()));
               confirmLabel.setText(player.getName()+" "+player.getAlias()+" "+player.getGender()
                  +" "+player.getAstrologicalSign()+" "+player.getBirthYear()+" "+player.getAccountBalance());
            }
         }
      );
      
      setupButton(continueButton,425,620);
      continueButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               showFeatureSelectFrame(frame);
            }
         }
      );
      
      setupButton(resetButton, 600, 620);
      resetButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               aliasTxtField.setText("");
               genderTxtField.setText("");
               birthYearTxtField.setText("");
               depositTxtField.setText("");
            }
         }
      );
      
      panel.setLayout(null);
      panel.setBackground(Color.BLACK);
      panel.add(confirmLabel);
      panel.add(submitButton);
      panel.add(continueButton);
      panel.add(resetButton);
      panel.add(astroSignComboBox);
      panel.add(aliasTxtField);
      panel.add(genderTxtField);
      panel.add(birthYearTxtField);
      panel.add(depositTxtField);
      panel.add(greetingLabel);
      panel.add(aliasLabel);
      panel.add(genderLabel);
      panel.add(astroSignLabel);
      panel.add(birthYearLabel);
      panel.add(depositLabel);
      
      frame.getContentPane().removeAll();
      frame.setTitle("Registration");
      frame.add(panel);
      frame.setVisible(true);
      

      
   }
/******************************************************************************

	NAME:          setupRegistrationLabel
	DESCRIPTION:    
   
******************************************************************************/
   public void setupRegistrationLabel(JLabel label, int row)
   {
      setupLabel(label,0,row);
   }

/******************************************************************************

	NAME:          showFeatureSelectFrame
	DESCRIPTION:    
   
******************************************************************************/
   public void showFeatureSelectFrame(JFrame frame)
   {
      JPanel panel = new JPanel();
      JLabel typeLabel = new JLabel("Player Type");
      JLabel costLabel = new JLabel("Extra Features ($1.25 per unit)");
      JRadioButton miniRadioButton = new JRadioButton("$2.50 Lesser Doge (ages under 4)");
      JRadioButton juniorRadioButton = new JRadioButton("$5.00 Greater Doge (ages 4-12)");
      JRadioButton powerRadioButton = new JRadioButton("$7.50 Angsty Skeleton (ages 13-17)");
      JRadioButton extremeRadioButton = new JRadioButton("$9.75 Lazy Bones (ages 18 and above)");
      JCheckBox treasureCheckBox = new JCheckBox("Extra Moldy Spaghetti bowl");
      JCheckBox monsterCheckBox = new JCheckBox("Extra Monster");
      JCheckBox keyCheckBox = new JCheckBox("Extra Key");
      JButton submitButton = new JButton("Submit");
      JButton exitButton = new JButton("Exit");
       
      typeLabel.setBounds(0,0,1000,80);
      typeLabel.setHorizontalAlignment(JLabel.CENTER);
      typeLabel.setFont(new Font("Determination Mono",Font.BOLD,16));
      typeLabel.setForeground(Color.WHITE);
      
      costLabel.setBounds(0,280,1000,80);
      costLabel.setHorizontalAlignment(JLabel.CENTER);
      costLabel.setFont(new Font("Determination Mono",Font.BOLD,16));
      costLabel.setForeground(Color.WHITE);
      
      setupRadioButton(miniRadioButton, 350,100 );
      setupRadioButton(juniorRadioButton, 350,150 );
      setupRadioButton(powerRadioButton, 350,200 );
      setupRadioButton(extremeRadioButton, 350,250 );
      
      setupCheckBox(treasureCheckBox,350,370);
      setupCheckBox(monsterCheckBox, 350,420);
      setupCheckBox(keyCheckBox,350,470);
      
      ButtonGroup group = new ButtonGroup();
      group.add(miniRadioButton);
      group.add(juniorRadioButton);
      group.add(powerRadioButton);
      group.add(extremeRadioButton);
      
      setupButton(submitButton,283,580);
      submitButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               double ageFee = 0;
               String playerType = "";
               if (miniRadioButton.isSelected())
               {
                  ageFee = 2.5;
                  playerType = "Lesser Doge";
               }
               else if (juniorRadioButton.isSelected())
               {
                  ageFee = 5.0;
                  playerType = "Greater Doge";
               }
               else if (powerRadioButton.isSelected())
               {
                  ageFee = 7.5;
                  playerType = "Angsty Skeleton";
               }
               else if (extremeRadioButton.isSelected())
               {
                  ageFee = 9.75;
                  playerType = "Lazy Bones";
               }
               else
               {
                  ageFee = 0;
                  playerType = "";
               }
               if (treasureCheckBox.isSelected())
                  gameParameters.enableExtraTreasure();
                  
               if (keyCheckBox.isSelected())
                  gameParameters.enableExtraKey();
                  
               if (monsterCheckBox.isSelected())
                  gameParameters.enableExtraMonster();
               showRegistrationInfoFrame(frame, ageFee, playerType);
            }
         }
      );
      setupButton(exitButton,567,580);
      exitButton.addActionListener( new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               showExitFrame(frame);
            }
         }
      );
      
      panel.setLayout(null);
      panel.setBackground(Color.BLACK);
      
      panel.add(juniorRadioButton);
      panel.add(miniRadioButton);
      panel.add(powerRadioButton);
      panel.add(extremeRadioButton);
      panel.add(typeLabel);
      panel.add(treasureCheckBox);
      panel.add(monsterCheckBox);
      panel.add(keyCheckBox);
      panel.add(costLabel);
      panel.add(exitButton);
      panel.add(submitButton);
      
      frame.getContentPane().removeAll();
      frame.setTitle("Feature Selection");
      frame.add(panel);
      frame.setVisible(true);
   }
/******************************************************************************

	NAME:          showRegistrationInfoFrame
	DESCRIPTION:    
   
******************************************************************************/

   public void showRegistrationInfoFrame(JFrame frame, double ageFee, String playerType)
   {
      JTextArea textArea;
      JPanel panel = new JPanel();
      JButton agreeButton = new JButton("I Agree");
      int extraFeatures = getExtraFeaturesAmount();
      double subtotal = extraFeatures*1.25 + ageFee;
      double fee = subtotal*0.1;
      double total = subtotal + fee;
      String text = "So, "+player.getName()+", aka "+player.getAlias()+", your\n"
                    +"registration fees are only:\n"
                    +"\t "+ageFee+" --Basic Registration fee as a "+playerType+"\n"
                    +"\t "+(extraFeatures*1.25)+" per feature for "+extraFeatures+" Extra Game Features of\n"
                    +"\t\t "+getExtraFeatures()+"\n"
                    +"\t ===\n"
                    +"\t "+subtotal+" --Subtotal\n"
                    +"\t "+fee+" --Rounded ESCAPE Service Fee of 10%\n"
                    +"   ===\n"
                    +"\t "+total+" --Total ESCAPE Registration Fee";
      
      textArea = new JTextArea(text);
      setupTextArea(textArea,210,150);
      
      setupButton(agreeButton,425,500);
      agreeButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            showAccountSummaryFrame(frame, total);
         }
      }
      );
      
      panel.setLayout(null);
      panel.setBackground(Color.BLACK);
      panel.add(textArea);
      panel.add(agreeButton);
      
      frame.getContentPane().removeAll();
      frame.setTitle("Registration Information");
      frame.add(panel);
      frame.setVisible(true);
                    
   }
   public void showAccountSummaryFrame(JFrame frame, double total)
   {
      JTextArea textArea;
      JPanel panel = new JPanel();
      double initialBalance = player.getAccountBalance();
      double currentBalance = initialBalance - total;
      player.setAccountBalance(currentBalance);
      JButton continueButton = new JButton("Continue");
      String text = "UNDERTALE: ESCAPE FORM THE UNDERGROUND ACCOUNT BALANCE\n"
                   +"======================================================\n"
                   +"\nSummary of Account balance for "+player.getName()+", aka "+player.getAlias()+":\n"
                   +"\n"+initialBalance+" - Amount deposited into your account\n"
                   +total+" - Total ESCAPE Registration Fee\n"
                   +"======\n"
                   +currentBalance+" - Current Account Balance\n"
                   +"\nHAVE A NICE DAY...";
      textArea = new JTextArea(text);
      setupTextArea(textArea,0,0);
      
      setupButton(continueButton, 425,500);
      continueButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            showPlayGameFrame(frame);
         }
      }
      );
      
      panel.setLayout(null);
      panel.setBackground(Color.BLACK);
      panel.add(continueButton);
      panel.add(textArea);
      
      frame.getContentPane().removeAll();
      frame.setTitle("Account Balance");
      frame.add(panel);
      frame.setVisible(true);
      
   }
/******************************************************************************

	NAME:          showPlayGameFrame
	DESCRIPTION:    
   
******************************************************************************/

   public void showPlayGameFrame(JFrame frame)
   {
      JPanel panel = new JPanel();
      Game game = new Game(frame, player);
      JButton instructionsButton = new JButton("Instructions");
      JButton playButton = new JButton("Play");
      JButton historyButton = new JButton("History");
      JButton exitButton = new JButton("Exit");
      JButton solutionButton = new JButton("Solution");
      
      setupButton(playButton, 425,100);
      playButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            game.play();
         }
      }
      );
      panel.setLayout(null);
      panel.setBackground(Color.BLACK);
      panel.add(playButton);
      
      frame.getContentPane().removeAll();
      frame.setTitle("Play Game");
      frame.add(panel);
      frame.setVisible(true);
      
   }
/******************************************************************************

	NAME:          getExtraFeaturesAmount
	DESCRIPTION:    
   
******************************************************************************/

   public int getExtraFeaturesAmount()
   {
      int extraFeatures =0;
      
      if(gameParameters.validateExtraMonster())
         extraFeatures++;
         
      if(gameParameters.validateExtraKey())
         extraFeatures++;
         
      if(gameParameters.validateExtraTreasure())
         extraFeatures++;
         
      return extraFeatures;
   }
/******************************************************************************

	NAME:          getExtraFeatures
	DESCRIPTION:    
   
******************************************************************************/

   public String getExtraFeatures()
   {
      String extraFeatures = "";
      if(gameParameters.validateExtraMonster())
         extraFeatures += "Monster ";
         
      if(gameParameters.validateExtraKey())
         extraFeatures += "Key ";
         
      if(gameParameters.validateExtraTreasure())
         extraFeatures += "Treasure";
         
      return extraFeatures;
      
   }
/******************************************************************************

	NAME:          setupButton
	DESCRIPTION:    
   
******************************************************************************/

   public void setupButton(JButton button, int x, int y)
   {
      button.setBounds(x,y,150,30);
      button.setFont(new Font ("Determination Mono", Font.PLAIN, 18));
      button.setBackground(Color.BLACK);
      button.setForeground(Color.WHITE);
      button.setBorder(BorderFactory.createLineBorder(Color.WHITE));
      button.setFocusPainted(false);
   }
/******************************************************************************

	NAME:          setupTextArea
	DESCRIPTION:    
   
******************************************************************************/

   public void setupTextArea(JTextArea textArea, int x, int y)
   {
      textArea.setBounds(x,y,1000, 300);
      textArea.setEnabled(false);
      textArea.setBackground(Color.BLACK);
      textArea.setForeground(Color.WHITE);
      textArea.setFont(new Font("Determination Mono", Font.PLAIN, 16));
   }
/******************************************************************************

	NAME:          setupRadioButton
	DESCRIPTION:    
   
******************************************************************************/

   public void setupRadioButton(JRadioButton button, int x, int y)
   {
      button.setBounds(x,y,500,30);
      button.setBackground(Color.BLACK);
      button.setFont(new Font("Determination Mono",Font.PLAIN,14));
      button.setForeground(Color.WHITE);
   }
/******************************************************************************

	NAME:         setupCheckBox
	DESCRIPTION:    
   
******************************************************************************/

   public void setupCheckBox(JCheckBox button, int x, int y)
   {
      button.setBounds(x,y,500,30);
      button.setBackground(Color.BLACK);
      button.setFont(new Font("Determination Mono",Font.PLAIN,14));
      button.setForeground(Color.WHITE);
   }
/******************************************************************************

	NAME:         setupLabel
	DESCRIPTION:    
   
******************************************************************************/

   public void setupLabel(JLabel label, int x, int y)
   {
      label.setBounds(x,y,550,80);
      label.setHorizontalAlignment(JLabel.RIGHT);
      label.setForeground(Color.WHITE);
      label.setFont(new Font("Determination Mono",Font.PLAIN,15));
   }
/******************************************************************************

	NAME:         editImage
	DESCRIPTION:    
   
******************************************************************************/

   public Image editImage(String imageName, int width, int height)
   {
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

      //Local Object declarations and definitions

      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
      Image image = new ImageIcon(imageName).getImage().getScaledInstance(width,height,java.awt.Image.SCALE_DEFAULT);
      
      //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
      return image;
   }
}
