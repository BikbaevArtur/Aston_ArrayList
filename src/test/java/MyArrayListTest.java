
import org.junit.Assert;
import org.junit.Test;
import ru.bikbaev.aston.MyArrayList;
import ru.bikbaev.aston.QuickSort;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MyArrayListTest {
    @Test
    public void testAddAndGet() {
        MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add("El1");
        stringList.add("El2");
        stringList.add("El3");
        String[] stringArray = {"El1", "El2", "El3"};

        assertEquals("El1", stringList.get(0));
        assertEquals("El2", stringList.get(1));
        assertEquals("El3", stringList.get(2));
        assertEquals(Arrays.toString(stringArray), Arrays.toString(stringList.getArray()));


        MyArrayList<Integer> intList = new MyArrayList();
        intList.add(0);
        intList.add(1);
        intList.add(2);
        int[] intArray = {0, 1, 2};
        assertEquals(0, intList.get(0));
        assertEquals(1, intList.get(1));
        assertEquals(2, intList.get(2));

        assertEquals(Arrays.toString(intArray), Arrays.toString(intList.getArray()));


        MyArrayList<Double> doubleList = new MyArrayList();
        doubleList.add(0.1);
        doubleList.add(0.2);
        doubleList.add(0.3);
        double[] doubleArray = {0.1, 0.2, 0.3};

        assertEquals(0.1, doubleList.get(0));
        assertEquals(0.2, doubleList.get(1));
        assertEquals(0.3, doubleList.get(2));
        assertEquals(Arrays.toString(doubleArray), Arrays.toString(doubleList.getArray()));


        MyArrayList<Character> charList = new MyArrayList();
        charList.add('+');
        charList.add('-');
        charList.add('1');
        char[] charArray = {'+', '-', '1'};

        assertEquals('+', charList.get(0));
        assertEquals('-', charList.get(1));
        assertEquals('1', charList.get(2));
        assertEquals(Arrays.toString(charArray), Arrays.toString(charList.getArray()));

        MyArrayList<Object> objList = new MyArrayList();
        objList.add(1);
        objList.add("+++++++++");
        objList.add('-');
        Object[] objArray = {1, "+++++++++", '-'};

        assertEquals(1, objList.get(0));
        assertEquals("+++++++++", objList.get(1));
        assertEquals('-', objList.get(2));
        assertEquals(Arrays.toString(objArray), Arrays.toString(objList.getArray()));

    }

    @Test
    public void testAddAtIndex() {
        MyArrayList<Object> objList = new MyArrayList<>();
        objList.add(0);
        objList.add("1");
        objList.add('3');
        objList.add(2, '2');

        Object[] expected = {0, "1", '2', '3'};
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(objList.getArray()));
    }

    @Test
    public void testGetSize() {
        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>();

        assertEquals(0, integerMyArrayList.getSize());

        integerMyArrayList.add(1);
        integerMyArrayList.add(2);
        integerMyArrayList.add(3);
        integerMyArrayList.add(4);

        assertEquals(4, integerMyArrayList.getSize());

        integerMyArrayList.deleteElement(4);

        assertEquals(3, integerMyArrayList.getSize());
    }

    @Test
    public void testDeletedElement() {
        MyArrayList<String> stringMyArrayList = new MyArrayList<>();
        stringMyArrayList.add("0");
        stringMyArrayList.add("1");
        stringMyArrayList.add("2");
        stringMyArrayList.deleteElement("1");
        String[] expected = {"0", "2"};

        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(stringMyArrayList.getArray()));

    }

    @Test
    public void testClear() {
        MyArrayList<Object> objectMyArrayList = new MyArrayList<>();
        objectMyArrayList.add(1);
        objectMyArrayList.add(2);
        objectMyArrayList.clear();
        int[] expected = {};


        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(objectMyArrayList.getArray()));
    }

    @Test
    public void testRemoveAtIndex() {
        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>();
        integerMyArrayList.add(0);
        integerMyArrayList.add(1);
        integerMyArrayList.add(2);
        integerMyArrayList.add(3);

        integerMyArrayList.removeAtIndex(1);

        int[] expected = {0, 2, 3};

        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(integerMyArrayList.getArray()));
        assertEquals(3, integerMyArrayList.getSize());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetIndexOutOfBoundsException() {
        MyArrayList<String> stringList = new MyArrayList<>();
        stringList.get(10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoteIndexOutOfBoundsException() {
        MyArrayList<String> stringList = new MyArrayList<>();
        stringList.removeAtIndex(10);
    }

    @Test
    public void testQuickSort() {
        MyArrayList<String> stringMyArrayList = new MyArrayList<>();
        stringMyArrayList.add("Артур");
        stringMyArrayList.add("Сергей");
        stringMyArrayList.add("Семен");
        stringMyArrayList.add("Мария");
        stringMyArrayList.add("Руслан");
        QuickSort.sort(stringMyArrayList);
        String[] expectedString = {"Артур","Мария","Руслан","Семен","Сергей"};

        Assert.assertEquals(Arrays.toString(expectedString),Arrays.toString(stringMyArrayList.getArray()));

        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>();
        integerMyArrayList.add(8);
        integerMyArrayList.add(2);
        integerMyArrayList.add(11);
        integerMyArrayList.add(10);
        QuickSort.sort(integerMyArrayList);
        int[] expectedInt = {2,8,10,11};

        Assert.assertEquals(Arrays.toString(expectedInt),Arrays.toString(integerMyArrayList.getArray()));


    }


}