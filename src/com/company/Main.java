package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 3, -9, 5, 12, 9};
        int min = findMin(arr);
        int max = findMax(arr);
        System.out.println("Min of array is "+ min );
        System.out.println("Max of array is "+ max );
        bubbleSort(arr);
    }

    private static int findMin(int[] arr){
        int min = arr[0];

        for(int i = 0; i < arr.length; ++i){
            if(arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    private static int findMax(int[] arr){
        int max = arr[0];

        for(int i = 0; i < arr.length; ++i){
            if(arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    private static void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; ++i){
            for(int j = n-1; j > i; --j){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        for(int i = 0; i < arr.length; ++i ){
            System.out.print(arr[i]+" ");
        }
    }
}
