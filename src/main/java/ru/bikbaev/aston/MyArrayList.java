package ru.bikbaev.aston;

import java.util.Arrays;

import java.util.Objects;

/**
 * @param <T> Тип элементов, хранящихся в массиве.
 */
public class MyArrayList<T> implements MyArrayOperations<T> {

    private Object[] array;                 // Внутренний массив для хранения элементов
    private int size;                        // Текущий размер массива
    private static final int DEFAULT_CAPACITY = 10;  // Начальная емкость массива по умолчанию

    /**
     * Создает пустой MyArrayList с начальной емкостью по умолчанию.
     */
    public MyArrayList() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Добавляет элемент в конец массива.
     *
     * @param element Элемент для добавления.
     */
    @Override
    public void add(T element) {
        increasingArray();
        array[size++] = element;
    }

    /**
     * Добавляет элемент по указанному индексу в массив, сдвигая существующие элементы вправо.
     *
     * @param index   Индекс, по которому должен быть добавлен элемент.
     * @param element Элемент для добавления.
     */
    @Override
    public void add(int index, T element) {
        indexOut(index);
        increasingArray();
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }

    @Override
    public void set(int index, T element) {
        Objects.checkIndex(index, size);
        Object oldElement = array[index];
        array[index] = element;
    }

    /**
     * Возвращает элемент по указанному индексу в массиве.
     *
     * @param index Индекс элемента для извлечения.
     * @return Элемент по указанному индексу.
     */
    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        indexOut(index);
        return (T) array[index];
    }

    /**
     * Возвращает текущий размер массива.
     *
     * @return Текущий размер массива.
     */
    public int getSize() {
        return size;
    }

    /**
     * Удаляет первое вхождение указанного элемента из массива.
     *
     * @param element Элемент для удаления.
     */
    @Override
    public void deleteElement(T element) {
        int index = indexOf(element);
        if (index != -1) {
            removeAtIndex(index);
        }
    }

    /**
     * Очищает массив, удаляя все элементы.
     */
    @Override
    public void clear() {
        if (size == 0) {
            return;
        }
        Arrays.fill(this.array, null);
        size = 0;
    }

    /**
     * Гарантирует, что внутренний массив имеет достаточную емкость, удваивая его при необходимости.
     */
    private void increasingArray() {
        if (array.length == size) {
            int newArrayLength = array.length * 2;
            array = Arrays.copyOf(array, newArrayLength);
        }
    }

    /**
     * Возвращает строковое представление массива, исключая элементы со значением null.
     *
     * @return Строковое представление массива.
     */
//    @Override
//    public String toString() {
//        return Arrays.toString(Arrays.copyOf(array, size));
//    }
    public Object[] getArray() {
        return Arrays.copyOf(array, size);
    }

    /**
     * Проверяет, выходит ли указанный индекс за границы массива, и бросает исключение IndexOutOfBoundsException в случае истины.
     *
     * @param index Индекс для проверки.
     */
    private void indexOut(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс вне допустимых границ");
        }
    }

    /**
     * Возвращает индекс первого вхождения указанного элемента в массиве.
     *
     * @param element Элемент для поиска.
     * @return Индекс первого вхождения элемента или -1, если не найден.
     */
    private int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Удаляет элемент по указанному индексу, сдвигая последующие элементы влево.
     *
     * @param index Индекс элемента для удаления.
     */
    public void removeAtIndex(int index) {
        indexOut(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
    }



}
