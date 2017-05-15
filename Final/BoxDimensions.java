import java.awt.event.*;
import javax.swing.*;
public class BoxDimensions
{
   public static void main(String[] args)
   {
      BoxDimensions object =  new BoxDimensions();
      String name = JOptionPane.showInputDialog(null,"Enter file name:");
      object.showFrame(name);
   }
   public void showFrame(String file)
   {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JPanel panel = new JPanel();
      JLabel picture = new JLabel();
      picture.setIcon(new ImageIcon(file));
      panel.addMouseListener(new MouseListener());
      panel.add(picture);
      frame.add(panel);
      frame.pack();
      frame.setVisible(true);
   }
}
class MouseListener extends MouseAdapter
{
   public void mouseClicked(MouseEvent event)
   {
      int column, row;
      column = event.getX();
      row = event.getY();
      JOptionPane.showMessageDialog(null,"column "+column+" row "+row);
   }
}