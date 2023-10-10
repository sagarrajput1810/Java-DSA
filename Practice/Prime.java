package Practice;

import java.util.HashMap;

import javax.sound.sampled.SourceDataLine;

public class Prime {
    public static int nextPrime(int val){
            for(int i =2; i<=val/2; i++){
                if(val %i == 0){
                    val ++;
                    i = 1;
                }
            }
            return val;
    }

    public static void main(String[] args) {
        System.out.println(nextPrime(14));
    System.out.println("hello");
    }
}