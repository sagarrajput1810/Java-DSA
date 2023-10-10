package Hashmap;

import java.util.HashMap;
import java.util.Set;

public class InbuiltMapCollection {
/*  there are two types of map:
        Tree map: which create by BST
                time complexcity- O(log n)
        Hash map: this same as python's Dictionary. 
                time complexcity- O(1)
                syntax- HashMap<keyDataType, ValueDataType> name = new HasHmMap<>();
*/

    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();

        // Insert function - name.put(Key , Value);
        map.put("abc",1);
        map.put("def", 3);
            // this function also use for update value.



        // for check  Key exist or not function - name.containKey(key);
        if(map.containsKey("abc")){
            System.out.println("Map have abc");
        }

        // Get-Value Function- name.get(key);
        System.out.println(map.get("def"));
            /*  if key is not exist in Hashmap then it give null pointer exception
                because value is an integer type which is non-primitive data type 
                which store integer's address.
            */


        // Remove key function- name.remove(key);
        map.remove("abc1");
            //if key is not exist then its do nothing
        
        // get numbers of keys- name.size();
        System.out.println(map.size());


        /*
        Iterate:
        Syntax - name.KeySet();
        For this we use Set class which same like python's set function 
        syntax- Set <dataType> keys = map.KeySet();
        - all values of set is unique
        */ 
        Set<String> keys = map.keySet();
        for(String s : keys){
            System.out.println(s + " : "+ map.get(s));
        }
    }
}
