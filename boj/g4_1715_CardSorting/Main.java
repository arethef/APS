package g4_1715_CardSorting;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Long> pq = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      pq.add(Long.parseLong(br.readLine()));
    }
    long answer = 0;
    while (pq.size() > 1) {
      long c1 = pq.poll();
      long c2 = pq.poll();
      answer += c1 + c2;
      pq.add(c1 + c2);
    }
    System.out.println(answer);
  }
}
