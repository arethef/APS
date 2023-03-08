package g2_17136_ColoredPaperPaste;

import java.util.*;
import java.io.*;

public class Main {
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] input = new int[10][10];
        StringTokenizer st = null;
        int one = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int i=0; i<10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<10; j++) {
                int num = Integer.parseInt(st.nextToken());
                input[i][j] = num;
                if (num==1) {
                    one++;
                    q.add(new int[]{i, j});
                }
            }
        }
        int[] paper = {0, 5, 5, 5, 5, 5};    // 종류별 색종이 개수

        answer = Integer.MAX_VALUE;

        dfs(0, 0, 0, one, input, paper);

        if (answer==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

    static void dfs(int y, int x, int cnt, int one, int[][] map, int[] paper) {
        // 다 덮었으면
        if (one==0) {
            answer = Math.min(answer, cnt);
            return;
        }
        // (9,9)까지 다 확인했으면
        if (y==9 && x==10) return;
        // x가 9까지 다 갔으면 y 한 칸 내리기
        if (x==10) {
            y += 1;
            x = 0;
        }
        // 0이면 1일때까지 y,x 찾기
        if (map[y][x]==0) {
            while (map[y][x]==0 && y<10 && x<10) {
                x++;
                if (x==10) {
                    x=0;
                    y++;
                }
            }
        }
        for (int l=5; l>=1; l--) {
            if (y+l>10 || x+l>10) continue;
            if (check(y, x, l, map) && paper[l]>0) {
                map = paste(y, x, l, map);
                paper[l]--;
                dfs(y, x+l, cnt+1, one-l*l, map, paper);
                recover(y, x, l, map);
                paper[l]++;
            }
        }
    }
    static int[][] recover(int r, int c, int length, int[][] map) {
        for (int i=r; i<r+length; i++) {
            for (int j=c; j<c+length; j++) {
                map[i][j] = 1;
            }
        }
        return map;
    }
    static int[][] paste(int r, int c, int length, int[][] map) {
        for (int i=r; i<r+length; i++) {
            for (int j=c; j<c+length; j++) {
                map[i][j] = 0;
            }
        }
        return map;
    }
    static boolean check(int r, int c, int length, int[][] map) {
        for (int i=r; i<r+length; i++) {
            for (int j=c; j<c+length; j++) {
                if (map[i][j]==0) return false;
            }
        }
        return true;
    }
}
