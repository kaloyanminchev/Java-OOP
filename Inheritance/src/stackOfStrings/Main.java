package stackOfStrings;

public class Main {
    public static void main(String[] args) {
        StackOfStrings sos = new StackOfStrings();

        System.out.println(sos.isEmpty());

        sos.push("one");
        sos.push("two");
        sos.push("three");

        System.out.println(sos.pop());
        System.out.println(sos.peek());
        System.out.println(sos.isEmpty());
    }
}
