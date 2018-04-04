package epi.sorting;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 14.4
 */
public class CalendarMaximumSimultaneousEvents {
  
  public static void main(String[] args) { 
    Event e1 = new Event(1, 5);
    Event e2 = new Event(6, 10);
    Event e3 = new Event(11, 13);
    Event e4 = new Event(14, 15);
    Event e5 = new Event(2, 7);
    Event e6 = new Event(8, 9);
    Event e7 = new Event(12, 15);
    Event e8 = new Event(4, 5);
    Event e9 = new Event(9, 17);
    
    List<Event> events = new ArrayList<Event>();
    events.add(e1);
    events.add(e2);
    events.add(e3);
    events.add(e4);
    events.add(e5);
    events.add(e6);
    events.add(e7);
    events.add(e8);
    events.add(e9);
    
    System.out.println(findMaximumSimultaneousEvents(events));
  }
  
  public static int findMaximumSimultaneousEvents(List<Event> events) {
    List<Endpoint> endpoints = new ArrayList<>();
    
    for(Event event : events) {
      endpoints.add(new Endpoint(event.start, true));
      endpoints.add(new Endpoint(event.finish, false));
    }
    
    Collections.sort(endpoints);
    
    int maximum = 0;
    int count = 0;
    for (Endpoint ep : endpoints) {
      if (ep.isStart) {
        count++;
        maximum = Math.max(maximum, count);
      } else {
        count--;
      }
    }
    
    return maximum;
  }
  
}

class Event {
  int start;
  int finish;
  
  Event(int start, int finish) {
    this.start = start;
    this.finish = finish;
  }
}

class Endpoint implements Comparable<Endpoint> {
  int time;
  boolean isStart;
  
  Endpoint(int time, boolean isStart) {
    this.time = time;
    this.isStart = isStart;
  }
  
  public int compareTo(Endpoint that) {
    if (this.time != that.time) {
      return Integer.compare(this.time, that.time);
    }
    
    if (this.isStart && !that.isStart) {
      return -1;
    } else if (!this.isStart && that.isStart) {
      return 1;
    } else {
      return 0;
    }
  }
}