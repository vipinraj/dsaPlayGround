package datastructures.hashing;

import datastructures.linkedlist.LinkedList;
import datastructures.linkedlist.Node;

public class LinkedListHash<Type> {
	LinkedList<Type>[] hashTable = null;
	Integer size = 0;

	@SuppressWarnings("unchecked")
	public LinkedListHash(Integer size) {
		this.size = size;
		hashTable = new LinkedList[size];
	}

	public void insert(Type element) {

		String stringVal = element.toString();
		int hash = getHash(stringVal); 
		System.out.println();
		
		if(hashTable[hash] == null){
			hashTable[hash] = new LinkedList<Type>();
		}
				
		hashTable[hash].insert(new Node(element));
	}
	
	public Node<Type> search(Type element){
		Integer hashValue = getHash(element.toString());
		//search in the corresponding linkedList
		return hashTable[hashValue].search(element);
	}
	public void delete(Type element){
		
		Integer hashValue = getHash(element.toString());
		hashTable[hashValue].delete(search(element));
	}

	private Integer getHash(String key) {
		Integer radix128Val = 0;
		// calculate radix - 128 value
		for (int i = key.length() - 1; i >= 0; i--) {
			radix128Val += key.charAt(i) * (128 ^ ((key.length() - 1) - i));
		}
		System.out.println(radix128Val);

		return radix128Val % size;
	}
	public String toString(){
		String str = "";
		
		for(int i = 0; i < hashTable.length; i++){
			if(hashTable[i] != null){
				str += "\n" + i + "=" + hashTable[i].toString();
			}
		}
		
		return str;
	}
}
