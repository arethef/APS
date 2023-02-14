package g5_19539_AppleTree;

import java.util.*;
import java.io.*;

public class Main {
  static int N, total, odd;
  static int[] wish;
  static boolean possible;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    wish = new int[N];

    for (int i = 0; i < N; i++) {
      wish[i] = Integer.parseInt(st.nextToken());
      total += wish[i];
      if (wish[i] % 2 != 0) {
        odd++;
      }
    }

    if (total % 3 != 0) {
      System.out.println("NO");
    } else {
      if (total / 3 >= odd) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }
}
