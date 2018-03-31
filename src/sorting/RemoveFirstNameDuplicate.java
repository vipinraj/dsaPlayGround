package sorting;
import java.util.List;
import java.util.ArrayList;
import java.lang.Comparable;
import java.util.Collections;

/**
 * 14.3
 */
public class RemoveFirstNameDuplicate {
  
  
  public static void main(String[] args) { 
    List<Name> names = new ArrayList<>();
    names.add(new Name("Ian", "Botham"));
    names.add(new Name("David", "Gower"));
    names.add(new Name("Ian", "Bell"));
    names.add(new Name("Ian", "Chappel"));
    removeDuplicates(names);
    System.out.println(names);
  }
  
  public static void removeDuplicates(List<Name> names) {
    Collections.sort(names);
    
    int resultIdx = 0;
    
    for (int i = 1; i < names.size(); i++) {
      if (!names.get(i).first.equals(names.get(resultIdx).first)) {
        names.set(++resultIdx, names.get(i));
      }
    }
    
    names.subList(++resultIdx, names.size()).clear();
    
  }
}



class Name implements Comparable<Name> {
  String first;
  String last;
  
  Name(String first, String last) {
    this.first = first;
    this.last = last;
  }
  
  public int compareTo(Name that) {
    return this.first.compareTo(that.first);
  }

  public String toString() {
    return first + " " + last;
  }
}