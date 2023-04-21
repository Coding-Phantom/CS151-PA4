package Calendar;

import javax.swing.*;
import java.awt.*;

public class CreateView extends JFrame
{
    CalendarModel m;

    JTextField eventName;
    JTextField timeStart;
    JTextField timeEnd;

    public CreateView(CalendarModel model)
    {
        m = model;
        setSize(500, 300);
        setLayout(new FlowLayout());

        // Get the default location of the frame
        Point location = getLocation();
        // Move the frame from the default position
        location.x += 200;
        setLocation(location);

        JLabel title = new JLabel("Create a new event");
        title.setFont(new Font("Arial", Font.PLAIN, 40));

        eventName = new JTextField("Untitled event");
        eventName.setFont(new Font("Arial", Font.PLAIN, 30));
        eventName.setPreferredSize(new Dimension(400, 40));


        JLabel date = new JLabel(m.getDate().toString());
        date.setFont(new Font("Arial", Font.PLAIN, 30));


        timeStart = new JTextField("xx:xx");
        timeStart.setFont(new Font("Arial", Font.PLAIN, 30));


        JLabel to = new JLabel("to");
        to.setFont(new Font("Arial", Font.PLAIN, 20));


        timeEnd = new JTextField("xx:xx");
        timeEnd.setFont(new Font("Arial", Font.PLAIN, 30));

        JButton save = new JButton("Save");
        save.setFont(new Font("Arial", Font.PLAIN, 40));
        save.addActionListener(e ->
        {
            // Use the given JTextFields to add it to the model

            dispose();

        });


        add(title);
        add(eventName);
        add(date);
        add(timeStart);
        add(to);
        add(timeEnd);
        add(save);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

}
