package KakaoBlindRecruitment2023.lv3.미로탈출명령어;

import java.util.*;

public class Solution {
  public static void main(String[] args) {
    System.out.println(solution(3, 4, 2, 3, 3, 1, 5));
    System.out.println(solution(2, 2, 1, 1, 2, 2, 2));
    System.out.println(solution(3, 3, 1, 2, 3, 3, 4));
  }

  static int[] dr = { 1, 0, 0, -1 };
  static int[] dc = { 0, -1, 1, 0 };
  static String[] ds = { "d", "l", "r", "u" };
  static int[] dd;

  public static String solution(int n, int m, int x, int y, int r, int c, int k) {
    String answer = "impossible";
    Stack<Pos> stack = new Stack<>();
    stack.add(new Pos(x, y, ""));
    while (!stack.isEmpty()) {
      Pos curr = stack.pop();
      if (curr.p.length() == k && curr.r == r && curr.c == c) {
        answer = curr.p;
        break;
      }
      int rd = k - curr.p.length(); // remaining distance
      int ed = Math.abs(curr.r - r) + Math.abs(curr.c - c); // end distance
      if (rd < ed || rd % 2 != ed % 2) {
        continue;
      }
      if (curr.r > 1) {
        stack.add(new Pos(curr.r - 1, curr.c, curr.p + "u"));
      }
      if (curr.c < m) {
        stack.add(new Pos(curr.r, curr.c + 1, curr.p + "r"));
      }
      if (curr.c > 1) {
        stack.add(new Pos(curr.r, curr.c - 1, curr.p + "l"));
      }
      if (curr.r < n) {
        stack.add(new Pos(curr.r + 1, curr.c, curr.p + "d"));
      }
    }
    return answer;
  }

  static class Pos {
    int r, c;
    String p; // path

    Pos(int r, int c, String p) {
      this.r = r;
      this.c = c;
      this.p = p;
    }
  }
}