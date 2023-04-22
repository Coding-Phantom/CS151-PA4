package Calendar;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CreateView extends JFrame
{
    CalendarModel m;

    JTextField eventName;
    JTextField timeStart;
    JTextField timeEnd;

    JLabel status;

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

        status = new JLabel();
        status.setFont(new Font("Arial", Font.PLAIN, 30));
        status.setBackground(Color.red);


        JButton save = new JButton("Save");
        save.setFont(new Font("Arial", Font.PLAIN, 40));
        DateTimeFormatter f = DateTimeFormatter.ofPattern("H:mm");
        save.addActionListener(e ->
        {

            String addName = eventName.getText();
            LocalDate addDate = m.getDate();
            LocalTime addStart = LocalTime.parse(timeStart.getText(), f);
            LocalTime addEnd = LocalTime.parse(timeEnd.getText(), f);
            TimeInterval addTime = new TimeInterval(addStart, addEnd);
            Event addEvent = new Event(addName, addTime);

            boolean createStatus= false;
            // Use the given JTextFields to add it to the model


            if (!m.checkOverlap(addEvent, addDate))
            {
                System.out.println(!m.checkOverlap(addEvent, addDate));
                m.add(addDate, addEvent);
                System.out.println(addName + " " + addDate.toString() + " " + addStart.toString() + " " + addEnd.toString());
                System.out.println(m.getData());

                dispose();
            }
            else
            {
                status.setText("Error, time overlap, try again");
            }


        });


        add(title);
        add(eventName);
        add(date);
        add(timeStart);
        add(to);
        add(timeEnd);
        add(save);
        add(status);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

}
