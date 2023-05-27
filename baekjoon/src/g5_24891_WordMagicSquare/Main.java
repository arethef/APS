package g5_24891_WordMagicSquare;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int L, N;
    static String[] input;
    static boolean[] visited;
    static PriorityQueue<String> pq;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        input = new String[N];
        for (int i=0; i<N ;i++) {
            input[i] = br.readLine();
        }
        pq = new PriorityQueue<>();

        for (int i=0; i<N; i++) {
            visited = new boolean[N];
            find(i, input[i], 1);
        }

        if (pq.isEmpty()) System.out.println("NONE");
        else {
            String answer = pq.poll();
            for (int i=0; i<L; i++) {
                System.out.println(answer.substring(i*L, i*L+L));
            }
        }
    }
    public static void find(int idx, String curr, int cnt) {
        visited[idx] = true;
        if (cnt==L) {
            boolean flag = true;
            for (int i=0; i<L*L; i++) {
                if (i%(L+1)==0) continue;
                if (curr.charAt(i)!=curr.charAt((i%L)*L+(i/L))) {
                    flag = false;
                    break;
                }
            }
            if (flag) pq.offer(curr);
            return;
        }
        for (int i=0; i<N; i++) {
            if (visited[i]) continue;
            find(i, curr+input[i], cnt+1);
            visited[i] = false;
        }
    }
}
