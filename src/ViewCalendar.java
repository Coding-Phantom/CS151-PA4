import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class ViewCalendar extends JFrame
{
    private ModelCalendar model;
    public ViewCalendar(ModelCalendar m)
    {
        model = m;

        setSize(1200, 1000);
        CalendarMaker c = new CalendarMaker();
        add(c, BorderLayout.CENTER);

        JPanel topPanel = new JPanel(new BorderLayout());

        JLabel monthYearLabel = new JLabel(m.getCurrentDay().getMonth().toString() + " " + m.getCurrentDay().getYear(), SwingConstants.CENTER);
        monthYearLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        topPanel.add(monthYearLabel, BorderLayout.NORTH);

        JLabel daysOfWeekLabel = new JLabel("SUN                     MON                     TUE                     WED                     THU                     FRI                     SAT", SwingConstants.CENTER);
        daysOfWeekLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        topPanel.add(daysOfWeekLabel, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);





    }



}
