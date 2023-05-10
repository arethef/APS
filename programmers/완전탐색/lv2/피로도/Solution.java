package 완전탐색.lv2.피로도;

public class Solution {
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        System.out.println(solution(k, dungeons));
    }
    static int N, answer;
    static boolean[] visited;
    static int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        answer = 0;
        visited = new boolean[N];
        dfs(0, k, dungeons);
        return answer;
    }
    static void dfs(int cnt, int k, int[][] dungeons) {
        for (int i=0 ;i<N; i++) {
            if (visited[i] || k<dungeons[i][0]) {
                continue;
            }
            visited[i] = true;
            dfs(cnt+1, k-dungeons[i][1], dungeons);
            visited[i] = false;
        }
        answer = Math.max(answer, cnt);
    }
}
