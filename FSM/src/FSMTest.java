import java.util.ArrayList;

public class FSMTest {
    public static void main(String[] args) {

        MyState state = new MyState();
        state.setCurrentState(state.getStates().DEFAULT);
        MyMachine fsm = new MyMachine(state.getCurrentState());

        System.out.println("Initial State: " + fsm.getCurrentState());

        // Creating the events
        MyEvent a = new MyEvent(fsm, 1, "Event A");
        MyEvent b = new MyEvent(fsm, 2, "Event B");
        MyEvent c = new MyEvent(fsm, 3, "Event C");
        MyEvent something = new MyEvent(fsm, 4, "Other");

        // Set sequences for the State machine
        ArrayList<MyEvent> seq1 = new ArrayList<>();
        seq1.add(a);
        seq1.add(a);
        seq1.add(b);
        seq1.add(c);
        seq1.add(a);

        ArrayList<MyEvent> seq2 = new ArrayList<>();
        seq2.add(a);
        seq2.add(b);
        seq2.add(c);

        ArrayList<MyEvent> seq3 = new ArrayList<>();
        seq3.add(a);
        seq3.add(c);
        seq3.add(something);

        // Set the sequences to the FSM
        fsm.setSequenceForState(seq1, state.getStates().SEQ1);
        fsm.setSequenceForState(seq2, state.getStates().SEQ2);
        fsm.setSequenceForState(seq3, state.getStates().SEQ3);

        // Perform the events' actions

        a.doAction();
        b.doAction();
        c.doAction();
        // Now the State is SEQ2

        a.doAction();
        a.doAction();
        b.doAction();
        c.doAction();
        a.doAction();
        // Now the State is SEQ1

        a.doAction();
        c.doAction();
        something.doAction();
        // Now the State is SEQ3
    }



}
