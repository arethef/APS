package g4_1339_WordMath;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String[] input = new String[N];
    for (int i = 0; i < N; i++) {
      input[i] = br.readLine();
    }
    // 입력 끝
    int[] alphabet = new int[26];
    for (int i = 0; i < N; i++) {
      int digit = (int) Math.pow(10, input[i].length() - 1);
      for (int j = 0; j < input[i].length(); j++) {
        alphabet[(int) input[i].charAt(j) - 65] += digit;
        digit /= 10;
      }
    }
    Arrays.sort(alphabet);
    int num = 9;
    int answer = 0;
    for (int i = alphabet.length - 1; i >= 0; i--) {
      if (alphabet[i] == 0) {
        break;
      }
      answer += alphabet[i] * num;
      num--;
    }
    System.out.println(answer);
  }
}
