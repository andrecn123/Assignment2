import java.util.ArrayList;
import java.util.EmptyStackException;

public class IntegerStack {

    private ArrayList<Integer> list;

    public IntegerStack() {
        list = new ArrayList<>();
    }

    public void push(int value) {
        list.add(value);
    }

    public int pop() {
        if (isEmpty()) throw new EmptyStackException();
        return list.remove(list.size() - 1);
    }

    public int peek() {
        if (isEmpty()) throw new EmptyStackException();
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public double average() {
        if (isEmpty()) return 0;

        int sum = 0;
        for (int num : list) {
            sum += num;
        }

        return (double) sum / list.size();
    }
}