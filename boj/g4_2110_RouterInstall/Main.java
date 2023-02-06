package g4_2110_RouterInstall;

import java.util.*;
import java.io.*;

public class Main {
  static int N, C, answer;
  static int[] input;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    input = new int[N];

    for (int i = 0; i < N; i++) {
      input[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(input);

    answer = 0;
    int min = 1;
    int max = input[N - 1] - input[0];

    while (min <= max) {

      int mid = (max + min) / 2;

      int installed = input[0];
      int cnt = 1;
      for (int i = 1; i < N; i++) {
        int dist = input[i] - installed;
        if (mid <= dist) {
          cnt++;
          installed = input[i];
        }
      }
      if (cnt >= C) {
        answer = mid;
        min = mid + 1;
      } else {
        max = mid - 1;
      }
    }

    System.out.println(answer);
  }

}
