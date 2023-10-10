package DP;

public class DPQuestions {
/*  write a function to minimum step to reach 1 with the help of these 3 step:
        n-1
        n/2
        n/3
*/
    public static int minStepsTo1(int n){
        if(n == 1){
            return 0;
        }
        int ans1 = minStepsTo1(n-1);
        int ans2 = Integer.MAX_VALUE;
        if(n%2 == 0){
            ans2 = minStepsTo1(n/2);
        }
        int ans3 = Integer.MAX_VALUE;
        if(n%3 == 0){
            ans3 = minStepsTo1(n/3);
        }

        return Math.min(ans1,Math.min(ans2, ans3)) +1;
    }

// with the help of memoization
public static int minStepsTo1DP(int n, int []dp){
    if(n == 1){
        return 0;
    }
    int ans1;
    if(dp[n-1] == -1){
        ans1 = minStepsTo1DP(n-1, dp);
        dp[n-1] = ans1;
    }
    else{
        ans1 = dp[n-1];
    }
    int ans2 = Integer.MAX_VALUE;
    if(n%2 == 0){
        if(dp[n] == -1){
        ans2 = minStepsTo1DP(n/2,dp);
        dp[n] = ans2;
        }
        else{
            ans2 = dp[n];
        }
    }
    int ans3 = Integer.MAX_VALUE;
    if(n%3 == 0){
        if(dp[n] == -1){
            ans3 = minStepsTo1DP(n/3,dp);
            dp[n] = ans3;
            }
            else{
                ans3 = dp[n];
            }
        }

    return Math.min(ans1,Math.min(ans2, ans3)) +1;
}


/*  Minimum number of  sum of square to represent
*/
    public static int minSquares(int n){
        if( n == 0){
            return 0;
        }

        int minAns = Integer.MAX_VALUE;
        for(int i =1; i*i <= n; i++){
            int currAns = minSquares(n-(i*i));
            if(minAns > currAns){
                minAns = currAns;
            }
        }
        return minAns +1;
    }
// Applying memoization:
public static int minSquaresDP(int n, int []dp){
    if( n == 0){
        return 0;
    }

    int minAns = Integer.MAX_VALUE;
    for(int i =1; i*i <= n; i++){
        int currAns;
        if(dp[n-(i*i)] == -1){
        currAns = minSquares(n-(i*i));
        dp[n-(i*i)] = currAns;}
        else{
            currAns = dp[n-(i*i)];
        }
        if(minAns > currAns){
            minAns = currAns;
        }
    }
    return minAns +1;
}
// Applying iterative dynamic programing:
        public static int minSquaresI(int n){
            int [] dp = new int[n+1];
            dp[0] = 0;
            for(int i=1; i<=n; i++){
                int minAns = Integer.MAX_VALUE;
                for(int j=1; j*j <= i; j++){
                    int currAns = dp[i -(j*j)];
                    if(minAns > currAns){
                        minAns = currAns;
                    }
                }
                dp[i] = 1+minAns;
            }
            return dp[n];
        }



///////// best path to recive destination in given mxn matrix:
        public static int minCost(int[][] cost, int i, int j){
            int m = cost.length;
            int n = cost[0].length;
            // special case
            if(i == m-1 && j == n-1){
                return cost[i][j];
            }
            // base Case
            if(i>=m || j>=n){
                return Integer.MAX_VALUE;
            }

            int ans1 = minCost(cost, i+1, j);
            int ans2 = minCost(cost, i, j+1);
            int ans3 = minCost(cost, i+1, j+1);
            return cost[i][j] + Math.min(ans1, Math.min(ans2, ans3));
        }
// Applying memoization:
        public static int minCostDP(int[][] cost, int i, int j, int[] dp){
            return 0;
        }







    public static void main(String[] args) {
        /*
        System.out.println(minStepsTo1(5));

        int n =10;
        int [] dp = new int[n+1];
        for(int i =0; i<= n; i++){
            dp[i] = -1;
        }
        int ans = minStepsTo1DP(n, dp);
        System.out.println(ans);
        */

        /*System.out.println(minSquares(41 ));
        int n = 41;
        int dp[] = new int[n+1];
        for(int i =0; i<=n; i++){
            dp[i] = -1;
        }
        System.out.println(minSquares(n));
        System.out.println(minSquaresI(41));
        */

        int [][] cost = {{1,5,11}, {8,13,12},{2,3,7},{15,16,18}};
        int ans = minCost(cost, 0, 0);
        System.out.println(ans);
    }
}