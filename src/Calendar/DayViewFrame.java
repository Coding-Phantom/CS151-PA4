package Calendar;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class DayViewFrame extends JFrame implements ChangeListener
{
    CalendarModel m;
    JLabel date;

    JLabel eventList;
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

        eventList = new JLabel();
        eventList.setFont(new Font("Arial", Font.PLAIN, 30));
        if (m.findDate(m.getDate()))
        {

            eventList.setText("<html>" + m.getEvents(m.getDate()).replaceAll("\n", "<br>") + "</html>");
        }

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
        if (m.findDate(m.getDate()))
        {

            eventList.setText("<html>" + m.getEvents(m.getDate()).replaceAll("\n", "<br>") + "</html>");
        }

        else
        {
            eventList.setText("");
        }
//        System.out.println(m.viewDay(m.getDate()));

    }
}
