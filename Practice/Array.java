package Practice;

import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        int n = arr.length, m = arr[0].length;
        for(int i=0; i < m; i++){
            if(i % 2 == 0){
           for(int j=0; j< n; j++){
                
                    System.out.print(arr[j][i]);
                }}
                else{
                    for(int j=0; j< n; j++){
                    System.err.print(arr[n-j-1][i]);
                }
           }
        }
    } 
}
