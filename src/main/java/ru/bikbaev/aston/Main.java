package ru.bikbaev.aston;


public class Main {

    public static void main(String[] args) {
        MyArrayList<String> arrayList = new MyArrayList<>();
        arrayList.add("0");
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("8");
        System.out.println(arrayList);
        arrayList.add(2,"2-2");
        System.out.println(arrayList);

        arrayList.deleteElement("5");
        System.out.println(arrayList);








    }
}