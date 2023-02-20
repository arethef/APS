package g3_11085_ArmyMove;

import java.util.*;
import java.io.*;

public class Main {
  static int P, W, C, V;
  static int[][] input;
  static int[] p;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    P = Integer.parseInt(st.nextToken());
    W = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    C = Integer.parseInt(st.nextToken());
    V = Integer.parseInt(st.nextToken());
    input = new int[P][P];
    PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n2.width - n1.width);
    for (int i = 0; i < W; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int width = Integer.parseInt(st.nextToken());
      input[start][end] = width;
      input[end][start] = width;
      pq.offer(new Node(start, end, width));
    }

    int answer = 0;

    p = new int[P];
    for (int i = 0; i < P; i++) {
      p[i] = i;
    }

    while (!pq.isEmpty()) {
      Node curr = pq.poll();
      union(curr.start, curr.end);
      if (findSet(C) == findSet(V)) {
        answer = curr.width;
        break;
      }
    }

    System.out.println(answer);

  }

  static class Node {
    int start, end, width;

    Node(int start, int end, int width) {
      this.start = start;
      this.end = end;
      this.width = width;
    }

    @Override
    public String toString() {
      return "Node [start:" + start + ", end:" + end + ", width:" + width + "]";
    }
  }

  static int findSet(int a) {
    if (a == p[a]) {
      return a;
    }
    return p[a] = findSet(p[a]);
  }

  static void union(int a, int b) {
    int aRoot = findSet(a);
    int bRoot = findSet(b);
    p[bRoot] = aRoot;
  }

}
