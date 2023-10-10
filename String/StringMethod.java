package String;

import java.util.Scanner;

public class StringMethod {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String string  = s.next();
        String str1 = "Sagar";
        // It returns length of the string
        int l = str1.length(); 
        // It returns character at given index
        char c = str1.charAt(2); 
        // Concatinate two string 
        str1 = str1 + " Rajput"; 
        // this function also concatinate two string both are same
        str1 = str1.concat(" Bhai");
        System.out.println(l+" "+c+" "+str1);
        // This function compare two string and return boolean value
        boolean check = str1.equals("Sagar Rajput Bhai");
        //this function also compare two string but it return difference in ASCII value
        int i = str1.compareTo("Sagar");
        // this function check string 2 present in string 1 a d return boolean value
        boolean check1 = str1.contains("aga");
        //this function return subsrting for the given index;
        String str2 = str1.substring(2);
        str2 = str1.substring(2, 7);


    }
    
}
