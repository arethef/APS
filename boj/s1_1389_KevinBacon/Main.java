package s1_1389_KevinBacon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int W, H;
    static int[][] banner;
    static boolean[][] visited;
    //우하좌상
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        banner = new int[H][W];
        visited = new boolean[H][W];
        for (int h=0; h<H; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w=0; w<W; w++) {
                banner[h][w] = Integer.parseInt(st.nextToken());
            }
        }
        // End of input

        int answer = 0;
        for (int i=0; i<H; i++) {
            for (int j=0; j<W; j++) {
                if (banner[i][j]==0 || visited[i][j]) continue;
                bfs(i, j);
                answer++;
            }
        }

        System.out.println(answer);
    }

    static void bfs(int startY, int startX) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startY, startX});
        visited[startY][startX] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int d=0; d<8; d++) {
                int[] next = new int[]{curr[0]+dy[d], curr[1]+dx[d]};
                if (next[0]<0 || next[0]>=H || next[1]<0 || next[1]>=W || visited[next[0]][next[1]]) continue;
                if (banner[next[0]][next[1]]==1) {
                    visited[next[0]][next[1]] = true;
                    q.add(next);
                }
            }
        }
    }
}
