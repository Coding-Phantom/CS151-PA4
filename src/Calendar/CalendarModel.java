package Calendar;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * CalendarModel class that holds data for the Calendar. The absolute main "Model" in MVC
 *
 */

public class CalendarModel
{
    private LocalDate date;

    private HashMap<LocalDate, ArrayList<Event>> calendar;

    private ArrayList<ChangeListener> listeners;

    /**
     * Constructs a CalendarModel object, with lists that hold data and another that holds listeners
     * @param date
     */
    public CalendarModel(LocalDate date)
    {
         this.date = date;
         calendar = new HashMap<LocalDate, ArrayList<Event>>();
         listeners = new ArrayList<ChangeListener>();
    }

    /**
     * Gets the date
     * @return the date
     */
    public LocalDate getDate()
    {
        return date;
    }

    /**
     * Sets the date, and notifies the listeners
     * @param d the date to set
     */
    public void setDate(LocalDate d)
    {
        date = d;
        System.out.println("Model setDate got ran.");
        notifyListeners();
    }

    /**
     * Gets the HashMap data
     * @return the HashMap data
     */
    public HashMap<LocalDate, ArrayList<Event>> getData()
    {
        return calendar;
    }

    /**
     * Adds an event to a date on the HashMap
     * @param d the Date to add
     * @param e the event to add to that date
     * @return true if it got added, false otherwise
     */
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
                    // It overlaps, do not ad
                    // System.out.println("Error! This event time overlaps with another event!");
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

    /**
     * Notifies all the listeners in the listener list. Very important in MVC model.
     */
    public void notifyListeners()
    {
        for (ChangeListener l : listeners)
        {
            // Update the state
            l.stateChanged(new ChangeEvent(this));
        }
    }


    /**
     * Finds whether a given date exists within the data
     * @param d
     * @return true if found, false otherwise
     */
    public boolean findDate(LocalDate d)
    {
        if (calendar.containsKey(d))
        {
            return true;
        }
        return false;
    }

    /**
     * Prints the eventList of a given date in the data
     * @param d
     * @return the eventList as a String
     */
    public String getEvents(LocalDate d)
    {
        String events = "";
        if (calendar.containsKey(d))
        {
            for (Event e : calendar.get(d))
            {
                events += e;
            }
        }
        return events;
    }

    /**
     * Checks the overlap between two times
     * @param e the event to check its time for
     * @param d the date to determine if other events may conflict with the new one
     * @return true if it overlaps, false otherwise
     */
    public boolean checkOverlap(Event e, LocalDate d)
    {
        if (calendar.containsKey(d))
        {
            for (Event ee : calendar.get(d))
            {
                if (ee.getTime().overlap(e.getTime()))
                {
//                    System.out.println("Overlap!");
                    return true;
                }
            }
            return false;
        }
        return false;
    }


    /**
     * Adds a listener to the list.
     * @param c the ChangeListener to add
     */
    public void attach(ChangeListener c)
    {
        listeners.add(c);
    }


    /**
     * Prints the data in the format for events.txt
     * @return the String of data
     */
    public String printData()
    {
        String s = "";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("M/d/yy");

        // For every date in the HashMap
        for (LocalDate d : calendar.keySet())
        {
            String dateFormatted = d.format(df);

            // For every event in the Date key ArrayList
            for (Event e : calendar.get(d))
            {
                s += e.getName() + "\n" + dateFormatted + " " + e.getTime() + "\n";
            }

        }

        return s;

    }


}
