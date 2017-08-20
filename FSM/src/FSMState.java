
/**
 * Interface class FSMState - This class is an interface extends an Enum. 
 * You should subclass it and implement it with your own Enum class
 *
 * @author Naor David Melamed
 * @version Aug, 16, 2017
 */
interface FSMState <T extends Enum<T>>
{
    /* *** GETTERS *** */
    /**
     * Return the enum class keeping the states
     *
     * @return - the enum calss
     */
    T getStates();

    /**
     * Returns the current state status from the enum
     *
     * @return - the current enum state
     */
    Enum getCurrentState();

    /* *** SETTERS *** */

    /**
     * Set the current state from a given enum state
     *
     * @param  - the state to set
     */
    void setCurrentState(Enum e);
}

