package g3_2151_MirrorInstall;

import java.util.*;
import java.io.*;

public class Main {
  static int N;
  static char[][] input;
  static boolean[][] visited;
  static int[][] cnt;

  // 우하좌상
  static int[] dy = { 0, 1, 0, -1 };
  static int[] dx = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    input = new char[N][N];
    ArrayList<Pos> door = new ArrayList<>();
    cnt = new int[N][N];
    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      input[i] = line.toCharArray();
      for (int j = 0; j < N; j++) {
        if (input[i][j] == '#') {
          door.add(new Pos(i, j));
        }
        cnt[i][j] = Integer.MAX_VALUE;
      }
    }
    visited = new boolean[N][N];

    boolean found = false;
    // q에 담을거 시작점, 방향, 필요한 거울 개수
    Queue<Check> q = new ArrayDeque<>();
    int sy = door.get(0).y;
    int sx = door.get(0).x;
    for (int d = 0; d < 4; d++) {
      int ny = sy + dy[d];
      int nx = sx + dx[d];
      if (ny < 0 || ny >= N || nx < 0 || nx >= N || input[ny][nx] == '*') {
        continue;
      }
      q.offer(new Check(ny, nx, d, 0));
      if (input[ny][nx] == '!' && !visited[ny][nx]) {
        q.offer(new Check(ny, nx, (d + 1) % 4, 1));
        q.offer(new Check(ny, nx, (d + 3) % 4, 1));
      }
      if (input[ny][nx] == '#') {
        found = true;
      }
      visited[ny][nx] = true;
    }

    if (found) {
      System.out.println(0);
    } else {
      int answer = Integer.MAX_VALUE;
      while (!q.isEmpty()) {
        Check curr = q.poll();
        int cy = curr.y;
        int cx = curr.x;
        int cd = curr.d;
        int cc = curr.c;
        if (cy == door.get(1).y && cx == door.get(1).x) {
          answer = Math.min(answer, cc);
        }
        int ny = cy + dy[cd];
        int nx = cx + dx[cd];
        while (true) {
          if (ny < 0 || ny >= N || nx < 0 || nx >= N || input[ny][nx] == '*') {
            break;
          }
          // !면 q.offer할때 c를 cnt[cy][cx]+1
          if (input[ny][nx] == '!' && !visited[ny][nx]) {
            q.offer(new Check(ny, nx, (cd + 1) % 4, cc + 1));
            q.offer(new Check(ny, nx, (cd + 3) % 4, cc + 1));
          }

          if (visited[ny][nx]) {
            cnt[ny][nx] = Math.min(cnt[ny][nx], cc);
          } else {
            cnt[ny][nx] = cc;
            visited[ny][nx] = true;
          }

          ny = ny + dy[cd];
          nx = nx + dx[cd];
        }
      }

      if (cnt[door.get(1).y][door.get(1).x] == Integer.MAX_VALUE) {
        System.out.println(0);
      } else {
        System.out.println(cnt[door.get(1).y][door.get(1).x]);
      }
    }
  }

  static class Check {
    int y, x, d, c;

    Check(int y, int x, int d, int c) {
      this.y = y;
      this.x = x;
      this.d = d;
      this.c = c;
    }

    @Override
    public String toString() {
      return "Check [y:" + y + ", x:" + x + ", d:" + d + ", c:" + c + "]";
    }
  }

  static class Pos {
    int y, x;

    Pos(int y, int x) {
      this.y = y;
      this.x = x;
    }

    @Override
    public String toString() {
      return "Pos [y:" + y + ", x:" + x + "]";
    }
  }
}
