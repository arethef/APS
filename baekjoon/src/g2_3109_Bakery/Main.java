package g2_3109_Bakery;

import java.util.*;
import java.io.*;

public class Main {
  static int R, C, answer;
  static char[][] map;
  static boolean[][] visited;
  static boolean flag;

  // 오른위 오른 오른아래
  static int[] dy = { -1, 0, 1 };
  static int[] dx = { 1, 1, 1 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    map = new char[R][C];
    for (int i = 0; i < R; i++) {
      map[i] = br.readLine().toCharArray();
    }
    visited = new boolean[R][C];

    answer = 0;
    for (int i = 0; i < R; i++) {
      flag = false;
      find(i, 0);
    }
    System.out.println(answer);
  }

  static void find(int cy, int cx) {
    if (cx == C - 1) {
      answer++;
      flag = true;
      return;
    }
    for (int d = 0; d < 3; d++) {
      int ny = cy + dy[d];
      int nx = cx + dx[d];
      if (ny < 0 || ny >= R || nx < 0 || nx >= C || visited[ny][nx] || map[ny][nx] == 'x' || flag) {
        continue;
      }
      visited[ny][nx] = true;
      find(ny, nx);
    }
  }
}
