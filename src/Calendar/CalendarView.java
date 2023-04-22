package Calendar;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.time.LocalDate;

public class CalendarView extends JFrame implements ChangeListener
{
    CalendarModel m;
    CalendarPanel c;
    public CalendarView(CalendarModel model)
    {

        // Link the model to the CalendarView
        m = model;

        // Set the size and layout of the CalendarView
        setSize(1200, 900);
        setLayout(new BorderLayout());
        Point location = getLocation();
        // Move the frame from the default position
        location.x += 500;
        setLocation(location);

        // Top Panel - contains Month Year, and below the days of the week
        JPanel topPanel = new JPanel(new BorderLayout());

        JLabel monthYearLabel = new JLabel(m.getDate().getMonth().toString() + " " + m.getDate().getYear(), SwingConstants.CENTER);
        monthYearLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        topPanel.add(monthYearLabel, BorderLayout.NORTH);

        JLabel daysOfWeekLabel = new JLabel("SUN                 MON                 TUE                 WED                 THU                 FRI                 SAT", SwingConstants.CENTER);
        daysOfWeekLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        topPanel.add(daysOfWeekLabel, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);

        // Corner L that has the Create button
        JPanel cornerL = new JPanel();
        JButton create = new JButton("Create");
        create.addActionListener(e ->
        {

            CreateView createView = new CreateView(m);

        });
        create.setFont(new Font("Arial", Font.PLAIN, 20));
        create.setBackground(Color.RED);
        cornerL.add(create, BorderLayout.NORTH);

        add(cornerL, BorderLayout.WEST);

        // Corner R that has the Arrows
        JPanel cornerR = new JPanel();
        cornerR.setLayout(new FlowLayout());

        JButton left = new JButton("<");
        left.addActionListener(e ->{
           m.setDate(m.getDate().minusDays(1));
           c.repaint();
        });

        JButton right = new JButton(">");
        right.addActionListener(e ->{
            m.setDate(m.getDate().plusDays(1));
            this.repaint();
        });

        cornerR.add(left);
        cornerR.add(right);

        add(cornerR, BorderLayout.EAST);

        // Create the calendar of 7 x 6 JButtons
        c = new CalendarPanel(m);

        add(c, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }


    public void stateChanged(ChangeEvent e)
    {
        System.out.println("It got a response!");
    }


}
