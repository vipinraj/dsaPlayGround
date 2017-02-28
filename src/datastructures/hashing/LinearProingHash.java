package datastructures.hashing;

/**
 * @author vipin
 *	Delete is not implemented. Will have to use a flag to denote deleted slots
 * @param <Type>
 */
public class LinearProingHash<Type> {
	Type[] hashTable = null;
	Integer size = 0;

	@SuppressWarnings("unchecked")
	public LinearProingHash(Integer size) {
		this.size = size;
		hashTable = (Type[]) new Object[size];
	}

	public void insert(Type key) {

		Integer hash = getHash(key.toString());
		int currentHash = hash;
		while (hashTable[currentHash] != null) {
			currentHash = (currentHash + 1) % size;
			if (currentHash == hash) {
				break;
			}
		}
		if (hashTable[currentHash] == null) {
			hashTable[currentHash] = key;
		}
	}

	public Type search(Type key) {
		Integer hash = getHash(key.toString());
		int currentHash = hash;
		boolean found = true;
		while (hashTable[currentHash] != key) {
			currentHash = (currentHash + 1) % size;
			if (currentHash == hash) {
				found = false;
				break;
			}
		}
		if (found) {
			return hashTable[currentHash];
		} else {
			return null;
		}
	}

	private Integer getHash(String key) {
		Integer radix128Val = 0;
		// calculate radix - 128 value
		for (int i = key.length() - 1; i >= 0; i--) {
			radix128Val += key.charAt(i) * (128 ^ ((key.length() - 1) - i));
		}
		//System.out.println(radix128Val);

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
