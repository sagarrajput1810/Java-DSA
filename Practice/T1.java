import java.util.*;
public class T1 {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int k=0; k<t;k++ ){
            String s = sc.nextLine();
            int l = s.length(), min =0, max =1;
            for(int i =0; i<l; i++){
                for(int j =l-1-i; j >i; j-- ){
                    if(isPlaindrom(s.substring(i,j))) {
                        if(max-min < j-i){
                            min = i;
                            max= j;
                        }
                    }
                }
            }
            System.out.println(s.substring(min,max));
            System.out.println(max-min);
        }
    }

    public static boolean isPlaindrom(String s){
        int l=s.length();
        for(int i=0; i< l/2; i++ ){
            if(s.charAt(i) != s.charAt(l-i-1)) return false;
        }
        return true;
    }
}