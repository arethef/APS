package g4_16929_TwoDots;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static boolean flag;
  static char[][] board;
  static boolean[][] visited;

  // 우하좌상
  static int[] dy = { 0, 1, 0, -1 };
  static int[] dx = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    board = new char[N][M];
    for (int i = 0; i < N; i++) {
      board[i] = br.readLine().toCharArray();
    }
    flag = false;
    visited = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      if (flag)
        break;
      for (int j = 0; j < M; j++) {
        if (flag)
          break;
        find(new Pos(i, j), new Pos(i, j), 0);
      }
    }

    if (flag)
      bw.write("Yes");
    else
      bw.write("No");
    bw.flush();
    bw.close();
    br.close();
  }

  static void find(Pos i, Pos c, int k) {
    visited[c.y][c.x] = true;

    for (int d = 0; d < 4; d++) {
      Pos n = new Pos(c.y + dy[d], c.x + dx[d]);
      if (n.y < 0 || n.y >= N || n.x < 0 || n.x >= M)
        continue;
      if (board[n.y][n.x] != board[c.y][c.x])
        continue;
      if (visited[n.y][n.x]) {
        // k는 4보다 크거나 같음 && 모든 점의 색이 같음
        if (n.y == i.y && n.x == i.x && k + 1 >= 4) {
          flag = true;
          return;
        } else
          continue;
      }

      find(i, n, k + 1);
    }

    visited[c.y][c.x] = false;
  }

  static class Pos {
    int y, x;

    Pos(int y, int x) {
      this.y = y;
      this.x = x;
    }

    @Override
    public String toString() {
      return "Pos [ y: " + y + ", x: " + x + " ]";
    }
  }
}
