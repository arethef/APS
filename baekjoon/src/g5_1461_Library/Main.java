package g5_1461_Library;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 책개수
    int M = Integer.parseInt(st.nextToken()); // 한최몇
    PriorityQueue<Integer> ppq = new PriorityQueue<>((p1, p2) -> p2 - p1);
    PriorityQueue<Integer> npq = new PriorityQueue<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      if (num > 0) {
        ppq.offer(num);
      } else {
        npq.offer(num);
      }
    }

    int pMax = ppq.peek() != null ? ppq.peek() : 0;
    int nMax = npq.peek() != null ? npq.peek() : 0;

    int answer = 0;
    int idx = 0;
    while (!ppq.isEmpty()) {
      int curr = ppq.peek();
      if (ppq.size() < M) {
        answer += 2 * Math.abs(curr);
        break;
      }
      answer += 2 * Math.abs(curr);
      while (!ppq.isEmpty() && idx < M) {
        ppq.poll();
        idx++;
      }
      idx = 0;
    }
    idx = 0;
    while (!npq.isEmpty()) {
      int curr = npq.peek();
      if (npq.size() < M) {
        answer += 2 * Math.abs(curr);
        break;
      }
      answer += 2 * Math.abs(curr);
      while (!npq.isEmpty() && idx < M) {
        npq.poll();
        idx++;
      }
      idx = 0;
    }

    if (Math.abs(pMax) > Math.abs(nMax)) {
      answer -= Math.abs(pMax);
    } else {
      answer -= Math.abs(nMax);
    }

    System.out.println(answer);
  }
}
