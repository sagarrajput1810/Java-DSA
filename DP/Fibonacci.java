package DP;

import java.util.Scanner;

/*
 *  In dynamic programing we stored data for further use this technique decrease time complexicity but 
 * increase memory compexcity.
 * 
 * 
 */
public class Fibonacci {

// this fibonacci function without DP:
    public static int fibonacci(int n){
        if(n == 0 || n == 1){
            return n;
        }
        int ans1 = fibonacci(n-1);
        int ans2 = fibonacci(n-2);
        return ans1 +ans2;
    }

// this fibonacci function with DP:
    public static int fibonacciDP(int n, int dp[]){
        if(n==0 ||n==1){
            return n;
        }
        int ans1, ans2;
        if(dp[n-1] == -1){
            ans1 = fibonacciDP(n-1, dp);
            dp[n-1] = ans1;
        }else{
            ans1 = dp[n-1];
        }
        if(dp[n-2] == -1){
            ans2 = fibonacciDP(n-2, dp);
            dp[n-2] = ans2;
        }else{
            ans2 = dp[n-2];
        }

        return  ans1 +ans2;
    }
// this process called memoization = recursion + storing data;

// this function in the formof iterative dynamic programing way:
    public static int fibonacciI(int n){
        if(n==0 || n==1){
            return n;
        }
        int [] dp = new int[n+1];
        dp[0]=0;
        dp [1]= 1;
        for(int i = 2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
         return dp[n];
    }
// reccursion use Stack in which function calls in waiting for base case. if waiting calls is more then 10*4 the it gives Stack owerflow;
// But in iterative dynamic programing it stores data so this better then reccursive code.
//IF in function memoization can apply then iterative dp can also apply.


public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n =s.nextInt();
    int [] dp = new int[n+1];
    for(int i = 0; i<dp.length; i++){
        dp[i] = -1;
    }
    System.out.println(fibonacci(n));
    System.out.println(fibonacciDP(n, dp));
}
}
