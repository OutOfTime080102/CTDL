package Hw2;

import java.util.Random;

// BAI 2
public class SelectionSort {

    private int[] arr;
    private int count_compare=0, count_swap=0;
    private boolean verbose;

    public SelectionSort(int[] arr, boolean verbose) {
        this.arr = arr;
        this.verbose = verbose;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int getCount_compare() {
        return count_compare;
    }

    public void setCount_compare(int count_compare) {
        this.count_compare = count_compare;
    }

    public int getCount_swap() {
        return count_swap;
    }

    public void setCount_swap(int count_swap) {
        this.count_swap = count_swap;
    }

    public boolean isVerbose() {
        return verbose;
    }

    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    public static int[] createArray(int n, int bound) {

        int[] array = new int[n];

        long seed = 10;
        Random rand = new Random(seed);

        for (int i=0; i<n; i++) {
            array[i] = rand.nextInt(bound);
        }

        return array;
    }

    public void printOut (int[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int[] selectionSort() {
        int[] arr = this.getArr();
        int length = arr.length;
        for (int i=length-1; i>=1; i--) {
            int maxIndex = i;
            for (int j=0; j<i; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
                this.count_compare += 1;
            }

            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;

            this.count_swap += 1;

            if (this.isVerbose()) {
                System.out.println("Now, status :");
                printOut(arr);
            }
        }
        return arr;
    }

    public String effective() {
        return String.format("Number of comparability: %d\nNumber of swapping: %d\n",
                this.getCount_compare(), this.getCount_swap());
    }

    public static void main(String[] args) {

        int bound = 50;

        int n = 8;

        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        boolean verbose = true;

        SelectionSort sort = new SelectionSort(arr, verbose);
        int[] sorted = sort.selectionSort();
        System.out.println(sort.effective());
    }

}
