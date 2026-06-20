package list.basic.intermediate.advance;

import java.util.Arrays;

// Problem 11: Implement custom ArrayList.


public class CustomArrayList<E> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elementData;
    private int size = 0;

    public CustomArrayList() {
        this.elementData =
                new Object[INITIAL_CAPACITY];
    }

    public void add(E e) {
        if (size == elementData.length) {
            ensureCapacity();
        }
        elementData[size++] = e;
    }


    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new
                    IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elementData[index];
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        int newCapacity = elementData.length * 2;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public static void main(String[] args) {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println("Custom ArrayList elements:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
