package g5_20208_JinwooMintChocoMilk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H;
    static List<Pos> mc;
    static Pos home;
    static boolean[] visited;
    static int mcTotal, answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        mc = new ArrayList<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                String input = st.nextToken();
                if (input.equals("1")) home = new Pos(i, j);
                if (input.equals("2")) mc.add(new Pos(i, j));
            }
        }
        mcTotal = mc.size();

        for (int i=0; i<mcTotal; i++) {
            visited = new boolean[mcTotal];
            int dist = getDist(home.y, home.x, mc.get(i).y, mc.get(i).x);
            if (dist<=M) find(i, M-dist+H, 1);
        }

        System.out.println(answer);
    }
    public static void find(int currIdx, int hp, int mcCnt) {
        Pos curr = mc.get(currIdx);
        visited[currIdx] = true;
        for (int i=0; i<mcTotal; i++) {
            if (visited[i]) continue;
            Pos next = mc.get(i);
            int dist = getDist(curr.y, curr.x, next.y, next.x);
            if (dist>hp) continue;
            find(i, hp-dist+H, mcCnt+1);
        }

        int distFromLastToHome = getDist(curr.y, curr.x, home.y, home.x);
        if (distFromLastToHome<=hp) answer = Math.max(answer, mcCnt);
        visited[currIdx] = false;
    }
    public static int getDist(int y1, int x1, int y2, int x2) {
        return Math.abs(y1-y2)+Math.abs(x1-x2);
    }
    public static class Pos {
        int y, x;
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
