package g4_1744_NumberTie;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> npq = new PriorityQueue<>();
    PriorityQueue<Integer> ppq = new PriorityQueue<>((e1, e2) -> e2 - e1);
    int cnt0 = 0; // 0 개수
    int cntN = 0; // 음수 개수
    int cntP = 0; // 양수 개수
    int cnt1 = 0; // 1 개수
    for (int i = 0; i < N; i++) {
      int number = Integer.parseInt(br.readLine());
      if (number == 0) {
        cnt0++;
      } else if (number < 0) {
        npq.offer(number);
        cntN++;
      } else if (number == 1) {
        cnt1++;
      } else {
        ppq.offer(number);
        cntP++;
      }
    }
    int answer = 0;
    answer += cnt1;

    if (cntN % 2 == 0) {
      while (!npq.isEmpty()) {
        answer += npq.poll() * npq.poll();
      }
    } else {
      if (cnt0 > 0) {
        while (npq.size() > 1) {
          answer += npq.poll() * npq.poll();
        }
        npq.poll();
      } else {
        while (npq.size() > 1) {
          answer += npq.poll() * npq.poll();
        }
        answer += npq.poll();
      }
    }

    if (cntP % 2 == 0) {
      while (!ppq.isEmpty()) {
        answer += ppq.poll() * ppq.poll();
      }
    } else {
      while (ppq.size() > 1) {
        answer += ppq.poll() * ppq.poll();
      }
      answer += ppq.poll();
    }

    System.out.println(answer);
  }
}
