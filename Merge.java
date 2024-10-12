import edu.princeton.cs.algs4.*;

public class Merge {
    private Merge() { }

    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

    
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        In in = new In("D:\\algs4-data\\algs4-data\\4Kints.txt");
        int[] a = in.readAllInts();

        Integer[] aComparable = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            aComparable[i] = a[i];
        }

        long start = System.currentTimeMillis();
        sort(aComparable);
        long end = System.currentTimeMillis();

        System.out.println((end - start) + " ms");
        for (int i = 0; i < aComparable.length; i++) {
            System.out.println(aComparable[i]);
        }
    }
}
