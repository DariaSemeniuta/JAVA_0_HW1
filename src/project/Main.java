package project;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 3, -9, 5, 12, 9};
        int min = findMin(arr);
        int max = findMax(arr);
        System.out.println("Min of array is "+ min );
        System.out.println("Max of array is "+ max );
        
        bubbleSort(arr);
        
        quickSort(arr, 0, arr.length );
      
        for(int i=0; i < arr.length ; ++i){
            System.out.println(arr[i]);
        }
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

    public static void quickSort(int arr[], int start, int stop ) {
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
        quickSort(arr, ind+1, arr.length);
    }

}
