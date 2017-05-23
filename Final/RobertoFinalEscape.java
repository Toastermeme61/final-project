import javax.swing.*;//JFrame, JLabel, JButton, JOPtionPane
import java.util.*;//Date
import java.awt.*;//Color, Font
import java.awt.event.*;//ActionListener
import java.text.NumberFormat; 
public class RobertoFinalEscape
{
   NumberFormat currencyFormater = NumberFormat.getCurrencyInstance();
   DialogueManager DM = new DialogueManager();
   Player player =  new Player();
   GameParameters gameParameters = new GameParameters();
   History gameHistory;
   public static void main(String[] args)
   {
      JFrame frameMain = new JFrame("Undertale");
      RobertoFinalEscape finalEscape = new RobertoFinalEscape();
      frameMain.setSize(1000,720);
      frameMain.setLocationRelativeTo(null);
      frameMain.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      frameMain.setResizable(false);
      finalEscape.showWelcomeFrame(frameMain);
      //finalEscape.showPlayGameFrame(frameMain);
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
               player.setName("Panfilo Filomeno");
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
      JLabel textLabel = new JLabel("Purpose");
      JButton backButton = new JButton("Back");
      JPanel panel =  new JPanel();
      
      setupLabel(textLabel,20,50);
      textLabel.setFont(new Font("Determination Mono", Font.BOLD, 30));
      
      feesLabel.setIcon(new ImageIcon("mediaFees.png"));
      feesLabel.setBounds(0,160,1000,700);
      feesLabel.setHorizontalAlignment(JLabel.CENTER);
      feesLabel.setVerticalAlignment(JLabel.TOP);
      
      purposeLabel.setIcon(new ImageIcon("mediaPurpose.png"));
      purposeLabel.setBounds(0,375,1000,700);
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
      panel.add(textLabel);
      
      
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
      JPasswordField passTxtField = new JPasswordField();
      //JTextField passTxtField = new JTextField();
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
               String password = "";
               
               char[] passwordArray = passTxtField.getPassword();
               for(int x = 0;x<passwordArray.length;x++)
                  password += Character.toString(passwordArray[x]);
                  
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
               player.setName("Sugar Daddy Bait");
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
      
      JLabel labelFarewellOne = new JLabel("Thank you for visiting "+player.getName()+"! And remember:");
      JLabel labelFarewellTwo = new JLabel("STAY DETERMINED!!!");
      JLabel labelSansAndPapyrus = new JLabel();
      JLabel labelFlowey = new JLabel();
      JLabel labelBlindDog = new JLabel();
      JLabel labelTemmy = new JLabel();
      JLabel labelMettaton = new JLabel();
      JPanel panel = new JPanel();
      JButton idInfoButton = new JButton("ID Info");
      JButton exitButton = new JButton("Exit To Desktop");
      
      
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
      
      setupButton(idInfoButton, 425, 250);
      idInfoButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            //showIdInfoFrame();
         }
      }
      );
      
      setupButton(exitButton, 0, 0);
      exitButton.setBounds(400,350,200,30);
      exitButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            System.exit(0);
         }
      }
      );
      
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
      panel.add(idInfoButton);
      panel.add(exitButton);
      
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
      JLabel greetingLabel, aliasLabel, genderLabel, astroSignLabel, birthYearLabel, depositLabel;
      JTextPane confirmArea = new JTextPane();
      JTextField aliasTxtField, birthYearTxtField, depositTxtField;
      JComboBox astroSignComboBox = new JComboBox(astroSigns);
      JRadioButton maleRadioButton = new JRadioButton("Dude",true);
      JRadioButton femaleRadioButton = new JRadioButton("Dudette");
      ButtonGroup group = new ButtonGroup();
      JPanel panel = new JPanel();
      JButton submitButton = new JButton("Submit");
      JButton continueButton = new JButton("Continue");
      JButton resetButton = new JButton("Reset");
      String playerName;
      
      playerName = player.getName();
      
      
      greetingLabel = new JLabel("Why hello there "+playerName+". Could you fill out this form please?");
      aliasLabel = new JLabel("Enter your preferred nickname:");
      genderLabel= new JLabel("Enter your gender:");
      astroSignLabel= new JLabel("Enter your astrological sign:");
      birthYearLabel= new JLabel("Enter your birth year:");
      depositLabel= new JLabel("Enter the amount fo money you want to deposit:");
      
      
      aliasTxtField = new JTextField();
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
      setupRadioButton(maleRadioButton, 560, 232);
      maleRadioButton.setBounds(560, 232, 60, 30);
      setupRadioButton(femaleRadioButton, 620, 232);
      group.add(maleRadioButton);
      group.add(femaleRadioButton);
      
      setupRegistrationLabel(astroSignLabel, 250);
      astroSignComboBox.setBounds(560,282,150,20);
      
      setupRegistrationLabel(birthYearLabel, 300);
      birthYearTxtField.setBounds(560,332,150,20);
      
      setupRegistrationLabel(depositLabel, 350);
      depositTxtField.setBounds(560,382,150,20);
      
      setupTextArea(confirmArea, 0,0);
      confirmArea.setBounds(220,460,600,150);
      
      
      setupButton(submitButton, 250, 620);
      submitButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               String gender = "";
               if(maleRadioButton.isSelected())
               {
                  gender = "Dude";
               }
               else if(femaleRadioButton.isSelected())
               {
                  gender = "Dudette";
               }
               else
               {
                  gender = "";
               }
               player.setAlias(aliasTxtField.getText());
               player.setGender(gender);
               player.setAstrologicalSign(astroSignComboBox.getSelectedItem().toString());
               player.setBirthYear(Integer.parseInt(birthYearTxtField.getText()));
               player.setAccountBalance(Double.parseDouble(depositTxtField.getText()));
               confirmArea.setText("So "+player.getName()+", aka "+player.getAlias()+",\nyou're a "+player.getGender()+" and a "+player.getAstrologicalSign()+" born in "+player.getBirthYear()+"?\nI never would have guessed, "
                                 +"I'm a transgender Capricorn myself.\nCool! Looks like your deposit for "
                                 +currencyFormater.format(player.getAccountBalance())+" went through! ");
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
               maleRadioButton.setSelected(true);
               
               birthYearTxtField.setText("");
               depositTxtField.setText("");
               confirmArea.setText("");
            }
         }
      );
      
      if (gameParameters.validateMaster())
         {
            aliasTxtField.setText("Dennis the Menace");
            
            birthYearTxtField.setText("1997");
            depositTxtField.setText("1234");
         }
      
      panel.setLayout(null);
      panel.setBackground(Color.BLACK);
      panel.add(maleRadioButton);
      panel.add(femaleRadioButton);
      panel.add(confirmArea);
      panel.add(submitButton);
      panel.add(continueButton);
      panel.add(resetButton);
      panel.add(astroSignComboBox);
      panel.add(aliasTxtField);
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
      JRadioButton extremeRadioButton = new JRadioButton("$9.75 Lazy Bones (ages 18 and above)",true);
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
      JTextPane textArea;
      JPanel panel = new JPanel();
      JButton agreeButton = new JButton("I Agree");
      int extraFeatures = getExtraFeaturesAmount();
      double subtotal = extraFeatures*1.25 + ageFee;
      double fee = subtotal*0.1;
      double total = subtotal + fee;
      String text = "So, "+player.getName()+", aka "+player.getAlias()+", your\n"
                    +"registration fees are only:\n"
                    +"\t "+currencyFormater.format(ageFee)+" --Basic Registration fee as a "+playerType+"\n"
                    +"\t "+currencyFormater.format((extraFeatures*1.25))+" per feature for "+extraFeatures+" Extra Game Features of\n"
                    +"\t\t "+getExtraFeatures()+"\n"
                    +"\t ===\n"
                    +"\t "+currencyFormater.format(subtotal)+" --Subtotal\n"
                    +"\t "+currencyFormater.format(fee)+" --Rounded ESCAPE Service Fee of 10%\n"
                    +"   ===\n"
                    +"\t "+currencyFormater.format(total)+" --Total ESCAPE Registration Fee";
      
      textArea = new JTextPane();
      textArea.setText(text);
      setupTextArea(textArea,230,150);
      
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
      gameHistory = new History(player);
      JTextPane textArea;
      JPanel panel = new JPanel();
      double initialBalance = player.getAccountBalance();
      double currentBalance = initialBalance - total;
      player.setAccountBalance(currentBalance);
      JButton continueButton = new JButton("Continue");
      String text = "UNDERTALE: ESCAPE FORM THE UNDERGROUND ACCOUNT BALANCE\n"
                   +"======================================================\n"
                   +"\nSummary of Account balance for "+player.getName()+", \naka "+player.getAlias()+":\n"
                   +"\n"+currencyFormater.format(initialBalance)+" - Amount deposited into your account\n"
                   +currencyFormater.format(total)+" - Total ESCAPE Registration Fee\n"
                   +"======\n"
                   +currencyFormater.format(currentBalance)+" - Current Account Balance\n"
                   +"\nHAVE A NICE DAY...";
      textArea = new JTextPane();
      textArea.setText(text);
      setupTextArea(textArea,250,150);
      
      setupButton(continueButton, 425,500);
      continueButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            gameHistory = new History(player);
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
      //History gameHistory = new History(player);
      Game game = new Game(frame, player, gameHistory, gameParameters);
      JButton instructionsButton = new JButton("Instructions");
      JButton playButton = new JButton("Play");
      JButton historyButton = new JButton("History");
      JButton exitButton = new JButton("Exit");
      JButton solutionButton = new JButton("Solution");
      
      player.setGame(game);
      
      setupButton(playButton, 425,200);
      playButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            game.reset();
            game.play();
         }
      }
      );
      
      setupButton(instructionsButton, 425, 100);
      instructionsButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            showInstructionsFrame();
         }
      }
      );
      
      setupButton(historyButton, 425, 300);
      historyButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            showHistoryFrame(frame);
         }
      }
      );
      
      setupButton(exitButton, 425, 400);
      exitButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            showExitFrame(frame);
         }
      }
      );
      
      setupButton(solutionButton, 425, 500);
         
      solutionButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            //showSolutionFrame();
         }
      }
      );
      
      panel.setLayout(null);
      panel.setBackground(Color.BLACK);
      panel.add(playButton);
      panel.add(instructionsButton);
      panel.add(historyButton);
      panel.add(exitButton);
      if(gameParameters.validateMaster())
      {
         panel.add(solutionButton);
      }
      
      frame.getContentPane().removeAll();
      frame.setTitle("Play Game");
      frame.add(panel);
      frame.setVisible(true);
      
   }
