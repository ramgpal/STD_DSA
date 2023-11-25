import java.util.*;
public class setMatrixZeroes {

// Brute Force Approach -> ((n*m) * (n+m)) + (n*m) ~= O(n^3) 
    public static void matrixZeroes(int arr[][]) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == 0) {
                    // setting adjacent row to zero
                    for(int t = 0; t < arr[i].length; t++) {
                        if(arr[i][t] != 0) 
                        arr[i][t] = -1;
                    }
                    // setting adjacent column to zero
                    for(int t = 0; t < arr.length; t++) {
                        if(arr[t][j] != 0) 
                        arr[t][j] = -1;
                }
            }
        }
    }
    }

// Some Optimized -> TC - O(n*m) , SC - n + m ~= O(n)
    public static void matrixZeroesOptimized(int arr[][]) {
        int n = arr.length; // no of rows in matrix
        int m = arr[0].length; // no of cols in matrix
        boolean rows[] = new boolean[n];
        boolean cols[] = new boolean[m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 0) {
                    // marking ith row as true
                    rows[i] = true;
                    // marking jth cols as true
                    cols[j] = true;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(rows[i] == true) {
                for(int j = 0; j < m; j++) {
                    arr[i][j] = 0;
                }
            }
        }

    // Cols[] containing true will be causing whole column in arr[][] to be zero 
        for(int j = 0; j < m; j++) {
            if(cols[j] == true) {
                for(int i = 0; i < n; i++) {
                    arr[i][j] = 0; 
                }
            }
        }
    }
public static void main(String[] args) {
        int arr[][] = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        // matrixZeroes(arr);
        // for(int i = 0; i < arr.length; i++) {
        //     for(int j = 0; j < arr[i].length; j++) {
        //         if(arr[i][j] == -1) {
        //             arr[i][j] = 0;
        //         }
        //         System.out.print(arr[i][j]+" ");
        //     }
        //     System.err.println();
        // }

        matrixZeroesOptimized(arr);
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }
    }
}
