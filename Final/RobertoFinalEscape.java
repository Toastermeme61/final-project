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
   		File Name			:  	RobertoFinalEscape

***************************************************************


                     PROGRAM DESCRIPTION
   Really cool ESCAPE game. You play  as a child trying to escape the
   undergorund. In order to escape you need to find a key and open the final door.
   To find keys/trasures and doors you need to click on the frame until you
   find them. Sometimes you might encounter monsters but you can bribe them, feed them
   or run away to safely escape. Good LUCK!
                     
***************************************************************
                     LIST OF METHODS
   showWelcomeFrame()
   showOverviewFrame()
   showLoginFrame()
   validateLogin()
   setUserName()
   showExitFrame()
   showIdinfoFrame()
   displayTextFrame()
   showRegistrationFrame()
   setupRegistrationLabel()
   showFeatureSelecFrame()
   showRegistrationInfoFrame()
   showAccountSummaryFrame()
   showPlayGameFrame
   showSolutionFrame
   showInstructionsFrame
   showHistoryFrame
   showHistory
   getExtraFeaturesAmount
   getExtraFeatures
   setupButton()
   setupTextArea()
   setupRadioButton()
   setupCheckBox()
   setupLabel()
   editImage()
   
   
***************************************************************
                          CREDITS
     Acknowledge those who helped you and whom you helped    
     Remember the 'triangle of learning':                   
         *Thanks for assistance and inspiration from:                			
                -www.tutorialspoint.com/java                          
                -www.stackoverflow.com                                
                -Professor Forman                                    
         *Thanks for the opportunity to assist and inspire     
                -Yvan
      

***************************************************************
                           MEDIA 
    *Music: 
       -All audio files taken from the undertale main folder                
    *Pictures:                                                            
        -Undertale TitleScreen:                                              
             http://fontmeme.com/images/undertale-font.jpg                      
        -Sans Gif:                                                           
             http://vignette2.wikia.nocookie.net/undertale/images/2/29/Animaci% 
                  C3%B3n_Sans.gif/revision/latest?cb=20151125200713&path-prefix=es   
        -Papyrus Gif:                                                        
             http://pa1.narvii.com/6168/3000e51c2808e347abfdaa789ea48e81379ed25 
                  0_hq.gif   
        -Sans and Papyrus Gif:                                              
             https://media.tenor.co/images/9dbb6676d6fe8ca44adc62f097646480/raw 
        -Temmy Gif:                                                          
             http://giphy.com/gifs/undertale-vrpg7CCZERhsY                      
        -Blind Doggo Gif                                                     
             http://giphy.com/gifs/undertale-b78LAtUEw9DBS                      
        -Mettaton Gif:                                                       
             http://vignette1.wikia.nocookie.net/undertale/images/5/58/Mettato  
                  n.gif/revision/latest?cb=20151111052225                            
        -Heart Icon:                                                         
             http://img03.deviantart.net/9855/i/2016/130/b/7/undertale___pixel_ 
                  heart_thingy_by_aspalax-da1zkgz.png 
        -Flowey Gif:                                                         
             http://vignette2.wikia.nocookie.net/villains/images/0/09/Flowey_th 
                  e_flower.gif/revision/latest?cb=20160128235934                     
    *Font                                                                 
        -Undertale Font: Determination Mono                                  
             https://www.behance.net/gallery/31268855/Determination-Better-U    
                  ndertale-Font                                                      
              
         
