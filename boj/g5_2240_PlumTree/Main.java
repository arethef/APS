package g5_2240_PlumTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[][] dp = new int[T + 1][W + 1];   // [시간][이동횟수]
        for (int i = 1; i < T + 1; i++) {
            int tree = Integer.parseInt(br.readLine()); // 현재 자두가 떨어지는 나무
            for (int j = 0; j < W + 1; j++) {
                if (j == 0) {
                    dp[i][j] = tree == 1 ? dp[i - 1][j] + 1 : dp[i - 1][j];
                } else if (j % 2 == 0) {    // 현재 위치 1번 나무
                    dp[i][j] = tree == 1 ?
                            Math.max(dp[i - 1][j - 1], dp[i - 1][j] + 1) :  //
                            Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
                } else {    // 현재 위치 2번 나무
                    dp[i][j] = tree == 1 ?
                            Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]) :
                            Math.max(dp[i - 1][j - 1], dp[i - 1][j] + 1);
                }
            }
        }
        int answer = 0;
        for (int j=0; j<W+1; j++) {
            answer = Math.max(answer, dp[T][j]);

        }
        System.out.println(answer);
    }
}
