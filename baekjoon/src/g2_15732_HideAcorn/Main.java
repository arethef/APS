package g2_15732_HideAcorn;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args)  throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int D = Integer.parseInt(st.nextToken());
    Rule[] rule = new Rule[K];
    int lo = Integer.MAX_VALUE;
    int hi = Integer.MIN_VALUE;
    for (int i=0; i<K; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int C = Integer.parseInt(st.nextToken());
      Rule r = new Rule(A, B, C);
      rule[i] = r;
      lo = Math.min(lo, A);
      hi = Math.max(hi, B);
    }
    br.close();
    // (B-A)/C

    long cnt = 0;
    int mid = 0;
    while (lo<=hi) {
      cnt = 0;
      mid = (lo+hi)/2;
      for (int i=0; i<K; i++) {
        Rule r = rule[i];
        if (r.A<=mid) {
          cnt += (Math.min(mid, r.B)-r.A)/r.C + 1;
        }
      }
      if (cnt>=D) {
        hi = mid-1;
      } else if (cnt<D) {
        lo = mid+1;
      }
    }
    System.out.println(lo);
  }
  static class Rule{
    int A, B, C;
    Rule(int A, int B, int C) {
      this.A = A;
      this.B = B;
      this.C = C;
    }
    @Override
    public String toString() {
      return "Rule [A:"+A+", B:"+B+", C:"+C+"]";
    }
  }
}
