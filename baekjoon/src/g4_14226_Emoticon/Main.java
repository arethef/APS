package g4_14226_Emoticon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int S, answer;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
//        visited = new boolean[2001][2001];  // 행: 화면 이모티콘 개수, 열: 클립보드 이모티콘 개수
        visited = new boolean[1001][1001];

        bfs();

        System.out.println(answer);
    }

    static void bfs() {
        Queue<Step> q = new LinkedList<>();
        q.offer(new Step(1, 0, 0));
        visited[1][0] = true;

        while (!q.isEmpty()) {
            Step c = q.poll();
            if (c.e ==S) {
                answer = c.t;
                return;
            }

            // copy
            q.offer(new Step(c.e, c.e, c.t+1));

            // paste
            if (c.c !=0 && c.e +c.c <=S && !visited[c.e+c.c][c.c]) {
                q.offer(new Step(c.e+c.c, c.c, c.t+1));
                visited[c.e+c.c][c.c] = true;
            }

            // delete
            if (c.e >=1 && !visited[c.e-1][c.c]) {
                q.offer(new Step(c.e-1, c.c, c.t+1));
                visited[c.e-1][c.c] = true;
            }
        }
    }

    static class Step {
        int e; //emoticon num
        int c; //clipboard num
        int t;  //time
        public Step(int e, int c, int t) {
            this.e = e;
            this.c = c;
            this.t = t;
        }
    }
}
