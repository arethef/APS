package g4_19644_ZombiesComeMachineGunCamp;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int L = Integer.parseInt(br.readLine()); // 길 길이
    StringTokenizer st = new StringTokenizer(br.readLine());
    int ML = Integer.parseInt(st.nextToken()); // 유효 사거리
    int MK = Integer.parseInt(st.nextToken()); // 살상력
    int C = Integer.parseInt(br.readLine()); // 지뢰 수
    String answer = "YES";
    int b = 0;
    int t = 0;
    for (int i = 1; i <= L; i++) {
      int h = Integer.parseInt(br.readLine());
      int totalAttack = i <= ML ? t < ML ? MK * (i - b) : MK * i : t < ML ? MK * (ML - b) : MK * (ML);
      if (totalAttack < h) {
        if (C - b > 0) {
          b++;
          t = 0;
        } else {
          answer = "NO";
          break;
        }
      }
      if (b > 0) {
        t++;
      }
    }
    System.out.println(answer);
  }
}
