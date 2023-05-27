package g5_23559_Rice;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int X = Integer.parseInt(st.nextToken());
    PriorityQueue<Menu> menus = new PriorityQueue<>((m1, m2) -> (m2.a - m2.b) - (m1.a - m1.b));
    int money = X;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken()); // 5000원 메뉴 맛
      int B = Integer.parseInt(st.nextToken()); // 1000원 메뉴 맛
      Menu m = new Menu(A, B, i);
      menus.offer(m);
      money -= 1000;
    }

    int answer = 0;
    while (!menus.isEmpty()) {
      Menu curr = menus.poll();
      if (money >= 4000 && curr.a > curr.b) {
        answer += curr.a;
        money -= 4000;
      } else {
        answer += curr.b;
      }
    }

    System.out.println(answer);
  }

  static class Menu {
    int a, b, d;

    Menu(int a, int b, int d) {
      this.a = a;
      this.b = b;
      this.d = d;
    }
  }
}
