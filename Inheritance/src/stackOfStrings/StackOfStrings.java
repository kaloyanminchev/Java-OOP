package stackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        this.data.add(item);
    }

    public String pop() {
        return this.data.remove(this.getLastIndex());
    }

    public String peek() {
        return this.data.get(this.getLastIndex());
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    private int getLastIndex() {
        return this.data.size() - 1;
    }
}
