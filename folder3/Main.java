package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
//
//        // generate random numbers within 1 to 10
//        int max = 11;
//        int min = 1;
//        int range = max - min + 1;
//        for (int i = 0; i < 20; i++) {
//            int rand = (int) (Math.random() * range) + min;
//            System.out.println(rand);
//        }

        //Sorting
        //binarySort();

        int[] numbers = {65, 34, 43, 3443, 434, 35, 67, 2323};
        //binarySearch(numbers);
        System.out.println(binarySearch(numbers, 65));


    }



    public static void bubbleSort(){
        int[] numbers = {65, 34, 43, 3443, 434, 35, 67, 2323};
        for (int n : numbers)
            System.out.print(n+",");
        System.out.println("\n");
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++)
                if (numbers[i] < numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    for (int n : numbers)
                        System.out.print(n+",");
                    System.out.println("\n");
                }
        }
    }


    public static void binarySort() {
        int[] numbers = { 34 , 43 , 3443 , 434 , 35 , 67 ,2323};
        int[] sortednumbers = { 0 , 0 , 0, 0 , 0 , 0 , 0};

        int index = 0;

        for(int i = 0; i <= numbers.length - 1; i++){
            for(int j = 0; j < numbers.length; j++){
                if(numbers[i]>numbers[j]){
                    index = index + 1;
                }
            }
            sortednumbers[index] = numbers[i];
            System.out.println(index);
            index = 0;
        }
        String numbersString = Arrays.toString(sortednumbers);
        System.out.println(numbersString);
    }

        public static int binarySearch ( int arr[], int x) {
            int l = 0, r = arr.length ;
            while (l <= r) {
                int m = l + (r - l) / 2;

                // Check if x is present at mid
                if (arr[m] == x)
                    return m;

                // If x greater, ignore left half
                if (arr[m] < x)
                    l = m + 1;

                    // If x is smaller, ignore right half
                else
                    r = m - 1;
            }

            // if we reach here, then element was
            // not present
            return -1;
        }


}



