import java.util.*;
import java.awt.*;
import javax.swing.*;
public class DialogueManager
{
   final int CENTER = JLabel.CENTER;
   final int LEFT = JLabel.LEFT;
   UIManager UI = new UIManager();
   public JPanel editText(String title,String text, int alignment, int size)
   {
      ////////////////////////////////////////////////////////////////

      //Local Object declarations and definitions

      ///////////////////////////////////////////////////////////////
      
      JPanel panel = editText(title,text,alignment,size,50);
      
      ///////////////////////////////////////////////////////////////
      
      return panel;
   }
   
/******************************************************************************

   NAME:          editText
	DESCRIPTION:    Overloaded method. Takes in a string ( text) and formats it
   so it fit's the JOptionPane using the given int arguments (alignment, size). 
   Returns a PaintPanel object containing the formated string.

******************************************************************************/

   public JPanel editText(String text, int alignment, int size)
   {
      ////////////////////////////////////////////////////////////////

      //Local Object declarations and definitions

      ///////////////////////////////////////////////////////////////
      
      JPanel panel = editText("",text, alignment, size);
      
      ///////////////////////////////////////////////////////////////
      
      return panel;
   }
   
/******************************************************************************

   NAME:          editText
	DESCRIPTION:    Overloaded method. Takes in 2 strings (title, text) and formats them
   so they fit the JOptionPane using the given int arguments ( size). Returns a PaintPanel
   object containing the formated string.

******************************************************************************/

   public JPanel editText(String title, String text, int size)
   {
      ////////////////////////////////////////////////////////////////

      //Local Object declarations and definitions

      ///////////////////////////////////////////////////////////////
      
      JPanel panel = editText(title,text,CENTER,size);
      
      ///////////////////////////////////////////////////////////////
      
      return panel;
   }
   
/******************************************************************************

   NAME:          editText
	DESCRIPTION:    Overloaded method. Takes in a string (text) and formats it
   to fit the JOptionPane using the given int argument (size). Returns a PaintPanel
   object containing the formated string.

******************************************************************************/

   public JPanel editText(String text, int size)
   {
      ////////////////////////////////////////////////////////////////

      //Local Object declarations and definitions

      ///////////////////////////////////////////////////////////////
      
      JPanel panel = editText(text,CENTER,size);
      
      ///////////////////////////////////////////////////////////////
      
      return panel;
   }
   
/******************************************************************************

   NAME:          editText
	DESCRIPTION:    Overloaded method. Takes in 2 strings(title, text) and formats
   them to fit the JOptionPane using the given int arguments(alignment, size, lineSize).
   Returns a PaintPanel object containing the formated string.

******************************************************************************/

   public JPanel editText(String title, String text, int alignment, int size, int lineSize)
   {
      ////////////////////////////////////////////////////////////////

      //Local Object/variable declarations and definitions

      ///////////////////////////////////////////////////////////////
      ArrayList<JLabel> listLabels = new ArrayList<JLabel>();
      JPanel panel;
      
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
      panel = new JPanel();
      
      //Sets properties for each JLabel in the ArrayList and adds them to the panel
      setTextProperties(panel,listLabels,size,alignment,600);
      panel.setLayout(null);
      
      //Sets the JOptionPanes size to the PaintPanels size
      UI.put("OptionPane.minimumSize", new Dimension(615,90+20*listLabels.size()));
      
      return panel; 
   }
   public Image editImage(String imageName, int width, int height)
   {
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

      //Local Object declarations and definitions

      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
      Image image = new ImageIcon(imageName).getImage().getScaledInstance(width,height,java.awt.Image.SCALE_DEFAULT);
      
      //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
      return image;
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
   public void cutText(String text, int lineSize, ArrayList<JLabel> listLabels)
   {
      cutText("",text,lineSize,listLabels);
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
   public void showMsgGameDialog(JFrame frame, String text, String title)
   {
   /////////////////////////////////////////////////////////////
   
   //Local variable/object declarations and definitions
   
   /////////////////////////////////////////////////////////////
   
      ArrayList<JLabel> list = new ArrayList<JLabel>();
      JPanel container = new JPanel();
      JPanel panel = new JPanel();
      
   /////////////////////////////////////////////////////////////
   
      cutText(text,68,list);
      setTextProperties(panel,list,16,JLabel.CENTER,660);
      panel.setLayout(null);
      container.setBounds(157,478,685,200);
      frame.add(container);
      UI.put("OptionPane.minimumSize",new Dimension(680,180));
      JOptionPane.showMessageDialog(container, panel,title, JOptionPane.PLAIN_MESSAGE);
      //audioPressOK.play();   
   }

   public String showInputGameDialog(JFrame frame, String text,String title, String defValue)
   {
   ///////////////////////////////////////////////////////////////
   
   //Local variable/object declarations and definitions
   
   ///////////////////////////////////////////////////////////////
   
      ArrayList<JLabel> list = new ArrayList<JLabel>();
      JPanel container = new JPanel();
      JPanel panel = new JPanel();
      
   ///////////////////////////////////////////////////////////////
   
      String ans;
      cutText(text,68,list);
      setTextProperties(panel,list,16,JLabel.CENTER,660);
      panel.setLayout(null);
      container.setBounds(157,478,685,200);
      frame.add(container);
      //UI.put("OptionPane.minimumSize",new Dimension(680,180));
      ans = JOptionPane.showInputDialog(container, panel,title, JOptionPane.PLAIN_MESSAGE,null,null,defValue).toString();
      //audioPressOK.play();
      return ans;
   }
}
