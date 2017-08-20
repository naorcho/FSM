
import java.util.ArrayList;
import java.util.HashMap;
/**
 * MyMachine implements the FSMMachine class and set the proper states and manage the states and events for the state machine
 *
 * @author Naor David Melamed
 * @version Aug, 16, 2017
 */
public class MyMachine implements FSMMachine 
{
   public MyState mState = new MyState();
   HashMap<Enum, ArrayList<MyEvent>> sequence = new HashMap<>();
   ArrayList<MyEvent> currentSequence = new ArrayList<>();

    /**
     * Constructor methods for the machine - setting a default state
     * @param state - the default state
     */
   MyMachine (Enum state)
   {
      mState.setCurrentState(state);
   }

   @Override
   public Enum getCurrentState()
   {
       return mState.getCurrentState();
   }

    /**
     * IMplement the event trigger
     * @param event - The current event that just triggered
     */
   @Override
   public void performEvent(FSMEvent event)
   {
      currentSequence.add((MyEvent) event);

      for (Enum key : sequence.keySet())
      {
         ArrayList<MyEvent> eSequence = sequence.get(key);
         for (int j = 0; j < currentSequence.size(); j++)
         {
            if (FSMMachine.containSequenceFromStart(eSequence, currentSequence))
            {
               if (eSequence.size() == currentSequence.size())
               {
                  mState.setCurrentState(key);
                  //We start a new sequence as we should ignore the current one.
                  currentSequence = new ArrayList<>();
                  // This if is only because we need to represent the SEQ3 as SEQ3: <any event>
                  if (mState.getCurrentState() == mState.getStates().SEQ3)
                  {
                      System.out.println(mState.getCurrentState() + ": " + ((MyEvent) event).getName());
                  }
                  else
                  {
                      System.out.println(mState.getCurrentState());
                  }

                  return;
               }
            }
         }
      }


   }
   
   @Override
   public void setSequenceForState(ArrayList<?> list, Enum state)
   {
       sequence.put(state, (ArrayList<MyEvent>) list);
   }
}
