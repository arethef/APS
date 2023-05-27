package s1_1389_KevinBacon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j)
                    adj[i][j] = 0;
                // else adj[i][j] = Integer.MAX_VALUE;
                else
                    adj[i][j] = 1000000000;
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int user1 = Integer.parseInt(st.nextToken()) - 1;
            int user2 = Integer.parseInt(st.nextToken()) - 1;
            adj[user1][user2] = 1;
            adj[user2][user1] = 1;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                if (i == k)
                    continue;
                for (int j = 0; j < N; j++) {
                    if (i == j || k == j)
                        continue;
                    if (adj[i][j] > adj[i][k] + adj[k][j]) {
                        adj[i][j] = adj[i][k] + adj[k][j];
                    }
                }
            }
        }
        int[] kevinBaconNum = new int[N];
        int min = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                kevinBaconNum[i] += adj[i][j];
            }
            if (kevinBaconNum[i] < min) {
                answer = i + 1;
                min = kevinBaconNum[i];
            }
        }
        System.out.println(answer);
    }
}
