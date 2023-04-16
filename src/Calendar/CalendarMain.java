package Calendar;

public class CalendarMain
{
    public static void main(String[] args)
    {
        CalendarModel model = new CalendarModel();
        CalendarView view = new CalendarView(model);
    }
}
