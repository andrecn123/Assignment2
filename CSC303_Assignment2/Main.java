public class Main {

    public static void main(String[] args) {

        // stack part
        IntegerStack stack = new IntegerStack();

        System.out.println("Empty at start? " + stack.isEmpty());

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Size after pushes: " + stack.size());
        System.out.println("Removed: " + stack.pop());
        System.out.println("Current top: " + stack.peek());
        System.out.println("Average value: " + stack.average());

        // linked list test
        SingleLinkedList<Integer> list = new SingleLinkedList<>();

        list.addFirst(5);
        list.addLast(10);
        list.addLast(15);

        System.out.println("List first: " + list.getFirst());
        System.out.println("List last: " + list.getLast());

        list.removeLast();
        System.out.println("After removing last: " + list.getLast());
    }
}