package g2_1781_CupRamyun;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st;
    PriorityQueue<Problem> input = new PriorityQueue<>(
        (p1, p2) -> p1.d != p2.d ? p1.d - p2.d : Long.compare(p2.r, p1.r));
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int d = Integer.parseInt(st.nextToken());
      long r = Integer.parseInt(st.nextToken());
      input.offer(new Problem(d, r));
    }
    long answer = 0;
    int idx = 0; // 날짜
    PriorityQueue<Long> ramyuns = new PriorityQueue<>(); // 문제 풀고 얻을 라면 수
    while (!input.isEmpty()) {
      Problem curr = input.poll();
      if (idx == 0) {
        idx++;
        answer += curr.r;
        ramyuns.offer(curr.r);
      } else {
        if (idx < curr.d) { // 마지막 데드라인이 이번 문제의 데드라인보다 앞이면
          idx++;
          answer += curr.r;
          ramyuns.offer(curr.r);
        } else {
          if (ramyuns.peek() < curr.r) { // 이전까지 푼 문제 중 가장 적은 라면 수가 현재 라면수보다 적다면
            answer -= ramyuns.poll();
            answer += curr.r;
            ramyuns.offer(curr.r);
          }
        }
      }
    }
    System.out.println(answer);
    br.close();
  }

  static class Problem {
    int d; // 데드라인
    long r; // 컵라면 수

    Problem(int d, long r) {
      this.d = d;
      this.r = r;
    }

    @Override
    public String toString() {
      return "Problem [d:" + d + ", r:" + r + "]";
    }
  }
}
