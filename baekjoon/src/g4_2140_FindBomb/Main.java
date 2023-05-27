package g4_2140_FindBomb;

import java.io.*;

public class Main {

  // 우 우하 하 좌하 좌 좌상 상 우상
  static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
  static int[] dx = { 1, 1, 0, -1, -1, -1, 0, 1 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    char[][] board = new char[N][N];
    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      board[i] = line.toCharArray();
    }
    int answer = (N - 2) * (N - 2);
    if (N <= 2) {
      answer = 0;
    } else {
      for (int i = 1; i < N - 1; i++) {
        for (int j = 1; j < N - 1; j++) {
          boolean isBomb = true;
          for (int d = 0; d < 8; d++) {
            int ny = i + dy[d];
            int nx = j + dx[d];
            if (board[ny][nx] == '#') {
              continue;
            }
            int num = board[ny][nx] - '0';
            if (num == 0) {
              isBomb = false;
            }
          }
          if (!isBomb) {
            answer--;
          } else {
            for (int d = 0; d < 8; d++) {
              int ny = i + dy[d];
              int nx = j + dx[d];
              if (board[ny][nx] != '#') {
                board[ny][nx]--;
              }
            }
          }
        }
      }
    }
    System.out.println(answer);
  }
}
