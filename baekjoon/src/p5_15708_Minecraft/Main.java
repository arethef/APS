package p5_15708_Minecraft;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long T = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
        int time = 0;
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken());
            time += k;
            pq.offer(k);
            while (time > T - P * i) {
                if (pq.size() == 0) {
                    break;
                }
                time -= pq.poll();
            }
            answer = Math.max(answer, pq.size());
        }
        System.out.println(answer);
    }

    static class Stone {
        int d, k;

        public Stone(int d, int k) {
            this.d = d;
            this.k = k;
        }
    }
}
