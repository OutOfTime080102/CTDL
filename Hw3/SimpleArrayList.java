package Hw3;

import java.util.Iterator;
// BAI 1
public class SimpleArrayList<T> implements ListInterface<T> {

    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList(int capacity) {

        array = (T[]) new Object[capacity];
    }

    public void add(T data) {

        int now_size = this.size();
        this.array[now_size] = data;

        this.n += 1;
    }

    public T get(int i) {

        if (i>=this.size() || i<0) {
            System.out.println("OutOfIndex");
            return null;
        }


        return array[i];
    }

    public void set(int i, T data) {

        if (i>this.size() || i<0) System.out.println("OutOfIndex");

        array[i] = data;
    }

    public void remove(T data) {

        int index = -1;

    for (int i=0; i<this.size(); i++) {
            if (array[i].equals(data)) {
                index = i;
                break;
            }
        }


        if (index != -1) {
            for (int i=index; i < this.size()-1; i++)
                array[i] = array[i+1];   // Shift left to 1


            this.n -= 1;
        }
    }

    public boolean isContain(T data) {


        for (int i=0; i<this.size(); i++) {
            if (array[i].equals(data)) return true;
        }


        return false;
    }


    public int size() {

        return this.n;
    }


    public boolean isEmpty() {

        return (this.size() == 0);
    }

    public int indexOf(T data) {
        for (int i=0; i<this.size(); i++) {
            if (array[i].equals(data)) {
                return i;
            }
        }
        return 0;
    }

    public String toString() {
        String arrString = " ";
        for (int i=0; i<this.size(); i++) {
            arrString += array[i].toString() + " ";
        }
        return arrString;
    }

    public Iterator<T> iterator() {
        return new Iter();
    }


    private class Iter implements Iterator<T>{
        int cursor = -1;

        Iter() {}

        @Override
        public boolean hasNext() {
            cursor += 1;
            return cursor < size();
        }

        @Override
        public T next() {
            return array[cursor];
        }

    }

    public static void main(String args[]) {
        SimpleArrayList<Integer> arr = new SimpleArrayList<>();

        System.out.println("ArrayList is empty? " + arr.isEmpty());
        System.out.println("Original size of ArrayList: " + arr.size());

        System.out.println("\nADDING ELEMENTS ...");
        arr.add(5);
        arr.add(3);
        arr.add(3);
        arr.add(7);
        arr.add(10);

        System.out.println("\nSTATUS NOW ARRAYLIST");
        System.out.println("Now size of ArrayList: " + arr.size());
        System.out.println("Now arraylist: " + arr.toString());

        System.out.println("\nCHECK ISCONTAIN METHOD" );
        System.out.println("3 is in ArrayList: " + arr.isContain((Integer) 3));
        System.out.println("0 is in ArrayList: " + arr.isContain((Integer) 0));

        System.out.println("\nGET ELEMENT AT SPECIFICAL POSITION");
        int position = 3;
        System.out.println(position + "-th of ArrayList is " + arr.get(position-1));

        System.out.println("\nREMOVE METHOD");
        Integer data = (Integer) 3;
        System.out.println("Remove " + data.toString() + "from array list");
        arr.remove(data);

        System.out.println("Now size of ArrayList: " + arr.size());
        System.out.println("Now arraylist: " + arr.toString());

        System.out.println("\nSET METHOD");
        System.out.println("ArrayList before setting: " + arr.toString());

        int pos = 2;
        Integer newValue = (Integer) 5;
        System.out.println("Change at position " + pos + "-th with value is " + newValue);
  
        arr.set(pos, newValue);
        System.out.println("ArrayList after set: " + arr.toString());

        System.out.println("\nTEST ITERATOR");
        Iterator iter = arr.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

}