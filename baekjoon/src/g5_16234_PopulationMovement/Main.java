package g5_16234_PopulationMovement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R;
    static int[][] land;
    static boolean[][] visited;
    //우하좌상
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        land = new int[N][N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        boolean flag = true;   //인구이동 true:발생, false:발생안함

        while (flag) {
            visited = new boolean[N][N];
            int times = 0;
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (visited[i][j]) continue;
                    times += bfs(new int[]{i, j});
                }
            }
            if (times==0) flag = false;
            else answer++;
        }

        System.out.println(answer);

    }

    public static int bfs(int[] s) {
        //인구이동이 발생하지 않으면 return 0
        Queue<int[]> q = new LinkedList<>();
        q.offer(s);
        visited[s[0]][s[1]] = true;
        boolean[][] temp_visited = new boolean[N][N];
        temp_visited[s[0]][s[1]] = true;
        int cnt = 0;
        int sum = land[s[0]][s[1]];
        while (!q.isEmpty()) {
            int[] c = q.poll();
            for (int d=0; d<4; d++) {
                int[] n = new int[]{c[0]+dy[d], c[1]+dx[d]};
                if (n[0]<0 || n[0]>=N || n[1]<0 || n[1]>=N || visited[n[0]][n[1]]) continue;
                int diff = Math.abs(land[c[0]][c[1]]-land[n[0]][n[1]]);
                if (diff<L || diff>R) continue;
                q.offer(n);
                visited[n[0]][n[1]] = true;
                temp_visited[n[0]][n[1]] = true;
                cnt++;
                sum += land[n[0]][n[1]];
            }
        }
        if (cnt!=0) {
            int avg = sum/(cnt+1);
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (temp_visited[i][j]) land[i][j] = avg;
                }
            }
        }
        return cnt;
    }
}
