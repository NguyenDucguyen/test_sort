import edu.princeton.cs.algs4.*;

public class Insertion {
    private Insertion() { }

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
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

        System.out.println(  (end - start) + " ms");
        StdArrayIO.print(a);
    }
}
