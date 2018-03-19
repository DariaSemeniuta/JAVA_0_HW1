package project;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 3, -9, 5, 12, 9};
        //check min, max of array
        int min = findMin(arr);
        int max = findMax(arr);
        System.out.println("Min of array is " + min);
        System.out.println("Max of array is " + max);
        //check bubbleSort
        bubbleSort(arr);
        //check quickSort
        quickSort(arr, 0, arr.length);
        print(arr);
        //check binarySearch with recursion
        int[] arr2 = {0, 1, 3, 6, 7, 9, 12};
        System.out.println("\nSecond array:");
        print(arr2);
        int indx = binarySearch(arr2, 9, 0, arr2.length - 1);
        System.out.println("Index = " + indx);
        //check binarySearch with loop
        indx = binarySearch(arr2, 9);
        System.out.println("Index = " + indx);
        //check mergeSort
        int[] arr3 = {8, 2, 1, 9, 5, -3, 0};
        System.out.println("Array before sort:");
        print(arr3);
        mergeSort(arr3, 0, arr3.length - 1);
        System.out.println("\nArray after sort:");
        print(arr3);

    }

    public static void print(int[] arr) {
        System.out.print("\n");
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
    }

    private static int findMin(int[] arr) {
        int min = arr[0];

        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    private static int findMax(int[] arr) {
        int max = arr[0];

        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            for (int j = n - 1; j > i; --j) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        print(arr);
    }

    public static void quickSort(int arr[], int start, int stop) {
        if (stop == 0)
            return;
        if (start >= stop)
            return;

        int ind = start;
        for (int i = start + 1; i < stop; ++i) {
            if (arr[i] < arr[ind]) {
                int temp = arr[i];
                arr[i] = arr[ind];
                arr[ind] = temp;
                ind = i;
            }
        }
        quickSort(arr, start, ind);
        quickSort(arr, ind + 1, arr.length);
    }

    //binarySearch() method with recursion
    public static int binarySearch(int[] arr, int element, int left, int right) {

        int indx = (right + left) / 2;
        if (arr[indx] != element) {

            if (element < arr[indx])
                indx = binarySearch(arr, element, left, indx);
            else
                indx = binarySearch(arr, element, indx + 1, right);
        }

        return indx;

    }

    public static void mergeSort(int[] arr, int left, int right) {
        if ((right - left) < 1)
            return;

        int countL = (right + left) / 2 + 1;
        int countR = right - (right + left) / 2;
        int[] arrL = new int[countL];
        int[] arrR = new int[countR];

        for (int i = 0; i < countL; ++i)
            arrL[i] = arr[i + left];
        for (int i = 0; i < countR; ++i)
            arrR[i] = arr[countL + i];

        mergeSort(arrL, left, countL - 1);
        mergeSort(arrR, 0, countR - 1);

        //merge left and right arrays
        int r = 0;
        int l = 0;

        for (int i = left; i < right + 1; ++i) {
            if ((l < countL) && (r < countR)) {
                if (arrL[l] < arrR[r]) {
                    arr[i] = arrL[l];
                    ++l;
                } else {
                    arr[i] = arrR[r];
                    ++r;
                }
            } else {
                if (l < countL) {
                    arr[i] = arrL[l];
                    ++l;
                }
                if (r < countR) {
                    arr[i] = arrR[r];
                    ++r;
                }
            }
        }
    }

    //binarySearch() method with loop
    public static int binarySearch(int[]arr, int element){
        int indx = arr.length/2;
        while(element != arr[indx]){
            if(element < arr[indx])
                indx = indx/2;
            else
                indx = (arr.length+indx)/2;
        }
        return indx;
    }
}
