package 코딩기초트레이닝.lv0.정수를나산형으로배치하기;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] result = solution(4);
        for (int[] r : result) {
            System.out.println(Arrays.toString(r));
        }
        System.out.println("------");
        result = solution(5);
        for (int[] r : result) {
            System.out.println(Arrays.toString(r));
        }
    }

    // 우하좌상
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int num = 1;
        int r = 0, c = 0;
        int d = 0;
        while (num<=n*n) {
            answer[r][c] = num++;
            int nr = r+dr[d];
            int nc = c+dc[d];
            if (nr<0 || nr>=n || nc<0 || nc>=n || answer[nr][nc]!=0) {
                d = (d+1)%4;
                nr = r+dr[d];
                nc = c+dc[d];
            }
            r = nr;
            c = nc;
        }
        return answer;
    }
}
