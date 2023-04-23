package Calendar;

import javax.swing.*;
import java.time.LocalDate;

/**
 * Custom DateButton class that holds the date within the Button. A "controller" component in MVC.
 *
 */

public class DateButton extends JButton
{
    private LocalDate date;

    public DateButton(String text, LocalDate date)
    {
        super(text);
        this.date = date;
    }

    public LocalDate getDate()
    {

        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }
}
