package g4_2258_ButcherShop;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 고기 덩어리 수
    int M = Integer.parseInt(st.nextToken()); // 은혜가 필요한 고기 양
    /*
     * 조건1. 원하는 양을 구매해야한다.
     * 조건2. 가격이 싸다면 필요한 양보다 더 많은 고기 살 수 있다.
     * 출력: 원하는 양의 고기를 구매하기 위한 최소 비용
     */
    Meat[] input = new Meat[N];
    int salesTotalWeight = 0;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int w = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      Meat m = new Meat(w, c);
      input[i] = m;
      salesTotalWeight += w;
    }
    // 정렬? 가격낮은순 - 고기무거운순
    Arrays.sort(input, new Comparator<Meat>() {
      @Override
      public int compare(Meat m1, Meat m2) {
        return m1.c == m2.c ? m2.w - m1.w : m1.c - m2.c;
      }
    });

    int answer = Integer.MAX_VALUE;
    if (salesTotalWeight < M) {
      answer = -1;
    } else {
      int weight = input[0].w;
      int cost = input[0].c;

      for (int i = 1; i < N; i++) {
        if (weight >= M) {
          answer = Math.min(answer, cost);
          // break;
        }
        // 같은 가격이면 구매한다
        if (input[i].c == input[i - 1].c) {
          cost += input[i].c;
        }
        // 같은 가격이 아니면 이전까지 거는 덤이고 지금 거를 구매한다
        else if (input[i].c > input[i - 1].c) {
          cost = input[i].c;
        }
        weight += input[i].w;
      }
      answer = Math.min(answer, cost);
    }

    System.out.println(answer);

  }

  static class Meat {
    int w, c; // 무게, 가격

    Meat(int w, int c) {
      this.w = w;
      this.c = c;
    }

    @Override
    public String toString() {
      return "Meat [w:" + w + ", c:" + c + "]";
    }
  }
}
