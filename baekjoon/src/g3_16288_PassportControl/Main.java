package g3_16288_PassportControl;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] q = new int[k];
    st = new StringTokenizer(br.readLine());
    int cnt = 0;
    for (int i = 0; i < N; i++) {
      int input = Integer.parseInt(st.nextToken());
      for (int j = 0; j < k; j++) {
        if (q[j] < input) {
          q[j] = input;
          cnt++;
          break;
        } else {
          continue;
        }
      }
    }
    if (cnt == N) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }
}
