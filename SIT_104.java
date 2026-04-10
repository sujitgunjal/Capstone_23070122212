// CCTV Footage camera rotation...
// A security office stores the last few camera snapshots in an array.
// input: [101, 102, 103, 104, 105, 106]
//     k: 3
// output: [104, 105, 106, 101, 102, 103]

import java.util.Arrays;

public class SIT_104 {
    public static void main(String[] args) {
        int[] arr = {101, 102, 103, 104, 105, 106};
        int k = 3;

        rotate(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    static void rotate(int[] arr, int k){
        int n = arr.length;
        k = k % n; // Handle cases where k is greater than n

        reverse(arr, 0, n - 1);
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);

    }

    static void reverse(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}