package g5_2096_GoDown;

import java.io.BufferedReader;
import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] map = new int[N][3];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[][] maxDp = new int[N][3];
    int[][] minDp = new int[N][3];
    for (int i = 0; i < 3; i++) {
      maxDp[0][i] = map[0][i];
      minDp[0][i] = map[0][i];
    }

    for (int i = 1; i < N; i++) {
      maxDp[i][0] = Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + map[i][0];
      maxDp[i][1] = Math.max(maxDp[i - 1][0], Math.max(maxDp[i - 1][1], maxDp[i - 1][2])) + map[i][1];
      maxDp[i][2] = Math.max(maxDp[i - 1][1], maxDp[i - 1][2]) + map[i][2];

      minDp[i][0] = Math.min(minDp[i - 1][0], minDp[i - 1][1]) + map[i][0];
      minDp[i][1] = Math.min(minDp[i - 1][0], Math.min(minDp[i - 1][1], minDp[i - 1][2])) + map[i][1];
      minDp[i][2] = Math.min(minDp[i - 1][1], minDp[i - 1][2]) + map[i][2];
    }

    int maxScore = Math.max(maxDp[N - 1][0], Math.max(maxDp[N - 1][1], maxDp[N - 1][2]));
    int minScore = Math.min(minDp[N - 1][0], Math.min(minDp[N - 1][1], minDp[N - 1][2]));

    System.out.println(maxScore + " " + minScore);
  }
}
