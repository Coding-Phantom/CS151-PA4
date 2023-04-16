import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Days extends JComponent
{

    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D.Double daySquare = new Rectangle2D.Double(0, 0, 200, 200);
        g2.draw(daySquare);
    }

}