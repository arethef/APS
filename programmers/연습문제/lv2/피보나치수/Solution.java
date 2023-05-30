package 연습문제.lv2.피보나치수;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println(solution(5));
    }
    static int solution(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i=2; i<=n; i++) {
            dp[i] = (dp[i-1]+dp[i-2])%1234567;
        }
        return dp[n];
    }
}
