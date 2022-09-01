package boj.s1_1926_Painting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, cnt, area;
    static int[][] paper;
    static boolean[][] visited;

    // 우하좌상
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        area = Integer.MIN_VALUE;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (visited[i][j] || paper[i][j]==0) continue;
                area = Math.max(area, bfs(new int[]{i, j}));
                cnt++;
            }
        }
        if (cnt==0) {
            System.out.println(0);
            System.out.println(0);
        }else {
            System.out.println(cnt);
            System.out.println(area);
        }
    }
    static int bfs(int[] start) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(start);
        visited[start[0]][start[1]] = true;
        int a = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (paper[curr[0]][curr[1]]==1) a++;
            for (int d=0; d<4; d++) {
                int ny = curr[0]+dy[d];
                int nx = curr[1]+dx[d];
                if (ny<0 || ny>=N || nx<0 || nx>=M || visited[ny][nx]) continue;
                if (paper[ny][nx]==1) {
                    q.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }
        return a;
    }
}
