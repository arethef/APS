package g4_14499_DiceRolling;

import java.io.*;
import java.util.*;

public class Main {
  static int N, M, y, x, K;
  static int[][] map;

  // _동서북남
  static int[] dy = { 0, 0, 0, -1, 1 };
  static int[] dx = { 0, 1, -1, 0, 0 };

  // _위앞왼오뒤알
  static int[] dice = { 0, 0, 0, 0, 0, 0, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    st = new StringTokenizer(br.readLine());
    int cy = y;
    int cx = x;
    for (int i = 0; i < K; i++) {
      int d = Integer.parseInt(st.nextToken());
      int ny = cy + dy[d];
      int nx = cx + dx[d];
      if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
        continue;
      }
      int[] temp = new int[7];
      for (int j = 1; j < 7; j++) {
        temp[j] = dice[j];
      }
      switch (d) {
        case 1:
          dice[1] = temp[4];
          dice[4] = temp[6];
          dice[6] = temp[3];
          dice[3] = temp[1];
          break;
        case 2:
          dice[4] = temp[1];
          dice[1] = temp[3];
          dice[3] = temp[6];
          dice[6] = temp[4];
          break;
        case 3:
          dice[2] = temp[1];
          dice[1] = temp[5];
          dice[5] = temp[6];
          dice[6] = temp[2];
          break;
        case 4:
          dice[1] = temp[2];
          dice[5] = temp[1];
          dice[6] = temp[5];
          dice[2] = temp[6];
          break;
      }
      if (map[ny][nx] == 0) {
        map[ny][nx] = dice[6];
      } else {
        dice[6] = map[ny][nx];
        map[ny][nx] = 0;
      }
      cy = ny;
      cx = nx;
      System.out.println(dice[1]);
    }
  }
}
