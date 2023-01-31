package g5_12907_Zoo;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] input = new int[N + 1];
    int[] cnt = new int[41];
    int answer = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      input[i] = Integer.parseInt(st.nextToken());
      cnt[input[i]]++;
      if (cnt[input[i]] > 2) {
        System.out.println(answer);
        return;
      }
    }

    // 조건: cnt배열에는 2와 1만 있어야 하고 내림차순이어야함
    // cnt배열 시작이 2보다 크면 fail
    // cnt배열 뒤가 앞보다 크면 fail
    // cnt배열 값이 0이되면 종료하는데 sum이 N과 다르면 fail

    boolean isFail = false;
    int sum = 0;
    int two = 0;
    int one = 0;
    if (cnt[0] > 2 || cnt[0] == 0) {
      isFail = true;
    } else {
      sum += cnt[0];
      if (cnt[0] == 2) {
        two++;
      } else if (cnt[0] == 1) {
        one++;
      }
      int prev = cnt[0];
      for (int i = 1; i <= cnt.length; i++) {
        if (cnt[i] == 2) {
          two++;
        } else if (cnt[i] == 1) {
          one++;
        } else if (cnt[i] == 0) {
          break;
        } else {
          isFail = true;
          break;
        }
        if (cnt[i] > prev) {
          isFail = true;
          break;
        }
        prev = cnt[i];
        sum += cnt[i];
      }
    }

    if (sum != N) {
      isFail = true;
    }
    if (!isFail) {
      answer = two == 0 ? 2 : one == 0 ? (int) Math.pow(2, two) : (int) Math.pow(2, two + 1);
    }
    System.out.println(answer);
  }
}
