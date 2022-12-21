package com.company;

public class DynamicArray {
    private double[] array;
    DynamicArray(double ... array) {
        this.array = array;
    }
    public void removeElement(int index) {
        double[] temp = new double[array.length - 1];
        for(int i = 0; i < array.length; i++){
            if (i < index) {
                temp[i] = array[i];
            }
            if (i > index) {
                temp[i-1] = array[i];
            }
        }
        array = temp;
    }
    public void setElement(int index, double value) {
        double[] temp = new double[array.length + 1];
        for(int i = 0; i < index; i++)
            temp[i] = array[i];
        temp[index] = value;
        for(int i = index + 1; i < array.length + 1; i++)
            temp[i] = array[i-1];
        array = temp;
    }
    public void setElement(double value) {
        double[] temp = new double[array.length + 1];
        for(int i = 0; i < array.length; i++) temp[i] = array[i];
        temp[array.length] = value;
        array = temp;
    }
    public int length() {
        return array.length;
    }

    public String toString() {
        String str = "[ ";
        for (double element : array) str += element + " ";
        str+="]";
        return str;
    }
    public double getElement(int index) {
        try {
            return array[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            return -1;
        }
    }
    public double findMin() {
        try {
            double min = array[0];
            for (double element : array) {
                if (element < min)
                    min = element;
            }
            return min;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }
    }
    public double findMax() {
        try {
            double max = array[0];
            for (double element : array) {
                if (element > max)
                    max = element;
            }
            return max;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }
    }
    public double[] getArray(){
        return array;
    }
}