***************************************************************/

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
               //jukeBox.pressOk();
               showOverviewFrame(frame);
            }
         }
      );
      
      setupButton(loginButton,425,320);
      loginButton.addActionListener( new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               //jukeBox.pressOk();
               showLoginFrame(frame);
            }
         }
      );
      
      setupButton(exitButton,625,320);
      exitButton.addActionListener( new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               //jukeBox.pressOk();
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
      ////jukeBox.playMainTheme();
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
               //jukeBox.pressOk();
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
               //jukeBox.pressOk();
            }
         }
      );
      
      setupButton(exitButton,425,470);
      exitButton.addActionListener( new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               //jukeBox.pressOk();
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
      JTextPane textPane = new JTextPane();
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
            //jukeBox.pressOk();
            showIdInfoFrame();
         }
      }
      );
      
      setupButton(exitButton, 0, 0);
      exitButton.setBounds(400,350,200,30);
      exitButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            //jukeBox.pressOk();
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
   public void showIdInfoFrame()
   {
      String strIDInfo = "                                                \n"
                        +"       Programmer          :  Cardenas Roberto  \n"               
   		               +"       Assignment#         :  Final Escape      \n"              	
   		               +"       Assignment Name     :  Final Escape      \n"
   		               +"       Course # and Title  :  CISC 190 - Java   \n"  	
   		               +"       Class Meeting Time  :  TTH 1:00 – 4:05   \n"
  		                  +"       Instructor          :  Professor Forman  \n"
  		                  +"       Hours               :  44.5              \n"
   		               +"       Difficulty          :  10/10             \n"
   		               +"       Completion Date     :  05/24/2017        \n"
   		               +"       File Name           :  RobertoFinalEscape\n";
      String strCredits = "                                                           \n"
                         +"  Acknowledge those who helped you and whom you helped     \n"
                         +"    Remember the 'triangle of learning':                   \n"
                         +"    *Thanks for assistance and inspiration from:           \n"         			
                         +"     -www.tutorialspoint.com/java                          \n"
                         +"     -www.stackoverflow.com                                \n"
                         +"     -Professor Forman                                     \n"
                         +"    *Thanks for the opportunity to assist and inspire      \n"
                         +"     -Yvan";
      String strMediaOne = " *Music:                                                               \n"
                          +"  -All audio files taken from the undertale main folder                \n"
                          +" *Pictures:                                                            \n"
                          +"  -Undertale TitleScreen:                                              \n"
                          +"    http://fontmeme.com/images/undertale-font.jpg                      \n"
                          +"  -Sans Gif:                                                           \n"
                          +"    http://vignette2.wikia.nocookie.net/undertale/images/2/29/Animaci% \n"
                          +"    C3%B3n_Sans.gif/revision/latest?cb=20151125200713&path-prefix=es   \n"
                          +"  -Papyrus Gif:                                                        \n"
                          +"    http://pa1.narvii.com/6168/3000e51c2808e347abfdaa789ea48e81379ed25 \n"
                          +"    0_hq.gif   ";
      String strMediaTwo = "  -Sans and Papyrus Gif:                                               \n"
                          +"    https://media.tenor.co/images/9dbb6676d6fe8ca44adc62f097646480/raw \n"
                          +"  -Temmy Gif:                                                          \n"
                          +"    http://giphy.com/gifs/undertale-vrpg7CCZERhsY                      \n"
                          +"  -Blind Doggo Gif                                                     \n"
                          +"    http://giphy.com/gifs/undertale-b78LAtUEw9DBS                      \n"
                          +"  -Mettaton Gif:                                                       \n"
                          +"    http://vignette1.wikia.nocookie.net/undertale/images/5/58/Mettato  \n"
                          +"    n.gif/revision/latest?cb=20151111052225                            \n"
                          +"  -Heart Icon:                                                         \n"
                          +"    http://img03.deviantart.net/9855/i/2016/130/b/7/undertale___pixel_ \n"
                          +"    heart_thingy_by_aspalax-da1zkgz.png                                \n";
                          
                          
      String strMediaThree = "  -Flowey Gif:                                                         \n"
                            +"    http://vignette2.wikia.nocookie.net/villains/images/0/09/Flowey_th \n"
                            +"    e_flower.gif/revision/latest?cb=20160128235934                     \n"
                            +" *Font                                                                 \n"
                            +"  -Undertale Font: Determination Mono                                  \n"
                            +"    https://www.behance.net/gallery/31268855/Determination-Better-U    \n"
                            +"    ndertale-Font                                                      \n";
                            

      String strStarsSwinging =   "         Stars          \n "
                                 +" 1.- #83 Reset Button        \n"
                                 +" 2.- #85 Radio button for the gender info \n"
                                 +" 3.- #86 JComboBox for astrological sign  \n"
                                 +" 4.- #103 Handle player default alias \n"
                                 +" 5.- #2 Quit button in all game frames\n"
                                 +" 6.- #11 Give player option to add cash mid game\n"
                                 +" 7.- #15 Possibility to bribe creature\n"
                                 +" 8.- #16 Possibility to feed creature\n"
                                 +" 9.- #18 Key dissapears after it has been found"
                                 +" 10.- #22 Add 2 extra indoor JFrame(2)\n"
                                 +" 11.-#56#57 Use LayoutManager panel.setLayout(null)(2)\n"
                                 +" 12.-DD Advanced feature. Used JTextPane\n"
                                 +" 13.-EE Add pizzaz: Created my own 'JOptionPane' for the game";
      
      
      
      
      
     
      displayTextFrame(strStarsSwinging,1);
      displayTextFrame(strMediaThree,0);
      displayTextFrame(strMediaTwo,0);
      displayTextFrame(strMediaOne,0);
      displayTextFrame(strCredits,0);
      displayTextFrame(strIDInfo,0);
      
   }
   public void displayTextFrame(String text, int indicator)
   {
      JTextPane pane = new JTextPane();
      JFrame frame = new JFrame();
      JPanel panel = new JPanel();
      JButton okButton = new JButton("Ok");
      pane.setText(text);
      setupTextArea(pane,50,50);
      
      setupButton(okButton, 100,400);
      okButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            frame.setVisible(false);
            //next.setVisible(true);
            frame.dispose();
            if (indicator ==1)
               System.exit(0);
         }
      }
      );
      
      panel.setBackground(Color.BLACK);
      panel.add(pane);
      panel.add(okButton);
      
      frame.add(panel);
      frame.pack();
      frame.setLocationRelativeTo(null);
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
               //jukeBox.pressOk();
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
               //jukeBox.pressOk();
               showFeatureSelectFrame(frame);
            }
         }
      );
      
      setupButton(resetButton, 600, 620);
      resetButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               //jukeBox.pressOk();
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
               //jukeBox.pressOk();
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
               //jukeBox.pressOk();
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
            //jukeBox.pressOk();
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
            ////jukeBox.pressOk();
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
            //jukeBox.pressOk();
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
            //jukeBox.pressOk();
            showInstructionsFrame();
         }
      }
      );
      
      setupButton(historyButton, 425, 300);
      historyButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            //jukeBox.pressOk();
            showHistoryFrame(frame);
         }
      }
      );
      
      setupButton(exitButton, 425, 400);
      exitButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            //jukeBox.pressOk();
            showExitFrame(frame);
         }
      }
      );
      
      setupButton(solutionButton, 425, 500);
         
      solutionButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            //jukeBox.pressOk();
            showSolutionFrame();
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
   public void showSolutionFrame()
   {
      JFrame frame = new JFrame();
      JPanel panel = new JPanel();
      JTextPane textArea = new JTextPane();
      JButton backButton = new JButton("Back");
      
      String text = "Souls are placed at random but are\n"
                   +"easy to find since they only alternate\n"
                   +"through three locations. AKA The yellow\n"
                   +"stars. So click on every star you see\n"
                   +"Click on the rightermost path\n"
                   +"Click on the door\n"
                   +"Click on the rightermost edge of the path\n"
                   +"Click on the rightermost edge fo the path\n"
                   +"Click on the flower on the right(Treasure)\n"
                   +"Click on the snow below the cottage\n"
                   +"Click on the rightermost edge of the path\n"
                   +"Click on the right edge of the cave\n"
                   +"Click on the base of the mountain\n"
                   +"Click on the right part of the path\n"
                   +"Click on the door. ESCAPE";
      
      textArea.setText(text);
      
      setupTextArea(textArea,0,0);
      textArea.setBounds(50,50,500,800);
      
      setupButton(backButton, 175, 500);
      backButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            //jukeBox.pressOk();
            frame.setVisible(false);
            frame.dispose();
         }
      }
      );
      
      panel.setLayout(null);
      panel.setBackground(Color.BLACK);
      panel.add(backButton);
      panel.add(textArea);
      
      
      frame.add(panel);
      frame.setSize(500,598);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }
   public void showInstructionsFrame()
   {
      JFrame frame = new JFrame();
      JPanel panel = new JPanel();
      JTextPane textArea = new JTextPane();
      JButton backButton = new JButton("Back");
      
      String text = "To interact with the room and\nnavigate through"
                   +"the game you must\nclick on the scene and see what happens.\n"
                   +"You will either find a treasure, \na key, a monster, or a door\n"
                   +"waiting for you after clicking \nor you will simply find nothing.\n"
                   +"When you find a monster youll \nhave the option to feed it \n"
                   +"using your treasure, bribe it \nusing all but $2.50 dollars in your account or\n"
                   +"attempt to flee (You have a \none in three chance to do so).\n"
                   +"If you cant bribe, feed or run from \nthe monster you automatically lose.\n"
                   +"In order to ESCAPE, you will need \nto collect at least one SOUL.\n"
                   +"You can click the chest at the bottom\n"
                   +"right corner at any time to open\n"
                   +"your inventory where you can see the\n"
                   +"amoun tof keys, treasures and money\n"
                   +"you have besides exiting the game if you\n"
                   +"want to";
      
      textArea.setText(text);
      
      setupTextArea(textArea,0,0);
      textArea.setBounds(50,50,500,800);
      
      setupButton(backButton, 225, 500);
      backButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            //jukeBox.pressOk();
            frame.setVisible(false);
            frame.dispose();
         }
      }
      );
      
      panel.setLayout(null);
      panel.setBackground(Color.BLACK);
      panel.add(backButton);
      panel.add(textArea);
      
      
      frame.add(panel);
      frame.setSize(600,598);
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
            //jukeBox.pressOk();
            showHistory();
         }
      }
      );
      setupButton(saveButton, 425, 250);
      saveButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            //jukeBox.pressOk();
         }
      }
      );
      setupButton(loadButton, 425, 350);
      loadButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            //jukeBox.pressOk();
         }
      }
      );
      setupButton(backButton, 425, 450);
      backButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            //jukeBox.pressOk();
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
            //jukeBox.pressOk();
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
