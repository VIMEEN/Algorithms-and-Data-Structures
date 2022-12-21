package com.company;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command;
        FancyDynamicArray array = new FancyDynamicArray(newArray());
        help();
        do{
            System.out.print("Введите команду: ");
            do{
                command = clearCommand(scan.nextLine());
            }
            while(command.equals(""));

            switch (command) {
                case ("new"): {
                    String confirm;
                    do {
                        System.out.println("Вы уверены, что хотите создать новый массив (старый массив будет удален)?"+
                                "\nY/N");
                        confirm = clearCommand(scan.nextLine());
                        switch (confirm) {
                            case ("Y"): {
                                array = new FancyDynamicArray(newArray());
                                break;
                            }
                            case ("N"): {
                                break;
                            }
                            default:
                                System.out.println("Неверная команда! Попробуйте ещё раз");
                        }
                    }
                    while(!confirm.equals("N") && !confirm.equals("Y"));
                    break;
                }
                case ("length"): {
                    System.out.print("Длина массива: " + array.length() + "\n");
                    break;
                }
                case ("insert"): {
                    System.out.println("Введите индекс элемента, куда хотите вставить элемент, или cancel для отмены");
                    try {
                        String index = clearCommand(scan.nextLine());
                        if(index.equals("cancel"))
                            break;
                        int i = Integer.parseInt(index);
                        if (i > array.length() - 1 || i < 0){
                            System.out.println("Индекс вышел за пределы массива");
                            break;
                        }
                        System.out.println("Введите значение элемента, которое хотите вставить, или cancel для отмены");

                        index = clearCommand(scan.nextLine());
                        if(index.equals("cancel")) break;

                        array.setElement(i, Double.parseDouble(index));
                        System.out.println("Теперь массив выглядит так: " + array);
                    }
                    catch (NumberFormatException e){
                        System.out.println("Индекс должен быть целым числом, а значение - вещественным числом");
                    }
                    break;
                }
                case ("remove"): {
                    System.out.println("Введите индекс элемента, который хотите убрать, или cancel для отмены");
                    try {
                        String index = clearCommand(scan.nextLine());
                        if(index.equals("cancel")) break;
                        int i = Integer.parseInt(index);
                        if (i > array.length() - 1 || i < 0){
                            System.out.println("Индекс вышел за пределы массива");
                            break;
                        }
                        array.removeElement(i);
                        System.out.println("Теперь массив выглядит так: " + array);
                    }
                    catch (NumberFormatException e){
                        System.out.println("Индекс должен быть целым числом");
                    }
                    break;
                }
                case ("print"): {
                    try {
                        System.out.println("Введите индекс элемента, который хотите вывести на экран, или cancel для отмены");
                        String index = clearCommand(scan.nextLine());
                        if (index.equals("cancel")) break;
                        int i = Integer.parseInt(index);
                        if (i > array.length() - 1 || i < 0) {
                            System.out.println("Индекс вышел за пределы массива");
                            break;
                        }
                        System.out.println(array.getElement(i));
                        System.out.println();
                    }
                    catch (NumberFormatException e){
                        System.out.println("Индекс должен быть целым числом");
                    }
                    break;
                }
                case("add"):{
                    try{
                        System.out.println("Введите значение элемента, которое хотите вставить, или cancel для отмены");
                        String index = clearCommand(scan.nextLine());
                        if(index.equals("cancel")) break;
                        array.setElement(Double.parseDouble(index));
                        System.out.println("Теперь массив выглядит так: " + array);
                    }
                    catch (NumberFormatException e){
                        System.out.println("Значение элемента должно быть вещественным числом");
                    }
                    break;
                }
                case ("max"): {
                    if(array.length() != 0) {
                        System.out.println("Значением наибольшего элемента массива: "
                                + array.findMax() + "\n");
                        break;
                    }
                    System.out.println("Ошибка! Массив пустой");
                    break;
                }
                case ("min"): {
                    if(array.length() != 0) {
                        System.out.println("Значением наименьшего элемента массива: "
                                + array.findMin() + "\n");
                        break;
                    }
                    System.out.println("Ошибка! Массив пустой");
                    break;
                }
                case ("printArray"): {
                    System.out.println("Текущий массив: " + array);
                    break;
                }
                case ("help"): {
                    help();
                    break;
                }
                case ("exit"):{
                    break;
                }
                case ("sort"): {
                    array.sort();
                    System.out.println("Теперь массив выглядит так: " + array);
                    break;
                }
                case ("search"): {
                    try {
                        System.out.println("Введите значение элемента, которое требуется проверить, или cancel для отмены");
                        String value = clearCommand(scan.nextLine());
                        if(value.equals("cancel")) break;
                        int index = array.search(0, array.length()-1, Double.parseDouble(value));
                        if(index == -1){
                            System.out.println("Такого элемента нет");
                        }
                        else System.out.println("Индекс этого элемента: " + index);
                    }
                    catch (NumberFormatException e){
                        System.out.println("Значение элемента должно быть вещественным числом");
                    }
                    break;
                }
                default:
                    System.out.println("Неверная команда! Попробуйте ещё раз");
            }
        } while(!command.equals("exit"));

    }
    static void help(){
        System.out.println("- Создать массив - new;                     \n"+
                "- Вывести информацию о количестве элементов - length;  \n"+
                "- Добавить в массив элемент - add;                     \n"+
                "- Удалять из массива элемент - remove;                 \n"+
                "- Вывести значение элемента по индексу - print;        \n"+
                "- Сделать вставку по индексу - insert;                 \n"+
                "- Найти максимальное значение элементов - max;         \n"+
                "- Найти и минимальное значение элементов - min;        \n"+
                "– Выводить содержание массива - printArray;            \n"+
                "- Проверить наличие элемента в массиве - search;       \n"+
                "- Отсортировать массив - sort;                         \n");
    }
    static double[] newArray(){
        Scanner scan = new Scanner(System.in);
        double[] nums;
        boolean flag;
        int length;
        do {
            flag = false;
            System.out.println("Введите массив (через пробел)");
            String[] str = scan.nextLine().split(" ");
            length = 0;
            for (String ch : str) if(!ch.equals("")) length++;
            nums = new double[length];
            for (int i = 0, j = 0; i < str.length; i++) {
                try {
                    if(!str[i].equals("")) {
                        nums[j] = Double.parseDouble(str[i]);
                        j++;
                    }
                }
                catch (NumberFormatException e) {
                    System.out.println("Ошибка! Попробуйте ввести массив ещё раз.\n" +
                            "Среди элементов не должны быть буквы, знаки препинания или спецсимволы.");
                    flag = true;
                    break;
                }
            }
        }
        while(flag);
        return nums;
    }
    static String clearCommand(String command){
        for(String ch : command.split(" ")) {
            if (!ch.equals("")){
                command = ch;
                break;
            }
        }
        return command;
    }
}