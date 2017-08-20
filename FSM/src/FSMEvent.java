
/**
 * FSMEvent keep the event of the machine. You should subclass it and implement
 * your own events.
 *
 * @author Naor David Melamed
 * @version Aug, 16, 2017
 */
public interface FSMEvent
{
    /**
     * This method returns the event's id
     * @return The event's id - You can return any type of id
     */
    Object getEventId();

    /**
     * This method is the action of the event. You need to implement it in your class
     * base on your needs
     */
    void doAction();
}
