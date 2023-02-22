package g5_13164_HappyKindergarden;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[] input = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      input[i] = Integer.parseInt(st.nextToken());
    }
    PriorityQueue<Integer> diff = new PriorityQueue<>((i1, i2) -> i2 - i1);
    for (int i = 1; i < N; i++) {
      diff.offer(input[i] - input[i - 1]);
    }
    long totalDiff = input[N - 1] - input[0];
    while (--K > 0) {
      totalDiff -= diff.poll();
    }
    System.out.println(totalDiff);
  }
}
