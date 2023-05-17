package 깊이너비우선탐색DFSBFS.lv3.네트워크;

import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(solution(n, computers));
    }

    static int[] p;
    static int solution(int n, int[][] computers) {
        int answer = 0;
        p = new int[n];
        for (int i=0; i<n; i++) {
            p[i] = i;
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i==j) {
                    continue;
                }
                if (computers[i][j]==1) {
                    union(i, j);
                }
            }
        }

//        answer = (int) Arrays.stream(p)
//                .distinct()
//                .count();
        for (int i=0; i<n; i++) {
            if (p[i]==i) {
                answer++;
            }
        }

        return answer;
    }

    static int find(int n) {
        if (n==p[n]) return n;
        return p[n] = find(p[n]);
    }

    static void union(int n1, int n2) {
        int r1 = find(n1);
        int r2 = find(n2);
        if (r1 < r2) {
            p[r2] = r1;
        } else {
            p[r1] = r2;
        }
    }
}
