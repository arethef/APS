package s1_1743_AvoidFood;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, answer;
    static boolean[][] hallway, visited;

    // 우하좌상
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        hallway = new boolean[N][M];
        visited = new boolean[N][M];
        for (int k=0; k<K; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken())-1;
            int j = Integer.parseInt(st.nextToken())-1;
            hallway[i][j] = true;
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (hallway[i][j] && !visited[i][j]) answer = Math.max(bfs(i, j), answer);
            }
        }

        System.out.println(answer);
    }

    static int bfs(int i, int j) {
        Queue<Pos> q = new ArrayDeque<>();
        q.add(new Pos(i, j));
        int res = 1;
        visited[i][j] = true;
        while(!q.isEmpty()) {
            Pos curr = q.poll();
            for (int d=0; d<4; d++) {
                int ny = curr.r+dy[d];
                int nx = curr.c+dx[d];
                if (ny<0 || ny>=N || nx<0 || nx>=M || visited[ny][nx]) continue;
                if (hallway[ny][nx]) {
                    q.add(new Pos(ny, nx));
                    res += 1;
                    visited[ny][nx] = true;
                }
            }
        }
        return res;
    }

}
class Pos {
    int r;
    int c;
    Pos(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
