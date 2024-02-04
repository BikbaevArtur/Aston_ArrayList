package ru.bikbaev.aston;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(100);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);


        System.out.println(Arrays.toString(arrayList.getArray()));

        QuickSort.sort(arrayList);
        System.out.println(Arrays.toString(arrayList.getArray()));

    }
}