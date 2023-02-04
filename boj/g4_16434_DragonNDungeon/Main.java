package g4_16434_DragonNDungeon;

import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    long warriorAttack = Long.parseLong(st.nextToken());
    long warriorMaxHP = 0;
    long warriorCurrHP = 0; // 방에서 잔여 체력 ?

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken()); // 몬스터 공격력 or 용사 공격력 증가량
      int h = Integer.parseInt(st.nextToken()); // 몬스터 체력 or 용사 체력 회복량

      // 몬스터 방
      if (t == 1) {
        long d = 0;
        if (h % warriorAttack == 0) {
          d = (long) (h / warriorAttack - 1) * a;
        } else {
          d = a * (h / warriorAttack);
        }
        warriorCurrHP += d;
        if (warriorMaxHP < warriorCurrHP) {
          warriorMaxHP = warriorCurrHP;
        }
      }
      // 포션 방
      else if (t == 2) {
        warriorAttack += a;
        if (warriorCurrHP < h) {
          warriorCurrHP = 0;
        } else {
          warriorCurrHP = warriorCurrHP - h;
        }
      }
    }
    warriorMaxHP += 1;
    System.out.println(warriorMaxHP);
  }
}
