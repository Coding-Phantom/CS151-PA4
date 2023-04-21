package Calendar;

import java.time.LocalDate;

public class CalendarMain
{
    public static void main(String[] args)
    {

        CalendarModel model = new CalendarModel(LocalDate.now());
        CalendarView view = new CalendarView(model);
        DayViewFrame dayView = new DayViewFrame(model);

        model.attach(view);
        model.attach(dayView);
    }
}
