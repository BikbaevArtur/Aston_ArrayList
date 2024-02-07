package ru.bikbaev.aston;

public interface MyArrayOperations<T> {
    void add(T element); // дока должна быть в интерфейсе а не в реализации
    void add(int index,T element);
    T get(int index);
    void deleteElement(T element);
    void clear();

    void set(int index,T element);

}
