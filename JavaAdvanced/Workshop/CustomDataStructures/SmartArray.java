package CustomDataStructures;

import java.util.Arrays;
import java.util.function.Consumer;


public class SmartArray {
    private int[] elements;
    private int size;

    public SmartArray() {
        this.elements = new int[8];
    }

    public void add(int element) {
        if (this.elements.length == this.size) {
            elements = Arrays.copyOf(this.elements, this.size * 2);
        }
        this.elements[this.size++] = element;
    }

    public void add(int index, int element) {
        validateIndex(index);

        int lastElement = this.elements[this.size - 1];

        if (this.size - 1 - index >= 0) {
            System.arraycopy(this.elements, index, this.elements, index + 1, this.size - 1 - index);
        }
        this.elements[index] = element;
        add(lastElement);
    }

    public int get(int index) {
        validateIndex(index);
        return this.elements[index];
    }

    public int remove(int index) {
        int element = get(index);

        if (this.size - 1 - index >= 0) {
            System.arraycopy(this.elements, index + 1, this.elements, index, this.size - 1 - index);
        }
        this.elements[--this.size] = 0;
        if (this.elements.length == this.size * 4 && this.size >= 8) {
            elements = Arrays.copyOf(elements, this.size);
        }
        if (this.isEmpty()) {
            this.elements = new int[8];
            this.size = 0;
        }
        return element;
    }

    public boolean contains(int element) {
        for (int i = 0; i < this.size; i++) {
            if (element == this.elements[i]) {
                return true;
            }
        }
        return false;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + this.size);
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void forEach(Consumer<Integer> consumer){
        for (int i = 0; i < this.size; i++) {
            int element = this.elements[i];
            consumer.accept(element);
        }
    }
}
