package g5_11000_LectureRoomAssignment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Lecture[] l = new Lecture[N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            l[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(l, (l1, l2) -> l1.s==l2.s ? l1.e-l2.e : l1.s-l2.s);
        Queue<Integer> pq = new PriorityQueue<>();
        pq.offer(l[0].e);
        for (int i=1; i<N; i++) {
            if (pq.peek()<=l[i].s) {
                pq.poll();
            }
            pq.offer(l[i].e);
        }

        System.out.println(pq.size());
    }
    public static class Lecture {
        int s, e;
        public Lecture(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}
