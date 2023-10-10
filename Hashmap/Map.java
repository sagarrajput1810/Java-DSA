package Hashmap;

import java.util.ArrayList;

/*
HASHMAP:
	for hashmap we want two things : 1 - Hash Function  2 - compresstion
	
	HASH FUNCTION: 
			This function give an Integer of any DataType. Java have own Hash Function but we create a Hash Function;

	COMPRESSION:
			This Function is save the key in array. this a Moduler of HashFunction's Integer by the size of array.
			
			but in this process we face problem when same reminder is return then it Delete perivious Value this is called Collition.

			COLLITION HANDALING:
				There are two Method to Handle the collition: 1 - Closed Hasing  2 - open Addressing

				CLOSED HASHING:
					In this technique we attach an linked list in every element of array then infinite element save in same index.

				OPEN ADDRESSING:
					In this technique we check other Empty index so we have many method :
						1- linear probing - check one-by-one
						2- quadratic probing - check quadracic distance
						3- double hashing - multiply by i integer by hashing integer and check index

Load Factor : LF is the ratio of number of entries and bucket size;
            MAKE SURE Load factor is always less the 0.7;
Rehashing - increase the bucket size to maintain the lf < 0.7.
            
 */
public class Map<k,v> {
    ArrayList<MapNode<k,v>> buckets;
    int count; // this variablr save the size of hash map
    int numBuckets; // this variable use for fix the size of array
    public Map(){
        buckets = new ArrayList<>();
        numBuckets = 20;
        for(int i = 0; i<numBuckets ; i++){
            buckets.add(null);
        }
    }

// Insert function so store the key we want bucket index called Hash Function
    public void insert(k key, v value){
        int bucketIndex = getBucketIndex(key);
        MapNode<k,v> head = buckets.get(bucketIndex);
        // element is already there? just update its value
        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        // element is not there. insert at oth position of linked list
        head = buckets.get(bucketIndex);
        MapNode <k, v> newNode = new MapNode<>(key, value);
        newNode.next = head;
        buckets.set(bucketIndex, newNode);
        count++;

        double loadFactor = (1.0*count)/numBuckets;
        if(loadFactor > 0.7){
            reHash();
        }
    } 

    /*  Hash Function:
            this function already present in java for its data type like if k is string then 
            string's hash function called;
    */
    private int getBucketIndex(k key){
        int hc = key.hashCode();
        int index = hc%numBuckets;
        return index;
    }

    private void reHash() {
        ArrayList<MapNode<k,v>> temp = buckets;
        buckets = new ArrayList<>();
        for ( int i=0; i<2*numBuckets; i++){
            buckets.add(null);
        }
        count = 0;
        numBuckets = numBuckets*2;
        for(int i=0; i< temp.size();i++){
            MapNode<k,v> head = temp.get(i);
            while(head != null){
                k key = head.key;
                v value = head.value;
                insert(key,value);
                head = head.next;
            }
        }
    }

//  Size Function:
    public int size(){
        return count;
    }

// get value function:
    public v getValue(k key){
        int bucketIndex = getBucketIndex(key);
        MapNode<k,v> head = buckets.get(bucketIndex);
        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
         return null;

    }

// remove function- this function return value which can remove
    public v removeKey(k key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<k,v> head = buckets.get(bucketIndex);
        MapNode<k,v> prev = null;
        v temp;
        while(head != null){
            if(head.key.equals(key)){
                temp = head.value; 
                if(prev != null){
                    prev.next = head.next;
                }else{
                    buckets.set(bucketIndex, head.next);
                }
                count--;
                return temp;
            }
            prev = head;
            head = head.next;
        }
         return null;
    }
    
}