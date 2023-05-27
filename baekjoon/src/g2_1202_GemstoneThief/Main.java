package g2_1202_GemstoneThief;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    Gemstone[] g = new Gemstone[N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int m = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      g[i] = new Gemstone(m, v);
    }

    Arrays.sort(g, new Comparator<Gemstone>() {
      @Override
      public int compare(Gemstone g1, Gemstone g2) {
        return g1.m == g2.m ? g2.v - g1.v : g1.m - g2.m;
      }
    });

    PriorityQueue<Integer> cpq = new PriorityQueue<>();
    for (int i = 0; i < K; i++) {
      cpq.offer(Integer.parseInt(br.readLine()));
    }
    PriorityQueue<Integer> vpq = new PriorityQueue<>((v1, v2) -> v2 - v1);
    long answer = 0;
    int idx = 0;
    while (!cpq.isEmpty()) {
      int c = cpq.poll();
      while (idx < N) {
        if (g[idx].m <= c) {
          vpq.offer(g[idx].v);
          idx++;
        } else {
          break;
        }
      }
      if (!vpq.isEmpty()) {
        answer += vpq.poll();
      }
    }

    System.out.println(answer);
  }

  static class Gemstone {
    int m, v; // 무게, 가격

    Gemstone(int m, int v) {
      this.m = m;
      this.v = v;
    }

    @Override
    public String toString() {
      return "G [m:" + m + ",v:" + v + "]";
    }
  }
}

// 가치 무게
// 10 1
// 9 10

// 가방
// 10 5
