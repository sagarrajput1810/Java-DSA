package Practice;

public class Bitwise {
    public static void main(String[] args) {
        
        // add one to an Integer
        int n =10;
        System.out.println(n|1);

        // off tha k'th bit
        int p =20, k =3;
        System.out.println(p&(~(1<<(k-1)))); 

        //
    }
}
