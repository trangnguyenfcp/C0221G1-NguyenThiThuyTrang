package bai_10_dsa_danhsach.bai_tap;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    private Object elements[];
    MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }
    MyList(int capacity){
        elements = new Object[capacity];
    }
    public void add(int index, E element){
        if (size == elements.length){
            ensureCapacity(elements.length*2);
        }
        for (int i = size; i > index; i--){
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }
    public void ensureCapacity(int minCapacity){
            int newSize = minCapacity;
            elements = Arrays.copyOf(elements, newSize);
    }
    public Object clone(){
            Object elements2 = Arrays.copyOf(elements, size);
            return elements2;
    }
    public int size(){
        return size;
    }
    public boolean contains(E o){
        for (int i = 0; i < size; i++){
            if (elements[i] == o){
                return true;
            }
        }
        return false;
    }
    public int indexOf(E o){
        if (contains(o)) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == o) {
                    return i;
                }
            }
        }
            return -1;
        }
        public E get(int i){
            if (i>= size || i <0) {
                throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
            }
            return (E) elements[i];
        }
        public void clear(){
        for (int i = 0; i < size; i++){
            elements[i] = null;
        }
        }
    public void add(E e) {
        if (size == elements.length) {
            ensureCapacity(elements.length*2);
        }
        elements[size++] = e;
    }
    public boolean add(){
        if (size == elements.length) {
            return false;
        }
        return true;
    }
}
