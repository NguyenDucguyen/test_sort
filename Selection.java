import edu.princeton.cs.algs4.*;

public class Selection {
    private Selection() { }

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[minIndex])) {
                    minIndex = j;
                }
            }
            exch(a, i, minIndex);
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

        System.out.println((end - start) + " ms");
        for (int i = 0; i < aComparable.length; i++) {
            System.out.println(aComparable[i]);
        }
    }
}
