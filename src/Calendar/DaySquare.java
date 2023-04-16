package Calendar;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class DaySquare extends JPanel
{
    int day;
    public DaySquare(int day)
    {
        this.day = day;
        setSize(200, 200);
    }

    public int getDay()
    {
        return day;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g;

        // -5 On the size so it doesn't exceed the bounds
        Rectangle2D.Double square = new Rectangle2D.Double(0, 0, 180, 180);

        g2.draw(square);

        g2.setFont(new Font("Arial", Font.PLAIN, 20));
        if (day != 0)
        {
            g2.drawString(String.valueOf(day), 5, 20);
        }
    }

}
