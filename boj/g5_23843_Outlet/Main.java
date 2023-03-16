package g5_23843_Outlet;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 전자기기의 개수
    int M = Integer.parseInt(st.nextToken()); // 콘센트의 개수
    PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> e2 - e1);
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int t = Integer.parseInt(st.nextToken());
      pq.offer(t);
    }
    PriorityQueue<Integer> outlets = new PriorityQueue<>();
    int answer = 0;
    for (int i = 0; i < N; i++) {
      int last = pq.poll();
      if (outlets.size() >= M) {
        last += outlets.poll();
      }
      outlets.add(last);
      answer = Math.max(answer, last);
    }
    System.out.println(answer);
  }
}
