package CustomDataStructures;

import java.util.function.Consumer;

public class SmartStack {

    private static class Node {

        int element;
        Node prev;

        private Node(int element) {
            this.element = element;
        }

    }

    private Node topElement;
    private int size;

    public SmartStack() {
    }

    public void push(int element) {
        Node newNode = new Node(element);
        if (this.topElement != null) {
            newNode.prev = this.topElement;
        }
        this.topElement = newNode;

        this.size++;
    }

    public int peek() {
        ensureNonEmpty("peek");
        return this.topElement.element;
    }

    public int pop() {
        ensureNonEmpty("pop");
        int element = this.topElement.element;

        this.topElement = this.topElement.prev;

        this.size--;
        return element;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    private void ensureNonEmpty(String operation) {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot " + operation + " on empty stack");
        }
    }

    public void forEach(Consumer<Integer> consumer){
        Node current = this.topElement;
        while (current != null){
            consumer.accept(current.element);
            current = current.prev;
        }
    }
}
