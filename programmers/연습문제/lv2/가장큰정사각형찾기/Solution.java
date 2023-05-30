package 연습문제.lv2.가장큰정사각형찾기;

public class Solution {
    public static void main(String[] args) {

    }
    static int solution(int [][]board) {
        int answer = 0;

        int N = board.length;
        int M = board[0].length;

        int[][] dp = new int[N+1][M+1];
        int maxSideLength = 0;
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                if (board[i-1][j-1]==1) {
                    dp[i][j] = Math.min(
                            Math.min(dp[i-1][j], dp[i][j-1]),
                            dp[i-1][j-1]
                    )+1;
                    maxSideLength = Math.max(maxSideLength, dp[i][j]);
                }
            }
        }

        answer = maxSideLength*maxSideLength;
        return answer;
    }
}
