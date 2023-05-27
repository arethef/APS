package g5_20311_ChemistryExpreiment;

import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 시험관 개수
    int K = Integer.parseInt(st.nextToken()); // 색깔 종류 수
    // 조건: 인접한 시험관끼리 색깔이 달라야 한다
    PriorityQueue<Pipe> pipes = new PriorityQueue<>((p1, p2) -> p1.c == p2.c ? p1.n - p2.n : p2.c - p1.c);
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < K; i++) {
      int c = Integer.parseInt(st.nextToken());
      pipes.add(new Pipe(i + 1, c));
    }

    // while (!pipes.isEmpty()) {
    // System.out.println(pipes.poll());
    // }

    int[] result = new int[N];

    boolean possible = true;

    Pipe start = pipes.poll();
    result[0] = start.n;
    if (start.c > 1) {
      pipes.add(new Pipe(start.n, start.c - 1));
    }
    for (int i = 1; i < N; i++) {
      PriorityQueue<Pipe> temp = new PriorityQueue<>((p1, p2) -> p2.c - p1.c);
      Pipe curr = pipes.poll();
      while (result[i - 1] == curr.n) {
        temp.add(curr);
        if (pipes.isEmpty()) {
          possible = false;
          break;
        }
        curr = pipes.poll();
      }
      if (!possible) {
        break;
      }
      result[i] = curr.n;
      if (curr.c > 1) {
        pipes.add(new Pipe(curr.n, curr.c - 1));
      }
      if (!temp.isEmpty()) {
        pipes.addAll(temp);
      }
    }

    if (possible) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < N; i++) {
        sb.append(result[i]);
        sb.append(" ");
      }
      System.out.println(sb.substring(0, sb.length() - 1));
    } else {
      System.out.println(-1);
    }
  }

  static class Pipe {
    int n, c; // 색 번호, 색 수

    Pipe(int n, int c) {
      this.n = n;
      this.c = c;
    }

    @Override
    public String toString() {
      return "Pipe [n:" + n + ",c:" + c + "]";
    }
  }
}
