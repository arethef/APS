package g3_2206_WallBreakMove;

import java.util.*;
import java.io.*;

public class Main {
  static int N, M;
  static char[][] map;
  static boolean[][][] visited;
  static int answer;

  // 우하좌상
  static int[] dr = { 0, 1, 0, -1 };
  static int[] dc = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new char[N][M];
    for (int i = 0; i < N; i++) {
      String row = br.readLine();
      map[i] = row.toCharArray();
    }
    visited = new boolean[N][M][2];
    answer = Integer.MAX_VALUE;
    bfs(0, 0);
    if (answer == Integer.MAX_VALUE) {
      answer = -1;
    }
    System.out.println(answer);
  }

  static void bfs(int sr, int sc) {
    Queue<Pos> q = new ArrayDeque<>();
    q.offer(new Pos(sr, sc, 1, false));
    visited[sr][sc][0] = true;
    while (!q.isEmpty()) {
      Pos curr = q.poll();
      if (curr.r == N - 1 && curr.c == M - 1) {
        answer = Math.min(answer, curr.cnt);
      }
      for (int d = 0; d < 4; d++) {
        int nr = curr.r + dr[d];
        int nc = curr.c + dc[d];
        if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
          continue;
        }
        if (map[nr][nc] == '0') {
          if (visited[nr][nc][curr.b ? 1 : 0]) {
            continue;
          }
          q.offer(new Pos(nr, nc, curr.cnt + 1, curr.b));
          visited[nr][nc][curr.b ? 1 : 0] = true;
        } else {
          if (visited[nr][nc][1]) {
            continue;
          }
          if (!curr.b) {
            q.offer(new Pos(nr, nc, curr.cnt + 1, true));
            visited[nr][nc][1] = true;
          }
        }
      }
    }
  }

  static class Pos {
    int r, c, cnt;
    boolean b;

    Pos(int r, int c, int cnt, Boolean b) {
      this.r = r;
      this.c = c;
      this.cnt = cnt;
      this.b = b;
    }
  }
}
