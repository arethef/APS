package g1_16238_Eagle;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    PriorityQueue<Integer> s = new PriorityQueue<>((s1, s2) -> s2 - s1);
    for (int i = 0; i < N; i++) {
      s.offer(Integer.parseInt(st.nextToken()));
    }

    int eat = 0;

    int day = 0;
    while (!s.isEmpty()) {
      int curr = s.poll();
      if (curr - day > 0) {
        eat += curr - day;
      } else {
        break;
      }
      day++;
    }

    System.out.println(eat);
  }
}
