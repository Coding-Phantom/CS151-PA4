/**
 * An Event object class to hold events with TimeIntervals and has a way to determine if it's a recurring event
 *
 */
public class Event {
    private String name;
    private TimeInterval time;

    private boolean isRecurring;


    /**
     * Constructs an Event object with a name, time, and a boolean to determine if its a recurring event
     * @param name - the name of the event
     * @param time - the time of the event
     * @param isOccurring - boolean to see if its recurring
     * precondition: time must be in military time
     */
    public Event(String name, TimeInterval time, boolean isOccurring)
    {
        this.name = name;
        this.time = time;
        this.isRecurring = isOccurring;
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
     * Returns true or false if its recurring
     * @return true or false if its recurring
     */
    public boolean getIsReccuring()
    {
        return isRecurring;
    }

    /**
     * Returns the toString() of this object
     * @return toString() of this object
     */
    public String toString()
    {
        return name + "\n" + time;
    }


}
