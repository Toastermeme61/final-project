import javax.swing.*;//JFrame, JLabel, JButton, JOPtionPane
import java.util.*;//Date
import java.awt.*;//Color, Font
import java.awt.event.*;//ActionListener
public class RobertoFinalEscape
{
   UIManager UI = new UIManager();
   DialogueManager DM = new DialogueManager();
   public static void main(String[] args)
   {
      JFrame frameMain = new JFrame("Undertale");
      RobertoFinalEscape finalEscape = new RobertoFinalEscape();
      frameMain.setSize(1000,720);
      frameMain.setLocationRelativeTo(null);
      frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      finalEscape.showWelcomeFrame(frameMain);
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
      
      overviewButton.setBounds(225,320,150,20);
      overviewButton.addActionListener( new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               //showOverviewFrame(frame);
            }
         }
      );
      
      loginButton.setBounds(425,320,150,20);
      loginButton.addActionListener( new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               //showLoginFrame(frame);
            }
         }
      );
      
      exitButton.setBounds(625,320,150,20);
      exitButton.addActionListener( new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               //showExitFrame(frame);
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
      frame.setTitle("Welcome to Roberto's Escape from the Undergound!!!");
      frame.add(panel);
      frame.setVisible(true);      
   }
/******************************************************************************

	NAME:          showOverviewFrame
	DESCRIPTION:    
   
******************************************************************************/
   public void showOverviewFrame(JFrame overview)
   {
      JLabel feesLabel = new JLabel();
      JPanel panel =  new JPanel();
      
      feesLabel.setIcon(new ImageIcon("mediaFees.png"));
      feesLabel.setBounds(0,30,1000,700);
      feesLabel.setHorizontalAlignment(JLabel.CENTER);
      feesLabel.setVerticalAlignment(JLabel.TOP);
      
      
   }
  
}