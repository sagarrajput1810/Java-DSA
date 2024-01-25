package Practice;

import javax.sql.rowset.spi.SyncResolver;

public class ClassD {
    public static void main(String[] args) {
        ClassC a = new ClassC();
        a.num =10;
        a.num2 =20;
        a.num3 =30;
        System.out.println(a.sum());
    }    
}
