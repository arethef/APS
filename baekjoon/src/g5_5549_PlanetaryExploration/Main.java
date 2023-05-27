package g5_5549_PlanetaryExploration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N, M, K; // 가로 세로 조사대상영역수
  static Pos[][] map;
  static boolean[][] visited;

  // 우하좌상
  static int[] dy = { 0, 1, 0, -1 };
  static int[] dx = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(br.readLine());
    map = new Pos[N + 1][M + 1];
    for (int i = 0; i <= N; i++) {
      map[i][0] = new Pos();
    }
    for (int j = 0; j <= M; j++) {
      map[0][j] = new Pos();
    }
    for (int i = 1; i <= N; i++) {
      String[] line = br.readLine().split("");
      for (int j = 1; j <= M; j++) {
        map[i][j] = new Pos();
        map[i][j].j = map[i - 1][j].j + map[i][j - 1].j - map[i - 1][j - 1].j;
        map[i][j].o = map[i - 1][j].o + map[i][j - 1].o - map[i - 1][j - 1].o;
        map[i][j].i = map[i - 1][j].i + map[i][j - 1].i - map[i - 1][j - 1].i;
        switch (line[j - 1]) {
          case "J":
            map[i][j].j++;
            break;
          case "O":
            map[i][j].o++;
            break;
          case "I":
            map[i][j].i++;
            break;
        }
      }
    }
    String[] tgt = new String[K];
    for (int k = 0; k < K; k++) {
      tgt[k] = br.readLine();
    }
    for (int k = 0; k < K; k++) {
      st = new StringTokenizer(tgt[k]);
      int sy = Integer.parseInt(st.nextToken());
      int sx = Integer.parseInt(st.nextToken());
      int ey = Integer.parseInt(st.nextToken());
      int ex = Integer.parseInt(st.nextToken());
      int[] answer = new int[3];
      answer[0] = map[ey][ex].j - map[ey][sx - 1].j - map[sy - 1][ex].j + map[sy - 1][sx - 1].j;
      answer[1] = map[ey][ex].o - map[ey][sx - 1].o - map[sy - 1][ex].o + map[sy - 1][sx - 1].o;
      answer[2] = map[ey][ex].i - map[ey][sx - 1].i - map[sy - 1][ex].i + map[sy - 1][sx - 1].i;
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 3; i++) {
        sb.append(answer[i]);
        if (i != 2) {
          sb.append(" ");
        }
      }
      System.out.println(sb.toString());
    }
  }

  static class Pos {
    int j, i, o;

    Pos() {
    }

    Pos(int j, int i, int o) {
      this.j = j;
      this.i = i;
      this.o = o;
    }

    @Override
    public String toString() {
      return "Pos [j:" + j + " i:" + i + " o:" + o + "]";
    }
  }
}
