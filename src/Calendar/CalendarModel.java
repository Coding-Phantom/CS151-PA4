package Calendar;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class CalendarModel
{
    private LocalDate date;

    private HashMap<LocalDate, ArrayList<Event>> calendar;

    private ArrayList<ChangeListener> listeners;

    public CalendarModel(LocalDate date)
    {
         this.date = date;
         calendar = new HashMap<LocalDate, ArrayList<Event>>();
         listeners = new ArrayList<ChangeListener>();
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate d)
    {
        date = d;
    }

    public HashMap<LocalDate, ArrayList<Event>> getData()
    {
        return calendar;
    }

    public boolean add(LocalDate d, Event e)
    {
        // Add the event to the particular hashmap
        // If a date already contains events, then add to it
        if (calendar.containsKey(d))
        {

            // Check each event to see if it overlaps
            for (Event event : calendar.get(d))
            {
                if (e.getTime().overlap(event.getTime()))
                {
                    // It overlaps, do not add
                    System.out.println("Error! This event time overlaps with another event!");
                    return false;
                }
            }

            // Grab all the events within that date
            ArrayList<Event> eventList = calendar.get(d);
            eventList.add(e);
            calendar.put(d, eventList);

            // Notify the change to all the Views
            notifyListeners();
        }

        // Make a new date with events
        else
        {
            ArrayList<Event> eventList = new ArrayList<Event>();
            eventList.add(e);
            calendar.put(d, eventList);

            // Notify the change to all the Views
            notifyListeners();

        }

        return true;
    }

    public void notifyListeners()
    {
        for (ChangeListener l : listeners)
        {
            // Update the state
            l.stateChanged(new ChangeEvent(this));
        }
    }

    public String viewDay(LocalDate d)
    {
        setDate(d);

        String result = "";

        if (calendar.containsKey(date))
        {
            result = calendar.get(date).toString();
        }

        else if (!calendar.containsKey(date))
        {
            result = "No events on this date!";
        }

        notifyListeners();

        return result;

    }


    public void attach(ChangeListener c)
    {
        listeners.add(c);
    }




}
