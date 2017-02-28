package datastructures.hashing;

public class TestHash {

	public static void main(String[] args) {
		
		LinkedListHash<String> hashTable = new LinkedListHash<>(20);
		hashTable.insert("one");
		hashTable.insert("two");
		hashTable.insert("one2");
		hashTable.insert("three");
		hashTable.insert("four");
		hashTable.insert("five");
		hashTable.insert("six");
		hashTable.insert("seven");
		hashTable.insert("one1");
		hashTable.insert("two1");
		hashTable.insert("one21");
		hashTable.insert("three1");
		hashTable.insert("four1");
		hashTable.insert("five1");
		hashTable.insert("six1");
		hashTable.insert("seven1");
		System.out.println(hashTable.search("one").getData());
		System.out.println(hashTable.toString());
		hashTable.delete("two1");
		System.out.println(hashTable.toString());
		
		
		System.out.println("-------------------LinearProingHash---------------------");
		LinearProingHash<String> lpHash = new LinearProingHash<>(6);
		
		lpHash.insert("one");
		lpHash.insert("two");
		lpHash.insert("three");
		lpHash.insert("four");
		lpHash.insert("five");
		lpHash.insert("six");
		System.out.println(lpHash.toString());
		System.out.println(lpHash.search("two"));

		
	}

}
