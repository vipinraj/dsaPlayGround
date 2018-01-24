/**
 * Auto Generated Java Class.
 */
package epi.hashtables;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class MergeContacts {
  
  
  public static void main(String[] args) { 
        List<ContactList> contacts
        = Arrays.asList(new ContactList(Arrays.asList("a", "b", "c")),
                        new ContactList(Arrays.asList("a", "c", "b")),
                        new ContactList(Arrays.asList("b", "c", "d")));
    List<ContactList> result = mergeContacts(contacts);
    for (ContactList l : result) {
      System.out.println(l);
    }
  }
  
  public static List<ContactList> mergeContacts(List<ContactList> l) {
    return new ArrayList(new HashSet(l));
  }
  
  public static class ContactList {
    public List<String> names;
    
    ContactList(List<String> names) {
      this.names = names;
    }
    
    @Override
    public boolean equals(Object o) {
      if (o == null || !(o instanceof ContactList)) {
        return false;
      }
      return this == o ? true : new HashSet(this.names).equals(new HashSet(((ContactList)o).names));
    }
    
    @Override
    public int hashCode() {
      return new HashSet(names).hashCode();
    }
    
    @Override
    public String toString() {
      StringBuilder str = new StringBuilder();;
      for (String s : names) {
        str.append(s + ",");
      }
      return str.toString();
    }
  }
  
}
