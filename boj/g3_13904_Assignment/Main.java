package g3_13904_Assignment;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); // 과제개수
    PriorityQueue<Work> pq = new PriorityQueue<>((w1, w2) -> w1.w == w2.w ? w1.d - w2.d : w2.w - w1.w);
    StringTokenizer st = null;
    int maxDay = 0;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int d = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      pq.offer(new Work(d, w));
      maxDay = Math.max(maxDay, d);
    }

    int answer = 0;

    boolean[] done = new boolean[maxDay + 1];
    while (!pq.isEmpty()) {
      Work curr = pq.poll();
      if (done[curr.d]) {
        int idx = curr.d - 1;
        while (idx > 0) {
          if (done[idx]) {
            idx--;
            continue;
          } else {
            done[idx] = true;
            answer += curr.w;
            break;
          }
        }
      } else {
        done[curr.d] = true;
        answer += curr.w;
      }
    }

    System.out.println(answer);

  }

  static class Work {
    int d, w;

    Work(int d, int w) {
      this.d = d;
      this.w = w;
    }

    @Override
    public String toString() {
      return "Work [d:" + d + ", w:" + w + "]";
    }
  }
}
