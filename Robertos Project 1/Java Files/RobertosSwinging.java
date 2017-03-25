/***************************************************************   
***************************************************************    
***************************************************************    
                                                         			    		   	          
                   			ID INFORMATION                         		          
                                                        			    		                      
   		Programmer			:		Cardenas Roberto                
   		Assignment #		:   	TA #1.Swinging                     	
   		Assignment Name   :	   Swinging 
   		Course # and Title:	   CISC 190 - Java    	
   		Class Meeting Time:	   TTH 1:00 – 4:05	
  		   Instructor			:	   Professor Forman 
  		   Hours			   	:	   14:00
   		Difficulty			:	   5/10			
   		Completion Date	:	   03/07/2017 	
   		File Name			:  	RobertosSwinging	

***************************************************************
***************************************************************

                   	PROGRAM DESCRIPTION   
                          
 Showcases the introduction, and farewell to the game I will be 
 developing as my final project for this class. Using graphics,
 music and the font from the original Undertale game, to display
 a an aesthetic that is similar to the original.

***************************************************************
***************************************************************

                 CUSTOM-DEFINED METHODS LIST
                 
    RobertosSwinging
      -displayDocumentation
      -displayFarewellFrame
      -displayInformation
      -displayUserName
      -displayWelcomeFrame
      -editImage
      -editText
      -getUserName
      
    PaintPanel
      -paintComponent

***************************************************************
***************************************************************

                         CREDITS	                          		

   	Acknowledge those who helped you and whom you helped  	
      Remember the “triangle of learning”:        		
      
   	Thanks for assistance and inspiration from:           			
         www.tutorialspoint.com/java 
         www.stackoverflow.com 
         Professor Forman, Yvan
      
      Thanks for the opportunity to assist and inspire:
         Yvan
           
***************************************************************
***************************************************************
                        
                           MEDIA
Audio:
   -All audio files taken from the undertale main folder
Pictures:
   -Undertale TitleScreen:
      http://fontmeme.com/images/undertale-font.jpg
   -Sans Gif (Short skeleton):
      http://vignette2.wikia.nocookie.net/undertale/images/2/29/Animaci%
      C3%B3n_Sans.gif/revision/latest?cb=20151125200713&path-prefix=es
   -Papyrus Gif (Tall skeleton):
      http://pa1.narvii.com/6168/3000e51c2808e347abfdaa789ea48e81379ed25
      0_hq.gif
   -Sans and Papyrus Gif (Dancing skeletons):
      https://media.tenor.co/images/9dbb6676d6fe8ca44adc62f097646480/raw
   -Temmy Gif(Twitching cat):
      http://giphy.com/gifs/undertale-vrpg7CCZERhsY
   -Blind Doggo Gif(Dog holding knives):
      http://giphy.com/gifs/undertale-b78LAtUEw9DBS
   -Mettaton Gif(Robot):
      http://vignette1.wikia.nocookie.net/undertale/images/5/58/Mettato
      n.gif/revision/latest?cb=20151111052225
   -Heart Icon(Pixelated red heart):
      http://img03.deviantart.net/9855/i/2016/130/b/7/undertale___pixel_
      heart_thingy_by_aspalax-da1zkgz.png
   -Flowey Gif:
      http://vignette2.wikia.nocookie.net/villains/images/0/09/Flowey_th
      e_flower.gif/revision/latest?cb=20160128235934
Font
   -Undertale Font: Determination Mono
      https://www.behance.net/gallery/31268855/Determination-Better-U
      ndertale-Font

***************************************************************
***************************************************************
   
                           STARS
     1.- Be ecological and re-use the same JFrame to display everything
     2.- Effectvely use 3 graphic images in one of your JFrames
     3.- Effectively use multiple fonts and colors in one JFrame
     4.- Effectively use setBounds to align text and graphics in JFrames
     5.- Effectively use paintComponent to display something dazzling(2)
     6.- Effectively use 3 new advanced features: 
         -If-Else statements, ArrayList, UIManager
     7.- Add pizzaz: Theme related background music
     8.- Hand in and demo early(2)
     9.- Display current date and time
                           Total STARS: 11
                           
***************************************************************
***************************************************************
**************************************************************/
import javax.swing.*;//JPanel, JFrame, JOptionPane, JLabel, UIManager
import java.awt.*;//Font, Color
import java.util.*;//Date, ArrayList
import java.applet.*; //Audioclip, Applet
import java.net.URL;

public class RobertosSwinging
{

