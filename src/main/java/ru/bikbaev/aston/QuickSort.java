package ru.bikbaev.aston;





public class QuickSort{


    public static <T extends Comparable<? super T>> void sort(MyArrayList<T> o)
    {
        quicksort(o, 0, o.getSize() - 1);
    }

    private static <T extends Comparable<? super T>> void quicksort(MyArrayList<T> o, int start, int end)
    {
        if (start < end)
        {
            int pivot = partition(o, start, end);
            quicksort(o, start, pivot);
            quicksort(o, pivot + 1, end);
        }
    }

    private static <T extends Comparable<? super T>> int partition(MyArrayList<T> o, int start, int end)
    {
        T pivot = o.get((end + start) / 2);
        int i = start;
        int j = end;
        while (true)
        {
            while (o.get(i).compareTo(pivot) < 0)
                i++;
            while (o.get(j).compareTo(pivot) > 0)
                j--;
            if (i >= j)
                return j;
            T buffer = o.get(i);
            o.set(i, o.get(j));
            o.set(j, buffer);
            i++;
            j--;
        }
    }

}