package g5_16678_Defilement;

import java.util.*;
import java.io.*;

public class Main {
  static int N;
  static int[] s;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    s = new int[N];
    for (int i = 0; i < N; i++) {
      int score = Integer.parseInt(br.readLine());
      s[i] = score;
    }
    Arrays.sort(s);

    long answer = 0;
    int defile = 1;
    for (int i = 0; i < N; i++) {
      s[i] -= defile;
      if (s[i] >= 0) {
        answer += s[i];
        defile++;
      }
    }
    System.out.println(answer);
  }
}
