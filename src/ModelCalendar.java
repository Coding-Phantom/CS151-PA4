import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class ModelCalendar
{
    // Model should hold a HashMap of dates and a arraylist of events, similar to our old calendar

    private HashMap<LocalDate, ArrayList<Event>> calendar;
    private LocalDate today;

    public ModelCalendar(LocalDate today)
    {
        this.today = today;
        calendar = new HashMap<>();
    }

    public LocalDate getToday()
    {
        return today;
    }


}
