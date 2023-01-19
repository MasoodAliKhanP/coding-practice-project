package com.google.code._0_Concepts;

public class _1_HashMapWorking {
//	HashMap<K, V> is a part of Java’s collection since Java 1.2. This class is found in java.util package. It provides the basic implementation of the Map interface of Java. It stores the data in (Key, Value) pairs, 
//
//	HashMap is similar to HashTable, but it is unsynchronized. 
//
//	public class HashMap<K,V> extends AbstractMap<K,V>
//	                          implements Map<K,V>, Cloneable, Serializable
//
//
//	Constructors in HashMap is as follows:
//	HashMap provides 4 constructors and the access modifier of each is public which are listed as follows:
//
//	HashMap()
//	HashMap(int initialCapacity)
//	HashMap(int initialCapacity, float loadFactor)
//	HashMap(Map map)
//
//
//	Performance of HashMap depends on 2 parameters which are named as follows:
//
//	Initial Capacity
//	Load Factor
//	1. Initial Capacity – It is the capacity of HashMap at the time of its creation (It is the number of buckets a HashMap can hold when the HashMap is instantiated). In java, it is 2^4=16 initially, meaning it can hold 16 key-value pairs.
//
//	2. Load Factor – It is the percent value of the capacity after which the capacity of Hashmap is to be increased (It is the percentage fill of buckets after which Rehashing takes place). In java, it is 0.75f by default, meaning the rehashing takes place after filling 75% of the capacity.
//
//	3. Threshold – It is the product of Load Factor and Initial Capacity. In java, by default, it is (16 * 0.75 = 12). That is, Rehashing takes place after inserting 12 key-value pairs into the HashMap.
//
//	4. Rehashing – It is the process of doubling the capacity of the HashMap after it reaches its Threshold. In java, HashMap continues to rehash(by default) in the following sequence – 2^4, 2^5, 2^6, 2^7, …. so on. 
//
//
//	Note: From Java 8 onward, Java has started using Self Balancing BST instead of a linked list for chaining.
//
//
//	Collections.synchronizedMap() to make HashMap synchronized 
//	
//	
//		HashMap contains an array of Node and Node can represent a class having the following objects : 
//
//		int hash
//		K key
//		V value
//		Node next
//
//		Hashing
//		Hashing is a process of converting an object into integer form by using the method hashCode()
//
//		hashCode() method: hashCode() method is used to get the hash code of an object. hashCode() method of the object class returns the memory reference of an object in integer form
//
//
//		equals() method: This method is used to check whether 2 objects are equal or not. 
//
//		Buckets: A bucket is an element of the HashMap array. It is used to store nodes. Two or more nodes can have the same bucket. 
//		capacity = number of buckets * load factor
//
//
//		Index Calculation in Hashmap
//		The Hash code of the key may be large enough to create an array. 
//		index = hashCode(key) & (n-1).
//
//
//
//		map.put(new Key("vishal"), 20);
//		Steps: 
//		Calculate hash code of Key {“vishal”}. It will be generated as 118.
//		Calculate index by using index method it will be 6.
//		Create a node object as : 
//		{
//		  int hash = 118
//
//		  // {"vishal"} is not a string but 
//		  // an object of class Key
//		  Key key = {"vishal"}
//
//		  Integer value = 20
//		  Node next = null
//		}
//		Place this object at index 6, if no other object is presented there.
//
//
//		map.put(new Key("vaibhav"), 40);
//		Steps: 
//		Calculate hash code of Key {“vaibhav”}. It will be generated as 118.
//		Calculate index by using index method it will be 6.
//		Create a node object as :
//		 {
//		  int hash = 118
//		  Key key = {"vaibhav"}
//		  Integer value = 40
//		  Node next = null
//		}
//		Place this object at index 6 if no other object is presented there.
//		In this case, a node object is found at index 6 – this is a case of collision.
//		In that case, check via the hashCode() and equals() method if both the keys are the same.
//		If keys are the same, replace the value with the current value.
//		Otherwise, connect this node object to the previous node object via linked list and both are stored at index 6. 
//
//
//
//
//		Using the get method()
//
//		Now let’s try some get methods to get a value. get(K key) method is used to get a value by its key. If you don’t know the key then it is not possible to fetch a value. 
//
//		Fetch the data for key sachin:
//		map.get(new Key("sachin"));
//		Steps: 
//		Calculate hash code of Key {“sachin”}. It will be generated as 115.
//		Calculate index by using index method it will be 3.
//		Go to index 3 of the array and compare the first element’s key with the given key. If both are equals then return the value, otherwise, check for the next element if it exists.
//		In our case, it is found as the first element and the returned value is 30.
//		Fetch the data for key vaibhav: 
//		map.get(new Key("vaibhav"));
//		Steps: 
//		Calculate hash code of Key {“vaibhav”}. It will be generated as 118.
//		Calculate index by using index method it will be 6.
//		Go to index 6 of the array and compare the first element’s key with the given key. If both are equals then return the value, otherwise, check for the next element if it exists.
//		In our case, it is not found as the first element and the next node object is not null.
//		If the next node is null then return null.
//		If the next of node is not null traverse to the second element and repeat process 3 until the key is not found or next is not null.
//		Time complexity is almost constant for the put and the get method until rehashing is not done.
//		In case of collision, i.e. index of two or more nodes are the same, nodes are joined by a link list i.e. the second node is referenced by the first node and the third by the second, and so on.
//		If the key given already exist in HashMap, the value is replaced with the new value.
//		hash code of the null key is 0.
//		When getting an object with its key, the linked list is traversed until the key matches or null is found on the next field.
}
