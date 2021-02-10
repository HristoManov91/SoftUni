package CustomDataStructures;

import java.util.function.Consumer;

public class CustomLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public static class Node {
        private int element;
        private Node next;
        private Node previous;

        public Node(int element){
            this.element = element;
        }
    }

    public void addFirst(int element){
        Node newNode = new Node(element);
        if (this.head != null){
            newNode.next = this.head;
        }
        this.head = newNode;
        
        if (isEmpty()){
            this.tail = this.head;
            this.head.previous = newNode;
        }

        this.size++;
    }

    public void addLat(int element){
        if (isEmpty()){
            addFirst(element);
        } else {
            Node newNode = new Node(element);
            this.tail.next = newNode;
            newNode.previous = this.tail;
            this.tail = newNode;
            this.size++;
        }
    }

    public int removeFirst(){
        if (isEmpty()){
            throw new IllegalStateException("The data structure is empty");
        }
        this.size--;
        int removedElement = this.head.element;
        if(this.isEmpty()){
            this.head = null;
        }
        return removedElement;
    }

    public int get(int index){
        validateIndex(index);
        Node current = this.head;
        int currentIndex = 0;
        int element = 0;

        while (current != null){
            if (index == currentIndex){
                element =  current.element;
            }
            currentIndex++;
            current = current.next;
        }
        return element;
    }

    public int[] toArray(){
        int[] arr = new int[this.size];
        Node currentNode = this.head;
        int index = 0;
        while (currentNode != null){
            arr[index] = currentNode.element;
            currentNode = currentNode.next;
            index++;
        }
        return arr;
    }

    public void forEach (Consumer<Integer> consumer){
        Node current = this.head;
        while (current != null){
            consumer.accept(current.element);
            current = current.next;
        }
    }

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    private void validateIndex(int index){
        if (index < 0 || index >= this.size){
            throw new IllegalArgumentException("Index " + index + " no such in data structure");
        }
    }
}
