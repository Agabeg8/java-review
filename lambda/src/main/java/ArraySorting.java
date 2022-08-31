public class ArraySorting {
    public static void main(String[] args) {
        ArraySorting as = new ArraySorting();
       // as.sort();
        QuickSort qs = new QuickSort();
        BubbleSort bs = new BubbleSort();

        as.sort(qs);
        as.sort(bs);

    }

    private void sort(Sorting sorting) {
        sorting.sort();
    }


}
