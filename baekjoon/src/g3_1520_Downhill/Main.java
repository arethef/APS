package g3_1520_Downhill;

import java.util.*;
import java.io.*;

public class Main {
  static int N, M, answer;
  static int[][] map, dp;

  // 상하좌우
  static int[] dy = { -1, 1, 0, 0 };
  static int[] dx = { 0, 0, -1, 1 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    dp = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        dp[i][j] = -1;
      }
    }
    System.out.println(find(0, 0));
  }

  static int find(int cy, int cx) {
    if (cy == N - 1 && cx == M - 1) {
      return 1;
    }

    // 이미 거쳐간 지점이면 해당 지점에서 도착지로 갈 수 있는 경우의 수 리턴
    if (dp[cy][cx] != -1) {
      return dp[cy][cx];
    }

    dp[cy][cx] = 0;

    for (int d = 0; d < 4; d++) {
      int ny = cy + dy[d];
      int nx = cx + dx[d];
      if (ny < 0 || ny >= N || nx < 0 || nx >= M || map[ny][nx] >= map[cy][cx]) {
        continue;
      }
      dp[cy][cx] += find(ny, nx);
    }
    return dp[cy][cx];
  }
}
