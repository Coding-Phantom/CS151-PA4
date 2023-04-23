package Calendar;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * DayViewFrame class that opens a separate DayViewFrame for the DayView, it IS a JFrame. Also implements ChangeListener. An important "View" in MVC.
 */
public class DayViewFrame extends JFrame implements ChangeListener
{
    CalendarModel m;
    JLabel date;

    JLabel eventList;

    /**
     * Constructs the JFrame with components for the Day view. Shows the date and the events listed on that date
     * @param model
     */
    public DayViewFrame(CalendarModel model)
    {
        m = model;
        setSize(700, 700);
        setLayout(new BorderLayout());
        // Get the default location of the frame
        Point location = getLocation();
        // Move the frame from the default position
        location.x += 1000;
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

    /**
     * State changed for this ChangeListener class. Gets notified when the model notifies its listeners
     * @param e  a ChangeEvent object
     */
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
