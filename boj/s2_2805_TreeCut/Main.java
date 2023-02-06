package s2_2805_TreeCut;

import java.util.*;
import java.io.*;

public class Main {
  static int N, M, answer;
  static int[] input;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 나무 수
    M = Integer.parseInt(st.nextToken()); // 나무 길이
    input = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      input[i] = Integer.parseInt(st.nextToken());
    }

    answer = 0;

    int min = 1;
    int max = 2_000_000_000;
    while (min <= max) {
      int mid = (min + max) / 2;
      if (getM(mid) >= M) {
        answer = mid;
        min = mid + 1;
      } else {
        max = mid - 1;
      }
    }

    System.out.println(answer);
  }

  static long getM(int h) {
    long sum = 0;
    for (int i = 0; i < N; i++) {
      sum += input[i] > h ? input[i] - h : 0;
    }
    return sum;
  }
}
