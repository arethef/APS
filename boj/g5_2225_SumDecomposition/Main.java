package g5_2225_SumDecomposition;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[][] dp = new long[K+1][N+1];
        dp[0][0] = 1;
        for (int i=1; i<=K; i++) {
            for (int j=0; j<=N; j++) {
                for (int l=0; l<=j; l++) {
                    dp[i][j] += dp[i-1][j-l];
                    dp[i][j] %= 1000000000;
                }
            }
        }
        System.out.println(dp[K][N]);
    }
}
