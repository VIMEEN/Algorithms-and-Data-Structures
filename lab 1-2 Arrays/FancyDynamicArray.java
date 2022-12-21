package com.company;

public class FancyDynamicArray extends DynamicArray{
    FancyDynamicArray(double ... array) {
        super(array);
    }
    private final double[] array = getArray();
    private boolean isSorted = false;
    public void sort() {
        for (int i = 0; i < array.length; i++) {
            int pos = i;
            double min = array[i];
            //цикл выбора наименьшего элемента
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    pos = j;
                    min = array[j];
                }
            }
            array[pos] = array[i];
            array[i] = min;
        }
        isSorted = true;
    }
    public int search(int firstElement, int lastElement, double elementToSearch) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == elementToSearch)
                 return index;
        }
        return -1;
    }
}