package g4_27377_LeftOnLoadStop;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      long n = Long.parseLong(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      double s = Double.parseDouble(st.nextToken());
      double t = Double.parseDouble(st.nextToken());

      long answer = 0;
      while (n > 0) {
        if (n % 2 != 0) {
          n -= 1;
          answer += s;
        } else {
          n /= 2;
          answer += Math.min(s * n, t);
        }
      }

      System.out.println(answer);
    }
  }
}
