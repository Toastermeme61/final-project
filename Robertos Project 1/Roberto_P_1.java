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
   		File Name			:  	Roberto_P_1

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
         -runGame()
    

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
**************************************************************/
import javax.swing.*; //JFrame
import java.net.URL;
import java.applet.*;//AudioClip, Applet
public class Roberto_P_1
{
  
   public static void main (String[] args)
   {
      ///////////////////////////////////////////////////////////
      
      //Local Variable/Object declarations and definiitons
      
      //////////////////////////////////////////////////////////
      
      Roberto_P_1 objectMain = new Roberto_P_1();
      JFrame frameMain = new JFrame();
      
      //////////////////////////////////////////////////////////
      
      //Set frameMain properties
      frameMain.setSize(1000,720);
      frameMain.setIconImage(new ImageIcon("mediaHeartIcon.png").getImage());
      frameMain.setLocationRelativeTo(null);
      frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //Run Game using the previusly created JFrame
      objectMain.runGame(frameMain);

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
  CALLS: Interface.runGame()
  CALLED BY: None

******************************************************************************/

   public void runGame(JFrame frame)
   {
      Interface objectInterface =  new Interface();
      objectInterface.runGame(frame);
   }

/******************************************************************************
*******************************************************************************

							END METHOD DECLARATIONS AND DEFINITIONS

*******************************************************************************
******************************************************************************/

}
