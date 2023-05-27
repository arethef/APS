package g3_2109_LectureTour;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Lecture> pq = new PriorityQueue<>((l1, l2)-> l1.p==l2.p ? l1.d-l2.d : l2.p-l1.p);
    StringTokenizer st = null;
    int maxD = 0;
    for (int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      int p = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      Lecture l = new Lecture(p, d);
      pq.offer(l);
      maxD = Math.max(maxD, d);
    }
    boolean[] selected = new boolean[maxD+1];
    int answer = 0;
    while (!pq.isEmpty()) {
      Lecture curr = pq.poll();
      if (selected[curr.d]) {
        int idx = curr.d-1;
        while (idx>0) {
          if (selected[idx]) {
            idx--;
            continue;
          } else {
            selected[idx] = true;
            answer+=curr.p;
            break;
          }
        }
      } else {
        selected[curr.d] = true;
        answer += curr.p;
      }
    }
    System.out.println(answer);
  }
  static class Lecture{
    int p;  // pay
    int d;  // day
    Lecture(int p, int d) {
      this.p = p;
      this.d = d;
    }
    @Override
    public String toString() {
      return "Lecture [p:"+p+", d:"+d+"]";
    }
  }
}
