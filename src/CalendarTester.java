import java.time.LocalDate;

public class CalendarTester
{
    public static void main(String[] args)
    {
        LocalDate today = LocalDate.now();

        ModelCalendar model = new ModelCalendar(today);
        ViewCalendar view = new ViewCalendar(model);
    }
}