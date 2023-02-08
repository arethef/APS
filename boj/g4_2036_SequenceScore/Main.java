package g4_2036_SequenceScore;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    PriorityQueue<Long> mpq = new PriorityQueue<>();
    PriorityQueue<Long> ppq = new PriorityQueue<>((p1, p2) -> p2.compareTo(p1));
    int one = 0;
    int zero = 0;
    int plus = 0;
    int minus = 0;
    for (int i = 0; i < n; i++) {
      long num = Long.parseLong(br.readLine());
      if (num == 0) {
        zero++;
      } else if (num == 1) {
        one++;
      } else if (num < 0) {
        mpq.offer(num);
        minus++;
      } else if (num > 0) {
        ppq.offer(num);
        plus++;
      }
    }
    long answer = 0;
    answer += one;

    if (minus % 2 == 0) {
      while (!mpq.isEmpty()) {
        answer += mpq.poll() * mpq.poll();
      }
    } else {
      if (zero > 0) {
        while (mpq.size() > 1) {
          answer += mpq.poll() * mpq.poll();
        }
        mpq.poll();
      } else {
        while (mpq.size() > 1) {
          answer += mpq.poll() * mpq.poll();
        }
        answer += mpq.poll();
      }
    }

    if (plus % 2 == 0) {
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
