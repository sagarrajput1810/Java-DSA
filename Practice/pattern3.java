package Practice;

public class pattern3 {
    public static void main(String[] args) {
        int n = 9;
    for(int i=0; i<n/2; i++){
        for(int j =0; j<n ; j++ ){
            if(j > (n/2-i) && j < (n/2 +i)){
                System.out.print("  ");
            }
            else{
                System.out.print("* ");
            }
        }
        System.out.println();
    }
    for(int i=0; i<=n/2; i++){
        for(int j =0; j<n ; j++ ){
            if(j >i && j < (n -i-1)){
                System.out.print("  ");
            }
            else{
                System.out.print("* ");
            }
        }
        System.out.println();
    }
    }
}
