package s2_2075_NthBigNum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, answer;
    static int[][] table;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // input
        N = Integer.parseInt(br.readLine());
        table = new int[N][N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                pq.add(table[i][j]);
            }
        }
        for (int i=0; i<N; i++) {
            answer = pq.poll();
        }
        System.out.println(answer);
    }
}
