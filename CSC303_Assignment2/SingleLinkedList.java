import java.util.NoSuchElementException;

public class SingleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T d) {
            data = d;
            next = null;
        }
    }

    public SingleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = head;
        head = newNode;

        if (size == 0) {
            tail = newNode;
        }

        size++;
    }

    public void addLast(T item) {
        Node<T> newNode = new Node<>(item);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();

        T val = head.data;
        head = head.next;
        size--;

        if (size == 0) tail = null;

        return val;
    }

    public T removeLast() {
        if (isEmpty()) throw new NoSuchElementException();

        if (size == 1) return removeFirst();

        Node<T> curr = head;
        while (curr.next != tail) {
            curr = curr.next;
        }

        T val = tail.data;
        tail = curr;
        tail.next = null;

        size--;
        return val;
    }

    public T getFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        return head.data;
    }

    public T getLast() {
        if (isEmpty()) throw new NoSuchElementException();
        return tail.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(int index, T item) {

        if (index <= 0) {
            addFirst(item);
            return;
        }

        if (index >= size) {
            addLast(item);
            return;
        }

        Node<T> newNode = new Node<>(item);
        Node<T> curr = head;

        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }

        newNode.next = curr.next;
        curr.next = newNode;

        size++;
    }

    public boolean remove(int index) {

        if (index < 0 || index >= size) return false;

        if (index == 0) {
            removeFirst();
            return true;
        }

        Node<T> curr = head;

        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }

        curr.next = curr.next.next;

        if (index == size - 1) {
            tail = curr;
        }

        size--;
        return true;
    }

    public int find(T item) {

        Node<T> curr = head;
        int i = 0;

        while (curr != null) {
            if (curr.data.equals(item)) return i;
            curr = curr.next;
            i++;
        }

        return size;
    }
}