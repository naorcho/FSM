
/**
 * MyState implement the FSMState and set the MyStateENum as the program's enum
 *
 * @author Naor David Melamed
 * @version Aug, 16, 2017
 */
public class MyState implements FSMState<MyStateEnum>
{
    // instance variables
    MyStateEnum mState;
    Enum currentState;

    @Override
    public MyStateEnum getStates()
    {
        return mState;
    }

    @Override
    public Enum getCurrentState() {
        return currentState;
    }

    @Override
    public void setCurrentState(Enum e) {
        currentState = e;
    }
}
