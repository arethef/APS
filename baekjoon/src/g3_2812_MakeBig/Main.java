package g3_2812_MakeBig;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    String number = br.readLine();
    Stack<Character> s = new Stack<>();
    for (int i = 0; i < N; i++) {
      s.push(number.charAt(N - i - 1));
    }
    int count = 0;
    Stack<Character> temp = new Stack<>();
    while (count < K) {
      if (temp.isEmpty()) {
        char curr = s.pop();
        if (curr < s.peek()) {
          count++;
        } else {
          temp.push(curr);
        }
      } else {
        char curr = s.pop();
        if (temp.peek() < curr) {
          while (!temp.isEmpty() && temp.peek() < curr && count < K) {
            temp.pop();
            count++;
          }
          temp.push(curr);
        } else {
          if (!s.isEmpty()) {
            if (curr < s.peek()) {
              count++;
            } else {
              temp.push(curr);
            }
          } else {
            break;
          }
        }
      }
      // System.out.println("count:" + count + ", temp:" + temp.toString() + ", s:" +
      // s.toString());
    }
    while (!temp.isEmpty()) {
      s.push(temp.pop());
    }
    StringBuilder sb = new StringBuilder();
    int idx = 0;
    while (idx++ < N - K) {
      sb.append(s.pop());
    }
    System.out.println(sb);

  }
}
