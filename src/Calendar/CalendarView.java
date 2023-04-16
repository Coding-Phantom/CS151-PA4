package Calendar;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.time.LocalDate;

public class CalendarView extends JFrame
{
    CalendarModel m;
    public CalendarView(CalendarModel model)
    {
        m = model;
        setSize(1200, 1000);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());

        JLabel monthYearLabel = new JLabel(m.getDate().getMonth().toString() + " " + m.getDate().getYear(), SwingConstants.CENTER);
        monthYearLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        topPanel.add(monthYearLabel, BorderLayout.NORTH);

        JLabel daysOfWeekLabel = new JLabel("SUN                     MON                     TUE                     WED                     THU                     FRI                     SAT", SwingConstants.CENTER);
        daysOfWeekLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        topPanel.add(daysOfWeekLabel, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);

        CalendarPanel c = new CalendarPanel();
        add(c, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public class CalendarPanel extends JPanel
    {
        // Keep reference of the DaySquare
        private DaySquare[] daySquares;

        public CalendarPanel()
        {
            daySquares = new DaySquare[42];
            setLayout(new GridLayout(6, 7));

            // Find the first day of the month and add up from there
            int dayCount = 1;
            boolean start = false;
            boolean disable = false;

            // this is the first day
            LocalDate firstDay = LocalDate.of(m.getDate().getYear(), m.getDate().getMonth(), 1);
            LocalDate lastDay = firstDay.withDayOfMonth(firstDay.lengthOfMonth());
            System.out.println(firstDay);

            for (int i = 0; i < daySquares.length; i++)
            {
                // Continues if start is enabled after finding the first day
                if (start)
                {
                    if (dayCount <= lastDay.getDayOfMonth())
                    {
                        daySquares[i] = new DaySquare(dayCount);
                        add(daySquares[i]);
                        dayCount++;
                    }

                    else
                    {
                        daySquares[i] = new DaySquare(0);
                        add(daySquares[i]);
                        start = false;
                    }
                }

                // If it finds the first day of the week, start printing
                else if (i == firstDay.getDayOfWeek().getValue())
                {
                    daySquares[i] = new DaySquare(dayCount);
                    add(daySquares[i]);
                    dayCount++;
                    start = true;
                }

                // If it hasn't found the first day, print a empty square
                else
                {
                    daySquares[i] = new DaySquare(0);
                    add(daySquares[i]);
                }

            }

        }

        public DaySquare[] getDaySquares()
        {
            return daySquares;
        }
    }


}
