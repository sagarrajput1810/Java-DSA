package Practice;

import java.util.Scanner;

public class pattern1 {
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n/2; i++){
            for(int j =0; j<n ; j++ ){
                if(j >= (n/2-i) && j <= (n/2 +i)){
                    System.out.print("    *");
                }
                else{
                    System.out.print("     ");
                }
            }
            System.out.println();
        }
        for(int i=0; i<=n/2; i++){
            for(int j =0; j<n ; j++ ){
                if(j >= i && j <= (n -i-1)){
                    System.out.print("    *");
                }
                else{
                    System.out.print("     ");
                }
            }
            System.out.println();
        }
    }
}
