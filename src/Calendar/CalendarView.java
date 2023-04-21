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
    public CalendarView(CalendarModel model)
    {

        // Link the model to the CalendarView
        m = model;

        // Set the size and layout of the CalendarView
        setSize(1200, 900);
        setLayout(new BorderLayout());

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
        create.setFont(new Font("Arial", Font.PLAIN, 20));
        create.setBackground(Color.RED);
        cornerL.add(create, BorderLayout.NORTH);

        add(cornerL, BorderLayout.WEST);

        // Corner R that has the Arrows
        JPanel cornerR = new JPanel();
        cornerR.setLayout(new FlowLayout());
        JButton left = new JButton("<");
        JButton right = new JButton(">");
        cornerR.add(left);
        cornerR.add(right);

        add(cornerR, BorderLayout.EAST);

        // Create the calendar of 7 x 6 JButtons
        CalendarPanel c = new CalendarPanel();

        add(c, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public class CalendarPanel extends JPanel
    {
        // Keep reference of the DaySquare
        private DateButton[] dayButtons;

        public CalendarPanel()
        {
            dayButtons = new DateButton[42];
            setLayout(new GridLayout(6, 7));

            // Find the first day of the month and add up from there
            boolean start = false;
            boolean disable = false;

            // this is the first day
            LocalDate firstDay = LocalDate.of(m.getDate().getYear(), m.getDate().getMonth(), 1);

            // this is the last day
            LocalDate lastDay = firstDay.withDayOfMonth(firstDay.lengthOfMonth());

            // this is the day we will be incrementing
            LocalDate dayCount = LocalDate.of(m.getDate().getYear(), m.getDate().getMonth(), 1);

            for (int i = 0; i < dayButtons.length; i++)
            {
                LocalDate finalDayCount = dayCount;
                if (start)
                {
                    if (dayCount.getDayOfMonth() < lastDay.getDayOfMonth() && firstDay.getMonth().equals(dayCount.getMonth()))
                    {
                        DateButton newDay = new DateButton(String.valueOf(dayCount.getDayOfMonth()), dayCount);
                        newDay.setFont(new Font("Arial", Font.PLAIN, 20));
                        newDay.setSize(180, 180);

                        newDay.addActionListener(e -> {
                            LocalDate current = finalDayCount;
                            m.viewDay(current);
                        });
                        dayButtons[i] = newDay;
                        add(dayButtons[i]);
                        dayCount = dayCount.plusDays(1);

                    }

                    // The last day
                    else
                    {
                        DateButton newDay = new DateButton(String.valueOf(dayCount.getDayOfMonth()), dayCount);
                        newDay.setFont(new Font("Arial", Font.PLAIN, 20));
                        newDay.setSize(180, 180);
                        newDay.addActionListener(e -> {
                            LocalDate current = finalDayCount;
                            m.viewDay(current);
                        });

                        dayButtons[i] = newDay;
                        add(dayButtons[i]);
                        System.out.println(dayCount);
                        start = false;

                    }
                }
                // If it finds the first day of the week, start printing
                else if (i == firstDay.getDayOfWeek().getValue() && firstDay.getMonth().equals(dayCount.getMonth()))
                {
                    DateButton newDay = new DateButton(String.valueOf(dayCount.getDayOfMonth()), dayCount);
                    newDay.setFont(new Font("Arial", Font.PLAIN, 20));
                    newDay.setSize(180, 180);
                    newDay.addActionListener(e -> {
                        LocalDate current = finalDayCount;
                        m.viewDay(current);
                    });

                    dayButtons[i] = newDay;
                    add(dayButtons[i]);
                    dayCount = dayCount.plusDays(1);

                    start = true;

                }

                // If it hasn't found the first day, print a empty square
                else
                {
                    dayButtons[i] = new DateButton(null, null);
                    add(dayButtons[i]);
                }

            }

        }

        public JButton[] getDaySquares()
        {
            return dayButtons;
        }


    }

    public void stateChanged(ChangeEvent e)
    {
        System.out.println("It got a response!");
    }


}
