package KakaoBlindRecruitment2022.lv3.파괴되지않은건물;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public static void main(String[] args) {
        int[][] board = {
                {5,5,5,5,5},
                {5,5,5,5,5},
                {5,5,5,5,5},
                {5,5,5,5,5}
        };
        int[][] skill = {
                {1,0,0,3,4,4},
                {1,2,0,2,3,2},
                {2,1,0,3,1,2},
                {1,0,1,3,3,1}
        };
        System.out.println(solution(board, skill));
    }
    public static int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        int answer = 0;
        int[][] acc = new int[n+1][m+1];
        for (int[] s : skill) {
            int type = s[0], sr = s[1], sc = s[2], er = s[3], ec = s[4], degree = s[5];
            acc[sr][sc] += type==2 ? degree : -degree;
            acc[sr][ec+1] += type==2 ? -degree : degree;
            acc[er+1][sc] += type==2 ? -degree : degree;
            acc[er+1][ec+1] += type==2 ? degree : -degree;
        }
        // 행 누적합
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                acc[i][j+1] += acc[i][j];
            }
        }
        // 열 누적합
        for (int j=0; j<n; j++) {
            for (int i=0; i<n; i++) {
                acc[i+1][j] += acc[i][j];
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                board[i][j] += acc[i][j];
                if (board[i][j]>=1) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
