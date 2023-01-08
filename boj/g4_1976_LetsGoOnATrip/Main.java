package g4_1976_LetsGoOnATrip;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
    static int N, M;
    static int[] parents;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parents = new int[N];
        makeSet();
        for (int i=0; i<N; i++) {
            String[] map = br.readLine().split(" ");
            for (int j=0; j<N; j++) {
                if (map[j].equals("1")) union(i, j);
            }
        }
        String[] plan = br.readLine().split(" ");
        boolean flag = true;
        int prevRoot = findSet(Integer.parseInt(plan[0])-1);
        for (int i=1; i<M; i++) {
            int currRoot = findSet(Integer.parseInt(plan[i])-1);
            if (prevRoot!=currRoot) {
                flag = false;
                break;
            }
            prevRoot = currRoot;
        }
        if (flag) System.out.println("YES");
        else System.out.println("NO");

    }

    public static void makeSet() {
        parents = new int[N];
        for (int i=0; i<N; i++) {
            parents[i] = i;
        }
    }

    public static int findSet(int a) {
        if (a==parents[a]) return a;
        return parents[a] = findSet(parents[a]);
    }

    public static void union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot==bRoot) return;
        parents[bRoot] = aRoot;
    }
}