   /////////////////////////////////////////////////////////////////////

   //Instance constant declarations and definions

   /////////////////////////////////////////////////////////////////////
   
   final int CENTER = JLabel.CENTER;
   final int LEFT = JLabel.LEFT;
   
   /////////////////////////////////////////////////////////////////////
   
   /////////////////////////////////////////////////////////////////////

   //Instance variable declarations and definions

   /////////////////////////////////////////////////////////////////////
   
   int counter = 0;
   URL urlPressOK = RobertosSwinging.class.getResource("audioOK.wav");
   AudioClip audioPressOK = Applet.newAudioClip(urlPressOK);
   UIManager UI = new UIManager();
   
   /////////////////////////////////////////////////////////////////////
   public static void main(String[] args)
   {
      ////////////////////////////////////////////////////////////////

      //Local variable/Object declarations and definions

      ///////////////////////////////////////////////////////////////////

      AudioClip audioMain;
      URL urlMain = RobertosSwinging.class.getResource("audioMain.wav");
      audioMain  = Applet.newAudioClip(urlMain);
      RobertosSwinging robert = new RobertosSwinging();
      ImageIcon frameIcon  = new ImageIcon("mediaHeartIcon.png");
      int flag = 1;
      String name = "";
      JFrame frameMain = new JFrame();
      
      //////////////////////////////////////////////////////////////////
      
      //Set frameMain properties
      frameMain.setSize(1000,720);
      frameMain.setIconImage(frameIcon.getImage());
      frameMain.setLocationRelativeTo(null);
      frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // Play audio
      audioMain.play();
      
      //Deploy user defined methods
      robert.displayWelcomeFrame(frameMain);
      while (flag != 0)
      {
         name = robert.getUserName();
         flag = robert.displayUserName(name);
      }
      robert.displayInformation(name);
      robert.displayFarewellFrame(frameMain,name);
      robert.displayDocumentation();
      
      //Exit program
      System.exit(0);
      
   }
/******************************************************************************
*******************************************************************************

							START METHOD DECLARATIONS AND DEFINITIONS
								 (Best to appear alphabetically)

*******************************************************************************
******************************************************************************/

/******************************************************************************

	NAME:          displayWelcomeFrame
	DESCRIPTION:    Takes the original JFrame as a parameter, adding components 
   and displaying them to the user in a friendly way.
   
******************************************************************************/

   public void displayWelcomeFrame(JFrame frame)
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
 
      ////////////////////////////////////////////////////////////////////////////////////
           
      //Set UI properties
      UI.put("OptionPane.background", Color.BLACK);
      UI.put("Panel.background",Color.BLACK);
      
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
      
      //Set panel properties and add components
      panel.setLayout(null);
      panel.setBackground(Color.BLACK);
      panel.add(labelTitle);
      panel.add(labelWelcome);
      panel.add(labelSans);
      panel.add(labelPapyrus);
      panel.add(labelBackground);
      panel.add(labelDate);
      
      //Set frame properties and add panel
      frame.setTitle("Welcome to Roberto's Escape from the Undergound!!!");
      frame.add(panel);
      frame.setVisible(true);
      
   }
   
/******************************************************************************

	NAME:          getUserName 
	DESCRIPTION:    Asks for the user's name and returns it as a String. Each time 
   this method is called it uses a different message.

******************************************************************************/

   public String getUserName()
   {
      ////////////////////////////////////////////////////////////////

      //Local variable declarations

      ///////////////////////////////////////////////////////////////

      String text, name;
      
      ///////////////////////////////////////////////////////////////
      
      if (counter ==0)
      {
         text = "Write your name human...";
      }
      else if (counter == 1)
      {
         text = "Dont worry about it. Everybody forgets their own name once in a while. Try again...";
      }
      else if (counter ==2)
      {
         text = "You're not the sharpest tool in the toolshed are you? Try again...";
      }
      else
      {
         text = "Are you being thick? How can you forget your own name? Try again...";
      }
      
      //Ask user for name
      name =JOptionPane.showInputDialog
      (null,editText(text,20),
      "User Login",JOptionPane.PLAIN_MESSAGE);
      audioPressOK.play();
      return name;
   }
   
