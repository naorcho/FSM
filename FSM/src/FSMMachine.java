import java.util.ArrayList;
/**
 * FSMMachine - Manage the states for the events
 * support for sequences (plural) and not only one sequence of events
 *
 * @author Naor David Melamed
 * @version Aug, 16, 2017
 */
public interface FSMMachine
{
    /**
     * Get the current state of our State Machine
     */
   Enum getCurrentState();

    /**
     * Manage the transition between our state depending on the given event
     * @param event - The current event that just triggered
     */
    void performEvent(FSMEvent event);

    /**
     * Set a sequence rule to the machine for future check
     * @param list - a list of events for a specific state
     * @param state - The state fot the list of events
     */
    void setSequenceForState(ArrayList<?> list, Enum state);

    /**
     * Check if the first list contain the second list by order and from the beginning of the list
     * @param seq1 - the first list
     * @param seq2 - the second list
     * @return - true if it is containing the second list
     */
    static boolean containSequenceFromStart(ArrayList<? extends FSMEvent> seq1, ArrayList<? extends FSMEvent>  seq2)
    {
        boolean isContain = true;
        if (seq1.size() < seq2.size())
        {
            // In this case the containing sequence is smaller than the event sequence there for we return false.
            return false;
        }

        int count = seq2.size();
        // we iterate on the second list and check if it is inside the first list and should be from the beginning of the list
        for (int i = 0; i < count; ++i)
        {
            FSMEvent event1 = seq1.get(i);
            FSMEvent event2 = seq2.get(i);
            if (!event1.getEventId().equals(event2.getEventId()))
            {
                isContain = false;
                break;
            }
        }

        return isContain;
    }
}
