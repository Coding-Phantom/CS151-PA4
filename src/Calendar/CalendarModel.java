package Calendar;

import java.time.LocalDate;

public class CalendarModel
{
    private LocalDate date;


    public CalendarModel()
    {
        date = LocalDate.now();
    }

    public LocalDate getDate()
    {
        return date;
    }

    public enum DayOfWeek
    {
        SUNDAY(0),
        MONDAY(1),
        TUESDAY(2),
        WEDNESDAY(3),
        THURSDAY(4),
        FRIDAY(5),
        SATURDAY(6);

        private int number;

        private DayOfWeek(int number)
        {
            this.number = number;
        }

        public int getNumber()
        {
            return number;
        }

    }

}
