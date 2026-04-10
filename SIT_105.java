// You're given an array A of n integers and q queris.
// Each query can be of the following types:
// * Type 1 Query: (1, l, r) - Replace A[i] with
//   (i-l+1)*A[l] for each index i, while l <= i <= r.
// * Type 2 Query: (2, l, r) - Calculate the sum of the
// elements in A from index l to index r.

// Find the sum of answers to all type 2 queries. Since
// answer can be large, return it modulo 109+7.

import java.util.Scanner;

public class SIT_105 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of the Array:");
        int n = sc.nextInt();

        int[] A = new int[n];
        System.out.println("Enter the Elements of the Array:");
        for(int i = 0; i < n; i++){
            System.out.println("Enter "+(i+1)+"th Element:");
            A[i] = sc.nextInt();
        }

        System.out.println("\nEnter total Queries:");
        int query = sc.nextInt();
        int totalSum = 0;

        for(int q = 1; q <= query; q++){
            System.out.println("\nEnter the Type of "+q+"th Query: ");
            int type = sc.nextInt();
            System.out.println("Enter the starting index of "+q+"th Query:");
            int L = sc.nextInt();
            System.out.println("Enter the ending index of "+q+"th Query:");
            int R = sc.nextInt();

            if (type == 1) { // Replace the array from L to R
                for (int i = L; i <= R; i++) {
                    A[i] = ((i - L + 1) * A[L]);
                }
            } else if (type == 2) { // Sum of the array from L to R
                int sum = 0;
                for (int i = L; i <= R; i++) {
                    sum += A[i];
                }
                totalSum += sum;
            }
        }

        System.out.println("Total Sum of Type 2 Query Answers: " + totalSum);
        sc.close();
    }
}