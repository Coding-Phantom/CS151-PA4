package Calendar;

/**
 * An Event object class to hold events with TimeIntervals. Reused and changed code from my personal PA1 code
 *
 */
public class Event {
    private String name;
    private TimeInterval time;


    /**
     * Constructs an Event object with a name, time, and a boolean to determine if its a recurring event
     * @param name - the name of the event
     * @param time - the time of the event
     * precondition: time must be in military time
     */
    public Event(String name, TimeInterval time)
    {
        this.name = name;
        this.time = time;

    }

    /**
     * Returns the name of the event
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the time interval of the event
     * @return the time
     */
    public TimeInterval getTime()
    {
        return time;
    }

    /**
     * Returns the toString() of this object
     * @return toString() of this object
     */
    public String toString()
    {
        return name + " " + time + "\n";
    }


}