/******************************************************************************

	NAME:          displayUserName 
	DESCRIPTION:    Takes the user's name and asks them by name to confirm it, returning 
   the result (Yes:1;No:0) as an int. Each time the user uses a different name a 
   different message appears.

******************************************************************************/

   public int displayUserName(String name)
   {
      ////////////////////////////////////////////////////////////////

      //Local variable declarations

      ///////////////////////////////////////////////////////////////
      
      String text;
      int confirm;
      
      ////////////////////////////////////////////////////////////////
      
      if (counter ==0)
      {
         text = "Is "+name+" actually your name?";
      }
      else if (counter == 1)
      {
         text = "Did you get it right this time "+name+"?";
      }
      else if (counter ==2)
      {
         text = "Come on, I know you can do it "+name+"! Wait, is that actually you're name?";
      }
      else
      {
         text = "Surely nobody's that stupid...Right? Is "+name+" actually your name?";
      }
      
      //Display user's name
      confirm = JOptionPane.showConfirmDialog(null,editText(text,18),
      "Login Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
      audioPressOK.play();
      counter +=1;
      return confirm;
   }
   
/******************************************************************************

	NAME:          displayInformation 
	DESCRIPTION:    Displays the games purpose, fees, indicates the game is 
   still currently under construction to the user by name  and bids farewell 
   to the user using JOptionPane.

******************************************************************************/

   public void displayInformation(String name)
   {
      /////////////////////////////////////////////////////////////////////////////////////////////

      //Local variable declarations and definitions

      ////////////////////////////////////////////////////////////////////////////////////////////
      
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
                      
      String strConstruction = "                                                  "
                               +"We are terribly sorry "+name+", but the game is currently"
                               +" under construction. Please return soon!";
                               
      String strFarewell="                                                "
                         +"Press ENTER to proceed to exit window";
                         
      //////////////////////////////////////////////////////////////////////////////////////////////
      
      //Display Purpose
      JOptionPane.showMessageDialog(null,editText("PURPOSE",strPurpose,18),"Purpose",JOptionPane.PLAIN_MESSAGE);
      audioPressOK.play();
      
      //Display Fees
      JOptionPane.showMessageDialog(null,editText("FEES",strFees,CENTER,18,46),"Fees",JOptionPane.PLAIN_MESSAGE);
      audioPressOK.play();
      
      //Display Under Construction
      JOptionPane.showMessageDialog(null,editText("UNDER CONSTRUCTION",strConstruction,18),"Under Construction",JOptionPane.PLAIN_MESSAGE);
      audioPressOK.play();
      
      //Display Farewell
      JOptionPane.showMessageDialog(null,editText("FAREWELL",strFarewell,18),"Farewell",JOptionPane.PLAIN_MESSAGE); 
      audioPressOK.play();
   }
   
/******************************************************************************

	NAME:          displayFarewellFrame 
	DESCRIPTION:    Takes the user's name and the original frame as parameters.
   Wipes the frame, adds new components and displays them as a farewell for the
   user by name.

******************************************************************************/

   public void displayFarewellFrame(JFrame frame, String name)
   {
      /////////////////////////////////////////////////////////////////////////////////////////

      //Local variable/Object declarations and definitions

      /////////////////////////////////////////////////////////////////////////////////////////
      
      JLabel labelFarewellOne = new JLabel("Thank you for visiting, "+name+"! And remember:");
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
      labelSansAndPapyrus.setIcon(new ImageIcon(editImage("mediaSansAndPapyrusGif.gif",250,190)));
      labelSansAndPapyrus.setBounds(0,0,1000,690);
      labelSansAndPapyrus.setHorizontalAlignment(JLabel.CENTER);
      labelSansAndPapyrus.setVerticalAlignment(JLabel.BOTTOM);
      
      //Set labelFlowey properties
      
      labelFlowey.setIcon(new ImageIcon(editImage("mediaFloweyGif.gif",170,200)));
      labelFlowey.setBounds(5,0,1000,500);
      labelFlowey.setHorizontalAlignment(JLabel.LEFT);
      labelFlowey.setVerticalAlignment(JLabel.CENTER);
      
      //Set labelBlindDog properties
      
      labelBlindDog.setIcon(new ImageIcon("mediaBlindDogGif.gif"));
      labelBlindDog.setBounds(0,0,950,510);
      labelBlindDog.setHorizontalAlignment(JLabel.RIGHT);
      labelBlindDog.setVerticalAlignment(JLabel.CENTER);
      
      //Set labelTemmy properties
      
      labelTemmy.setIcon(new ImageIcon(editImage("mediaTemmyGif.gif",180,180)));
      labelTemmy.setBounds(20,0,1000,680);
      labelTemmy.setHorizontalAlignment(JLabel.LEFT);
      labelTemmy.setVerticalAlignment(JLabel.BOTTOM);
      
      //Set labelMettaton properties
      
      labelMettaton.setIcon(new ImageIcon(editImage("mediaMettatonGif.gif",190,190)));
      labelMettaton.setBounds(0,0,980,680);
      labelMettaton.setHorizontalAlignment(JLabel.RIGHT);
      labelMettaton.setVerticalAlignment(JLabel.BOTTOM);
      
      //Add components to panel
      panel.setLayout(null);
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

	NAME:          displayDocumentation 
	DESCRIPTION:    Displays ID Information, Credits, Media used, and STARS obtained
   using JOptionPane.

******************************************************************************/

   public void displayDocumentation()
   {
   
      ////////////////////////////////////////////////////////////////////////////

      //Local variable declarations and definitions

      ///////////////////////////////////////////////////////////////////////////
      
      String strIDInfo = "                                               "
                        +"       Programmer          :  Cardenas Roberto "               
   		               +"       Assignment#         :  TA #SwingingSP   "              	
   		               +"       Assignment Name     :  Swinging         "
   		               +"       Course # and Title  :  CISC 190 - Java  "  	
   		               +"       Class Meeting Time  :  TTH 1:00 – 4:05  "
  		                  +"       Instructor          :  Professor Forman "
  		                  +"       Hours               :  14:00            "
   		               +"       Difficulty          :  5/10             "
   		               +"       Completion Date     :  03/07/2017       "
   		               +"       File Name           :  RobertosSwinging ";
                        
      String strCredits = "                                                           "
                         +"  Acknowledge those who helped you and whom you helped     "
                         +"    Remember the 'triangle of learning':                   "
                         +"    *Thanks for assistance and inspiration from:           "         			
                         +"     -www.tutorialspoint.com/java                          "
                         +"     -www.stackoverflow.com                                "
                         +"     -Professor Forman                                     "
                         +"    *Thanks for the opportunity to assist and inspire      "
                         +"     -Yvan";
                         
      String strMediaOne = " *Music:                                                               "
                          +"  -All audio files taken from the undertale main folder                "
                          +" *Pictures:                                                            "
                          +"  -Undertale TitleScreen:                                              "
                          +"    http://fontmeme.com/images/undertale-font.jpg                      "
                          +"  -Sans Gif:                                                           "
                          +"    http://vignette2.wikia.nocookie.net/undertale/images/2/29/Animaci% "
                          +"    C3%B3n_Sans.gif/revision/latest?cb=20151125200713&path-prefix=es   "
                          +"  -Papyrus Gif:                                                        "
                          +"    http://pa1.narvii.com/6168/3000e51c2808e347abfdaa789ea48e81379ed25 "
                          +"    0_hq.gif                                                           ";
                          
      
      String strMediaTwo = "  -Sans and Papyrus Gif:                                               "
                          +"    https://media.tenor.co/images/9dbb6676d6fe8ca44adc62f097646480/raw "
                          +"  -Temmy Gif:                                                          "
                          +"    http://giphy.com/gifs/undertale-vrpg7CCZERhsY                      "
                          +"  -Blind Doggo Gif                                                     "
                          +"    http://giphy.com/gifs/undertale-b78LAtUEw9DBS                      "
                          +"  -Mettaton Gif:                                                       "
                          +"    http://vignette1.wikia.nocookie.net/undertale/images/5/58/Mettato  "
                          +"    n.gif/revision/latest?cb=20151111052225                            "
                          +"  -Heart Icon:                                                         "
                          +"    http://img03.deviantart.net/9855/i/2016/130/b/7/undertale___pixel_ "
                          +"    heart_thingy_by_aspalax-da1zkgz.png                                ";
                          
                          
      String strMediaThree = "  -Flowey Gif:                                                         "
                            +"    http://vignette2.wikia.nocookie.net/villains/images/0/09/Flowey_th "
                            +"    e_flower.gif/revision/latest?cb=20160128235934                     "
                            +" *Font                                                                 "
                            +"  -Undertale Font: Determination Mono                                  "
                            +"    https://www.behance.net/gallery/31268855/Determination-Better-U    "
                            +"    ndertale-Font                                                      ";
                            

      String strStars =   " 1.- Be ecological and re-use the same JFrame to display everything  "
                         +" 2.- Effectvely use 3 graphic images in one of your JFrames          "
                         +" 3.- Effectively use multiple fonts and colors in one JFrame         "
                         +" 4.- Effectively use setBounds to align text and graphics in JFrames "
                         +" 5.- Effectively use paintComponent to display something dazzling(2) "
                         +" 6.- Effectively use 3 new advanced features:                        "
                         +"        -If-Else statements, ArrayList, UIManager                    "
                         +" 7.- Add pizzaz: Theme related background music                      "
                         +" 8.- Hand in and demo early(2)                                       "
                         +" 9.- Display current date and time                                   "
                         +"                         Total STARS: 11                             ";
                         
      //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
      //Display ID Information
      JOptionPane.showMessageDialog(null,editText("ID INFO",strIDInfo,LEFT,18,46),"Id Info",JOptionPane.PLAIN_MESSAGE);
      audioPressOK.play();  
      
      //Display Credits 
      JOptionPane.showMessageDialog(null,editText("CREDITS",strCredits,LEFT,17,58),"Credits",JOptionPane.PLAIN_MESSAGE);
      audioPressOK.play(); 
      
      //Display Media part 1  
      JOptionPane.showMessageDialog(null,editText("MEDIA 1/3",strMediaOne,LEFT,13,70),"Media",JOptionPane.PLAIN_MESSAGE);
      audioPressOK.play();  
      
      //Display Media part 2 
      JOptionPane.showMessageDialog(null,editText("MEDIA 2/3",strMediaTwo,LEFT,13,70),"Media",JOptionPane.PLAIN_MESSAGE);
      audioPressOK.play();
      
      //Display Media part 3
      JOptionPane.showMessageDialog(null,editText("MEDIA 3/3",strMediaThree,LEFT,13,70),"Media",JOptionPane.PLAIN_MESSAGE);
      audioPressOK.play();
      
      //Display STARS
      JOptionPane.showMessageDialog(null,editText("STARS",strStars,LEFT,14,68),"STARS",JOptionPane.PLAIN_MESSAGE);
      audioPressOK.play();
   }
   
/******************************************************************************

   NAME:          editText
	DESCRIPTION:    Overloaded method. Takes in 2 strings (title, text) and formats them
   so they fit the JOptionPane using the given int arguments (alignment, size). Returns 
   a PaintPanel object containing the formated string.

******************************************************************************/
   public PaintPanel editText(String title,String text, int alignment, int size)
   {
      ////////////////////////////////////////////////////////////////

      //Local Object declarations and definitions

      ///////////////////////////////////////////////////////////////
      
      PaintPanel panel = editText(title,text,alignment,size,50);
      
      ///////////////////////////////////////////////////////////////
      
      return panel;
   }
   
/******************************************************************************

   NAME:          editText
	DESCRIPTION:    Overloaded method. Takes in a string ( text) and formats it
   so it fit's the JOptionPane using the given int arguments (alignment, size). 
   Returns a PaintPanel object containing the formated string.

******************************************************************************/

   public PaintPanel editText(String text, int alignment, int size)
   {
      ////////////////////////////////////////////////////////////////

      //Local Object declarations and definitions

      ///////////////////////////////////////////////////////////////
      
      PaintPanel panel = editText("",text, alignment, size);
      
      ///////////////////////////////////////////////////////////////
      
      return panel;
   }
   
/******************************************************************************

   NAME:          editText
	DESCRIPTION:    Overloaded method. Takes in 2 strings (title, text) and formats them
   so they fit the JOptionPane using the given int arguments ( size). Returns a PaintPanel
   object containing the formated string.

******************************************************************************/

   public PaintPanel editText(String title, String text, int size)
   {
      ////////////////////////////////////////////////////////////////

      //Local Object declarations and definitions

      ///////////////////////////////////////////////////////////////
      
      PaintPanel panel = editText(title,text,CENTER,size);
      
      ///////////////////////////////////////////////////////////////
      
      return panel;
   }
   
/******************************************************************************

   NAME:          editText
	DESCRIPTION:    Overloaded method. Takes in a string (text) and formats it
   to fit the JOptionPane using the given int argument (size). Returns a PaintPanel
   object containing the formated string.

******************************************************************************/

   public PaintPanel editText(String text, int size)
   {
      ////////////////////////////////////////////////////////////////

      //Local Object declarations and definitions

      ///////////////////////////////////////////////////////////////
      
      PaintPanel panel = editText(text,CENTER,size);
      
      ///////////////////////////////////////////////////////////////
      
      return panel;
   }
   
/******************************************************************************

   NAME:          editText
	DESCRIPTION:    Overloaded method. Takes in 2 strings(title, text) and formats
   them to fit the JOptionPane using the given int arguments(alignment, size, lineSize).
   Returns a PaintPanel object containing the formated string.

******************************************************************************/

   public PaintPanel editText(String title, String text, int alignment, int size, int lineSize)
   {
      ////////////////////////////////////////////////////////////////

      //Local Object/variable declarations and definitions

      ///////////////////////////////////////////////////////////////
      ArrayList<JLabel> listLabels = new ArrayList<JLabel>();
      PaintPanel panel;
      
      ///////////////////////////////////////////////////////////////
      
      //Determines JLabels horizontal position on the panel
      if(alignment == 0)
      {
         alignment = JLabel.CENTER;
      }else{
         alignment = JLabel.LEFT;
      }
      
      //Divides string into lines and stores each line in a new JLabel that is added to an ArrayList
      
      cutText(title, text, lineSize, listLabels);
      
      //Initializes panel passing in the Arraylist's length as a parameter
      panel = new PaintPanel(listLabels.size());
      
      //Sets properties for each JLabel in the ArrayList and adds them to the panel
      setTextProperties(panel,listLabels,size,alignment,600);
      panel.setLayout(null);
      
      //Sets the JOptionPanes size to the PaintPanels size
      UI.put("OptionPane.minimumSize", new Dimension(615,90+20*listLabels.size()));
      
      return panel; 
   }
   public void setTextProperties(JPanel panel, ArrayList<JLabel> listLabels, int size, int alignment,int paneWidth)
   {
      for(int x = 0 ; x < listLabels.size() ; x++)
      {
         listLabels.get(x).setForeground(Color.WHITE);
         if (x ==0)
         {
            listLabels.get(x).setFont(new Font("Determination Mono", Font.BOLD, size+5));
            listLabels.get(x).setHorizontalAlignment(JLabel.CENTER);
         }else{
            listLabels.get(x).setFont(new Font("Determination Mono", Font.BOLD, size));
            listLabels.get(x).setHorizontalAlignment(alignment);
         }
         listLabels.get(x).setBounds(0,x*20,paneWidth,80);
         
         listLabels.get(x).setVerticalAlignment(JLabel.TOP);
         panel.add(listLabels.get(x));
      }
   }
   public void cutText(String text, int lineSize, ArrayList<JLabel> listLabels)
   {
      cutText("",text,lineSize,listLabels);
   }
   public void cutText( String title, String text, int lineSize, ArrayList<JLabel> listLabels)
   {
      int i = lineSize;
      
      /////////////////////////////////////////////////////
      
      listLabels.add(new JLabel(title));
      while (true)
      {
         if (text.length()>lineSize)
         {  
            if (text.charAt(i) == ' ')
            {  
               listLabels.add(new JLabel(text.substring(0,i)));
               text = text.substring(i+1);
               i =lineSize;
            }
            else
            {
               i -= 1;
            }
         }
         else
         {
            listLabels.add(new JLabel(text));
            break;
         }
      }
   }
/******************************************************************************

   NAME:          editImage
	DESCRIPTION:      Takes in the images filepath, and the desired width and height.
   Returns an Image object containing the image with the new dimensions.

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
/******************************************************************************
*******************************************************************************

							END METHOD DECLARATIONS AND DEFINITIONS

*******************************************************************************
******************************************************************************/
} 
/******************************************************************************
*******************************************************************************

							START CUSTOM-DEFINED CLASSES
								 (Best to appear alphabetically)

*******************************************************************************
******************************************************************************/
class PaintPanel extends JPanel
{
   ////////////////////////////////////////////////////////////////

   //Instance variable declarations

   ///////////////////////////////////////////////////////////////
   
   int column;
   
   ///////////////////////////////////////////////////////////////
   
/******************************************************************************

	NAME:          PaintPanel 
	DESCRIPTION:    Takes in the amount of columns as an int and assigns it to the
   instance variable columns of type int

******************************************************************************/

   PaintPanel(int column)
   {
      this.column = column;
   }
/******************************************************************************
*******************************************************************************

							START METHOD DECLARATIONS AND DEFINITIONS
								 (Best to appear alphabetically)

*******************************************************************************
******************************************************************************/

/******************************************************************************

	NAME:          paintComponent 
	DESCRIPTION:    Uses a graphics object to draw on the PaintPanel

******************************************************************************/

   public void paintComponent(Graphics pen)
   {
      pen.setColor(Color.WHITE);
      for (int x =0; x<4; x++)
         pen.drawRect(0+x,0+x,593-2*x,(10+20*column)-2*x);
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