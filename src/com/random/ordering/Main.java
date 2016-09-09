package com.random.ordering;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(bubble());
    }
    private static StringBuilder bubble(){
        int aux;
        StringBuilder result = new StringBuilder();
        int[] array = {55,86,48,16,82};
        for (int i = 1; i < array.length; i++){
            for (int j = 0; j < array.length-1; j++){
                if (array[j] > array[j+1]){
                    aux = array[j];
                    array[j] = array[j+1];
                    array[j+1] = aux;
                }
            }
        }
        for (int arrayInit = 0; arrayInit < array.length; arrayInit++){
            result.append(array[arrayInit]);
            result.append(" ");
        }
        return result;
    }
}
