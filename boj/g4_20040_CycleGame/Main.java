package g4_20040_CycleGame;

import java.util.*;
import java.io.*;

public class Main {
  static int n, m, answer;
  static int[] parents;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    init();
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      boolean result = union(from, to);
      if (!result && answer == 0) {
        answer = i + 1;
      }
    }
    System.out.println(answer);
  }

  static boolean union(int id1, int id2) {
    int root1 = find(id1);
    int root2 = find(id2);
    if (root1 != root2) {
      if (root1 < root2) {
        parents[root2] = root1;
      } else {
        parents[root1] = root2;
      }
      return true;
    } else {
      return false;
    }
  }

  static int find(int id) {
    if (parents[id] != id) {
      return parents[id] = find(parents[id]);
    } else {
      return id;
    }
  }

  static void init() {
    parents = new int[n];
    for (int i = 0; i < n; i++) {
      parents[i] = i;
    }
  }
}
