package g5_11509_PopTheBalloon;

import java.io.*;
import java.util.*;

public class Main {
  static int N, answer;
  static int[] input;
  static boolean[] popped;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine()); // 풍선의 개수
    StringTokenizer st = new StringTokenizer(br.readLine());

    int answer = 0; // 쏜 화살 수
    int[] arrows = new int[1_000_001]; // 각 높이에 화살 수
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      if (arrows[num] > 0) {
        arrows[num]--; // 해당 높이 화살 수 빼기
      } else {
        answer++; // 화살 새로 쏘기
      }
      arrows[num - 1]++; // 감소한 높이에 화살 수 더하기
    }
    System.out.println(answer);

    // ArrayList<Integer> last = new ArrayList<>();
    // for (int i = 0; i < N; i++) {
    // int input = Integer.parseInt(st.nextToken());
    // if (last.contains(input + 1)) {
    // last.remove(last.indexOf(input + 1));
    // }
    // last.add(input);
    // }
    // System.out.println(last.size());

  }

}
