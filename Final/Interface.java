import java.util.*;
import java.awt.*;
import javax.swing.*;
public class Interface
{
   UIManager UI = new UIManager();
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
