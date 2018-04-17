// 14.7

package epi.sorting;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class PartitionArray {
	public static void main (String args[]) {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Greg", 14));
		persons.add(new Person("John", 12));
		persons.add(new Person("Andy", 11));
		persons.add(new Person("Jim", 13));
		persons.add(new Person("Phil", 12));
		persons.add(new Person("Bob", 13));
		persons.add(new Person("Chip", 13));
		persons.add(new Person("Tim", 14));
		groupByAge(persons);

		for (Person p : persons) {
			System.out.print(p + ", ");
		}
	}

	public static void groupByAge(List<Person> persons) {
		Map<Integer, Integer> ageToCount = new HashMap<>();
		Map<Integer, Integer> ageToOffset = new HashMap<>();

		for (Person p : persons) {
			if (ageToCount.containsKey(p.age)) {
				ageToCount.put(p.age, ageToCount.get(p.age) + 1);
			} else {
				ageToCount.put(p.age, 1);
			}
		}

		int offset = 0;
		for (Map.Entry<Integer, Integer> e : ageToCount.entrySet()) {
			ageToOffset.put(e.getKey(), offset);
			offset = e.getValue() + offset;
		}

		while (!ageToOffset.isEmpty()) {
			Map.Entry<Integer, Integer> entry = ageToOffset.entrySet().iterator().next();
			int offset1 = entry.getValue();
			Person p = persons.get(offset1);
			int idx1 = ageToOffset.get(p.age);
			Collections.swap(persons, offset1, idx1);
			ageToOffset.put(p.age, ageToOffset.get(p.age) + 1);
			ageToCount.put(p.age, ageToCount.get(p.age) - 1);
			
			if (ageToCount.get(p.age) == 0) {
				ageToOffset.remove(p.age);
			}

		}
	}
}

class Person {
	String name;
	int age;
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String toString() {
		return "(" + this.name + "," + this.age + ")";
	}
}