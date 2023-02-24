package g5_2467_Solution;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Integer[] input = new Integer[N];
    int pCnt = 0;
    int nCnt = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i=0; i<N; i++) {
      int num = Integer.parseInt(st.nextToken());
      input[i] = num;
      if (num>0) {
        pCnt++;
      }else {
        nCnt++;
      }
    }
    Arrays.sort(input);
    StringBuilder sb = new StringBuilder();
    if (pCnt==0) {
      sb.append(input[N-2]).append(" ").append(input[N-1]);
    } else if (nCnt==0) {
      sb.append(input[0]).append(" ").append(input[1]);
    } else {
      int lo = 0;
      int hi = N-1;
      int min = Integer.MAX_VALUE;
      int minlo = 0;
      int minhi = 0;
      while (lo<hi) {
        int curr = input[lo]+input[hi];
        if (Math.abs(curr)<min) {
          min = Math.abs(curr);
          minlo = input[lo];
          minhi = input[hi];
        }
        
        if (curr>0) {
          hi--;
        } else if (curr<0) {
          lo++;
        } else {
          break;
        }
      }
      sb.append(minlo).append(" ").append(minhi);
    }
    System.out.println(sb.toString());
  }
}
