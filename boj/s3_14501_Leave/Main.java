package s3_14501_Leave;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int[] t = new int[N+2];
        int[] p = new int[N+2];
        for (int i=1; i<N+1; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        int[] fee = new int[N+2];
        for (int i=N; i>0; i--) {
            // 이전까지의 최대값과 해당일에 근무해서 얻을 수 있는 수익을 비교해서 더 큰 값을 저장한다.
            if (i+t[i]>N+1) fee[i] = fee[i+1];
            else fee[i] = Math.max(fee[i+1], fee[i+t[i]]+p[i]);
        }
        System.out.println(fee[1]);
    }
}
