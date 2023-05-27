package s1_2156_WineTasting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 포도주 잔의 개수
        int[] w = new int[n+1];   // 각 포도주 잔에 들어있는 포도주의 양
        for (int i=1; i<=n; i++) {
            w[i] = Integer.parseInt(br.readLine());
        }
        if (n==1) {
            System.out.println(w[1]);
        } else if (n==2) {
            System.out.println(w[1]+w[2]);
        } else {
            int[] dp = new int[n+1];
            int[] cnt = new int[n+1];
            dp[1] = w[1]; dp[2] = w[1]+w[2];
            cnt[1] = 1; cnt[2] = 2;
            for (int i=3; i<w.length; i++) {
                if (w[i]==0) {
                    dp[i] = dp[i-1];
                    cnt[i] = 0;
                } else {
                    if (cnt[i-1]==2) {
                        if (dp[i-3]+w[i-1]+w[i]>dp[i-2]+w[i]) {
                            if (dp[i-3]+w[i-1]+w[i]>dp[i-1]) {
                                dp[i] = dp[i-3]+w[i-1]+w[i];
                                cnt[i] = 2;
                            } else {
                                dp[i] = dp[i-1];
                                cnt[i] = 0;
                            }
                        } else {
                            if (dp[i-2]+w[i]>dp[i-1]) {
                                dp[i] = dp[i-2]+w[i];
                                cnt[i] = 1;
                            } else {
                                dp[i] = dp[i-1];
                                cnt[i] = 0;
                            }
                        }

                    }else if (cnt[i-1]==1) {
                        if (dp[i-1]+w[i]>dp[i-2]+w[i]) {
                            dp[i] = dp[i-1]+w[i];
                            cnt[i] = 2;
                        } else {
                            dp[i] = dp[i-2]+w[i];
                            cnt[i] = 1;
                        }
                    }else {
                        dp[i] = dp[i-1]+w[i];
                        cnt[i] = 1;
                    }
                }
            }
            System.out.println(dp[n]);
        }
    }
}
