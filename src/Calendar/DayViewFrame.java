package Calendar;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class DayViewFrame extends JFrame implements ChangeListener
{
    CalendarModel m;
    JLabel date;

    JTextArea eventList;
    public DayViewFrame(CalendarModel model)
    {
        m = model;
        setSize(700, 700);
        setLayout(new BorderLayout());
        // Get the default location of the frame
        Point location = getLocation();
        // Move the frame from the default position
        location.x += 1500;
        setLocation(location);

        date = new JLabel(m.getDate().toString());
        date.setFont(new Font("Arial", Font.PLAIN, 50));
        JPanel title = new JPanel();
        title.add(date);
        add(title, BorderLayout.NORTH);

        eventList = new JTextArea(m.viewDay(m.getDate()));
        date.setFont(new Font("Arial", Font.PLAIN, 30));
        JPanel eventPanel= new JPanel();
        eventPanel.add(eventList, BorderLayout.CENTER);
        add(eventPanel, BorderLayout.CENTER);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void stateChanged(ChangeEvent e)
    {
        date.setText(m.getDate().toString());
        System.out.println(m.getDate().toString());
        this.repaint();

    }
}