/******************************************************************************

	NAME:          showInstructionsFrame()
	DESCRIPTION:    
   
******************************************************************************/

   public void showInstructionsFrame()
   {
      JFrame frame = new JFrame();
      JPanel panel = new JPanel();
      JTextPane textArea = new JTextPane();
      JButton backButton = new JButton("Back");
      
      textArea.setText("Hello Bitch");
      
      setupTextArea(textArea,50,200);
      setupButton(backButton, 175, 500);
      backButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            frame.setVisible(false);
            frame.dispose();
         }
      }
      );
      
      panel.setLayout(null);
      panel.setBackground(Color.BLACK);
      panel.add(textArea);
      panel.add(backButton);
      
      frame.add(panel);
      frame.setSize(500,598);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }
   public void showHistoryFrame(JFrame frame)
   {
      JPanel panel= new JPanel();
      JButton historyButton = new JButton("Log");
      JButton saveButton = new JButton ("Save to disk");
      JButton loadButton = new JButton ("Load from disk");
      JButton backButton = new JButton("Back");
      
      setupButton(historyButton, 425, 150);
      historyButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            showHistory();
         }
      }
      );
      setupButton(saveButton, 425, 250);
      saveButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            
         }
      }
      );
      setupButton(loadButton, 425, 350);
      loadButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            
         }
      }
      );
      setupButton(backButton, 425, 450);
      backButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            showPlayGameFrame(frame);  
         }
      }
      );
      panel.setLayout(null);
      panel.setBackground(Color.BLACK);
      panel.add(historyButton);
      panel.add(saveButton);
      panel.add(loadButton);
      panel.add(backButton);
      
      frame.getContentPane().removeAll();
      frame.setTitle("History");
      frame.add(panel);
      frame.setVisible(true);
      
      
   }
   public void showHistory()
   {
      String name = gameHistory.getName();
      int wins = gameHistory.getWins();
      int losses = gameHistory.getLosses();
      JFrame frame = new JFrame();
      JPanel panel = new JPanel();
      JTextPane textArea = new JTextPane();
      JButton backButton = new JButton("Back");
      JLabel titleLabel = new JLabel(name+"'s ESCAPE History");
      JLabel initialLabel = new JLabel();
      
      setupLabel(titleLabel,0,30);
      
      textArea.setText("Wins: "+wins+"\nLosses: "+losses+"\nGame History:\n"+gameHistory.getGameLogsAsString());
      
      setupTextArea(textArea,0,80);
      setupButton(backButton, 350, 500);
      backButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            frame.setVisible(false);
            frame.dispose();
         }
      }
      );
      
      panel.setLayout(null);
      panel.setBackground(Color.BLACK);
      panel.add(textArea);
      panel.add(titleLabel);
      panel.add(backButton);
      
      frame.add(panel);
      frame.setSize(850,598);
      frame.setLocationRelativeTo(null);
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

   public void setupTextArea(JTextPane textArea, int x, int y)
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
