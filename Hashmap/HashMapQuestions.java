package Hashmap;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapQuestions {
    public static void main(String[] args) {
// Remove Duplicate elements from the array and give output:
        int arr[] = {1,2,4,2,1,5,6,3,3,5,5,1};
        ArrayList<Integer> array = removeDuplicate(arr);
        for(int i : array){
            System.out.println(i);
        }
    }
    private static ArrayList<Integer> removeDuplicate(int[] arr) {
        ArrayList<Integer> array = new ArrayList<>();
        HashMap<Integer, Boolean> rd = new HashMap<>();
        for(int i : arr){
            if(!rd.containsKey(i)){
                array.add(i);}
            rd.put(i,true);
        }
        return array;
    }
}
