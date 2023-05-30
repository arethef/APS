package 연습문제.lv2.땅따먹기;

public class Solution {
    public static void main(String[] args) {
        int[][] land = {
                {1, 2, 3, 5},
                {5, 6, 7, 8},
                {4, 3, 2, 1}
        };
        System.out.println(solution(land));
    }

    static int solution(int[][] land) {
        int answer = 0;
        int N = land.length;
        int M = land[0].length;
        int[][] dp = new int[N][M];
        for (int j=0; j<M; j++) {
            dp[0][j] = land[0][j];
        }
        for (int i=1; i<N; i++) {
            for (int j=0; j<M; j++) {
                dp[i][j] = Math.max(
                        Math.max(dp[i-1][(j+1)%M], dp[i-1][(j+2)%M]),
                        dp[i-1][(j+3)%M]
                )+land[i][j];
            }
        }

        for (int score : dp[N-1]) {
            answer = Math.max(answer, score);
        }

        return answer;
    }
}
