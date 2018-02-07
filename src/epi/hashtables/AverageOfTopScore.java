//
package epi.hashtables;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

public class AverageOfTopScore {
    public static void main(String args[]) {
        List<Object> nameScoreData = new ArrayList<>();
        nameScoreData.add("adnan");
        nameScoreData.add(100);
        nameScoreData.add("amit");
        nameScoreData.add(99);
        nameScoreData.add("adnan");
        nameScoreData.add(98);
        nameScoreData.add("thl");
        nameScoreData.add(90);
        nameScoreData.add("adnan");
        nameScoreData.add(10);
        nameScoreData.add("amit");
        nameScoreData.add(100);
        nameScoreData.add("thl");
        nameScoreData.add(99);
        nameScoreData.add("thl");
        nameScoreData.add(95);
        nameScoreData.add("dd");
        nameScoreData.add(100);
        nameScoreData.add("dd");
        nameScoreData.add(100);
        nameScoreData.add("adnan");
        nameScoreData.add(99);
        String result = findStudentWithHighestBestOfThreeScores(nameScoreData.iterator());
        
        System.out.println(result);
    }
    
    // O(n), O(m)
    public static String findStudentWithHighestBestOfThreeScores(Iterator<Object> input) {
        Map<String, MarksWithAvg> studentsToMark = new HashMap<>();
        
        Double topAvg = Double.MIN_VALUE;
        String topAvgStudent = null;
        
        while (input.hasNext()) {
          String name = (String)input.next();
          Integer mark = (Integer)input.next();
          
          if (studentsToMark.containsKey(name)) {
            Double avg = studentsToMark.get(name).addMark(mark);
            if (avg != null && topAvg < avg) {
              topAvgStudent = name;
              topAvg = avg;
            }
          } else {
            MarksWithAvg marksWithAvg = new MarksWithAvg();
            marksWithAvg.addMark(mark);
            studentsToMark.put(name, marksWithAvg);
          }
        }
        return topAvgStudent;
    }
    
    static class MarksWithAvg {
      PriorityQueue<Integer> topThreeMarks;
      Double avg = 0.0;
      
      MarksWithAvg () {
        topThreeMarks = new PriorityQueue<Integer>();
      }
      
      public Double addMark(Integer m) {
        
        if (topThreeMarks.size() < 3 || topThreeMarks.size() == 3 && m > topThreeMarks.peek()) {
          topThreeMarks.add(m);
          avg += (double)m/3.0;
          if (topThreeMarks.size() > 3) {
            avg -= (double)topThreeMarks.poll()/3.0;
          }
        }
        
        if (topThreeMarks.size() == 3) {          
          return avg;
        } else {
          return null;
        }
      }
    }
}
