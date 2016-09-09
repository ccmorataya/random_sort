package com.random.ordering;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
        optionSelect();
    }

    //Bubble sort algorithm
    private static int[] bubble(int [] array){
        int aux;
        for (int i = 1; i < array.length; i++){
            for (int j = 0; j < array.length-1; j++){
                if (array[j] > array[j+1]){
                    aux = array[j];
                    array[j] = array[j+1];
                    array[j+1] = aux;
                }
            }
        }
        return array;
    }

    //QuickSort algorithm
    private static int[] quickSort(int[] array, int first, int last){
        int initial = first;
        int endPoint = last;
        int pivot = (array[initial] + array[endPoint]) / 2;

        while (initial < endPoint){

            while (array[initial] < pivot){
                initial += 1;
            }

            while (array[endPoint] > pivot){
                endPoint -= 1;
            }

            if (initial <= endPoint){
                int temporal = array[endPoint];
                array[endPoint] = array[initial];
                array[initial] = temporal;

                initial += 1;
                endPoint -= 1;
            }
        }

        if (first < endPoint){
            array = quickSort(array, first, endPoint);
        }

        if (last > initial){
            array = quickSort(array, initial, last);
        }

        return array;
    }

    private static StringBuilder printArray(int [] array){
        StringBuilder result = new StringBuilder();
        for (int arrayInit = 0; arrayInit < array.length; arrayInit++){
            result.append(array[arrayInit]);
            result.append(" ");
        }
        return result;
    }

    private static int[] fillIntArray(int[] numbers){
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = (int) (Math.random()*20)+1;
        }
        return numbers;
    }

    private static void menu(){
        System.out.println("=================================================================");
        System.out.println("ALGORITMOS DE ORDENAMIENTO DE UN ARRAY DE DIEZ NÚMEROS ALEATORIOS");
        System.out.println("=================================================================\n");
        System.out.println("Digita el número de la opción que deseas comprobar seguido de [Enter]:");
        System.out.println("\t1. Ordenamiento de burbuja.");
        System.out.println("\t2. Ordenamiento Quick Sort.\n");
    }

    private static void optionSelect(){
        Scanner input;
        input = new Scanner(System.in);

        int[] numbers = new int[10];
        fillIntArray(numbers);

        String option = input.nextLine();

        if (Integer.parseInt(option) == 1){
            System.out.println("Ordenamiento de burbuja:\n\tArray original:\n\t" + printArray(numbers));
            int [] bubbles = bubble(numbers);
            System.out.println("\n\tArray ordenado:\n\t" + printArray(bubbles));
        }
        else if (Integer.parseInt(option) == 2){
            System.out.println("Ordenamiento QuickSort:\n\tArray original:\n\t" + printArray(numbers));
            int [] quickSorted = quickSort(numbers, 0, numbers.length-1);
            System.out.println("\n\tArray ordenado:\n\t" + printArray(quickSorted));
        }
    }
}
