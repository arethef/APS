package g4_1027_HighRise;

import java.util.*;
import java.io.*;

public class Main {
  static long[] input;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    input = new long[N];
    for (int i = 0; i < N; i++) {
      input[i] = Long.parseLong(st.nextToken());
    }

    int answer = 0;
    for (int i = 0; i < N; i++) {
      // 왼쪽 기울기 작아져야함
      float pre = Float.MAX_VALUE;// 3.4028235E38
      int lCnt = 0;
      for (int j = i - 1; j >= 0; j--) {
        float curr = getGradient(input[i], input[j], j - i);
        if (curr < pre) {
          lCnt++;
          pre = curr;
        }
      }

      // 오른쪽 기울기 커져야함
      pre = -Float.MAX_VALUE; // 1.4E-45
      int rCnt = 0;
      for (int j = i + 1; j < N; j++) {
        float curr = getGradient(input[i], input[j], j - i);
        if (curr > pre) {
          rCnt++;
          pre = curr;
        }
      }
      answer = Math.max(answer, lCnt + rCnt);
    }
    System.out.println(answer);
  }

  static float getGradient(long ch, long jh, int dist) {
    long diff = jh - ch;
    return (float) diff / dist;
  }
}
