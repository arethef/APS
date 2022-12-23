package g4_15686_DragonCurve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] map;
    static List<int[]> points;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new boolean[101][101];    //기준점(50,50)
        //우상좌하
        int[] dy = {0, -1, 0, 1};
        int[] dx = {1, 0, -1, 0};
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int[] s = new int[2];   //회전점 0:y, 1:x
            s[0] = y+dy[d];
            s[1] = x+dx[d];
            if (s[0]<0 || s[0]>100 || s[1]<0 || s[1]>100) continue;
            points = new ArrayList<>();
            points.add(new int[]{y, x});
            points.add(new int[]{s[0], s[1]});
            map[y][x] = true;
            map[s[0]][s[1]] = true;
            for (int j=0; j<g; j++) {
                s = rotate(i, s, points.size());
            }
        }
        int answer = 0;
        for (int i=0; i<100; i++) {
            for (int j=0; j<100; j++) {
                if (map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
    public static int[] rotate(int n, int[] s, int p) {
        //시계방향 90도 회전
        //ny: sy+(cx-sx), nx: sx+(sy-cy)
        for (int i=p-2; i>=0; i--) {
            int ny = s[0]+(points.get(i)[1]-s[1]);
            int nx = s[1]+(s[0]-points.get(i)[0]);
            if (ny<0 || ny>100 || nx<0 || nx>100) continue;
            points.add(new int[]{ny, nx});
            map[ny][nx] = true;
        }
        s[0] = points.get(points.size()-1)[0];
        s[1] = points.get(points.size()-1)[1];
        return s;
    }
}
