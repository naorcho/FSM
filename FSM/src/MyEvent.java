
/**
 * MyEvent implements the FSMEvent's methods and extends the class
 * You can add any property that will represent your event
 *
 * @author Naor David Melamed
 * @version Aug, 16, 2017
 */
public class MyEvent implements FSMEvent
{
    // instance variables
    private int mId;
    private String mName;
    private FSMMachine mMachine;

    /**
     * Constructor for objects of class FSMEvent
     */    
    public MyEvent(FSMMachine machine, int eventId, String eventName)
    {
        this.mId = eventId;
        this.mName = eventName;
        this.mMachine = machine;
    }

    /**
     * Perform the action for the event
     */
    @Override
    public void doAction()
    {
        this.mMachine.performEvent(this);
    }

    /* *** GETTERS *** */

    /**
     * Get the event id
     * @return - the event id
     */
    @Override
    public Integer getEventId()
    {
        return this.mId;
    }

    /**
     * Return the name of the event
     *
     * @return - A string representing the event's name
     */
    public String getName()
    {
        return this.mName;
    }

}
