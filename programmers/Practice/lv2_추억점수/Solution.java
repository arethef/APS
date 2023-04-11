package Practice.lv2_추억점수;

import java.util.*;

public class Solution {
  public static void main(String[] args) {
    String[] name = { "may", "kein", "kain", "radi" };
    int[] yearning = { 5, 10, 1, 3 };
    String[][] photo = {
        { "may", "kein", "kain", "radi" }, { "may", "kein", "brin", "deny" }, { "kon", "kain", "may", "coni" }
    };
    System.out.println(solution(name, yearning, photo));
  }

  public static ArrayList<Integer> solution(String[] name, int[] yearning, String[][] photo) {
    ArrayList<Integer> list = new ArrayList<>();
    HashMap<String, Integer> scores = new HashMap<>();
    for (int i = 0; i < name.length; i++) {
      scores.put(name[i], yearning[i]);
    }
    for (String[] people : photo) {
      int sum = 0;
      for (String person : people) {
        sum += scores.getOrDefault(person, 0);
      }
      list.add(sum);
    }
    return list;
  }
}
