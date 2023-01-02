package g5_2023_InterestingPrimeNumber;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }
    public static void dfs(int num, int idx) {
        if (idx==N) {
            if (isPrime(num)) System.out.println(num);
            return;
        }
        for (int i=1; i<10; i++) {
            if (i%2==0) continue;
            if (isPrime(num*10+i)) dfs(num*10+i, idx+1);
        }
    }
    public static boolean isPrime(int num) {
        for (int i=2; i*i<=num; i++) {
            if (num%i==0) return false;
        }
        return true;
    }
}
