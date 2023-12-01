package de.szut;

import java.util.Arrays;

public class MyArrayList {

    private static final int INITIAL_CAPACITY = 10;

    private int[] array;
    private int size;

    public MyArrayList() {
        this.array = new int[INITIAL_CAPACITY];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean add(int value) {
        ensureCapacity();
        array[size++] = value;
        return true;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("Dieser Index existiert nicht!");
        }

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        array[--size] = 0;
    }


    public boolean contains(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    private void ensureCapacity() {
        if (size == array.length) {
            int newCapacity = array.length + INITIAL_CAPACITY;
            array = Arrays.copyOf(array, newCapacity);
        }
    }
}
