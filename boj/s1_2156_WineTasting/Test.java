package s1_2156_WineTasting;

import java.io.*;

public class Test {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] w = new int[n];
        for (int i=0; i<n; i++) {
            w[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[n];
        dp[0] = w[0];
        if (n>1) {
            dp[1] = w[0]+w[1];
        }
        if (n>2) {
            dp[2] = Math.max(dp[1], Math.max(w[1]+w[2], w[0]+w[2]));
        }
        for (int i=3; i<n; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+w[i], dp[i-3]+w[i-1]+w[i]));
        }
        System.out.println(dp[n-1]);
    }
}
