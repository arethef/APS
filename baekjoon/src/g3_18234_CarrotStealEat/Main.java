package g3_18234_CarrotStealEat;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 당근 종류 수
        long T = Integer.parseInt(st.nextToken());   // 재배 일 수
        PriorityQueue<Carrot> pq = new PriorityQueue<>((c1, c2) -> c1.p==c2.p ? c1.w-c2.w : c2.p-c1.p);
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            Carrot c = new Carrot(w, p);
            pq.offer(c);
        }

        long answer = 0;
        while (N-->0) {
            Carrot c = pq.poll();
            answer += c.w+ c.p*(--T);
        }
        System.out.println(answer);
    }
    static class Carrot {
        int w, p;
        Carrot(int w, int p) {
            this.w = w;
            this.p = p;
        }
        @Override
        public String toString() {
            return "Carrot [w:"+w+", p:"+p+"]";
        }
    }
}
