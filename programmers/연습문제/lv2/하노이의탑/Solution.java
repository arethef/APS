package 연습문제.lv2.하노이의탑;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12946
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(2));
    }
    static Stack[] tower;
    static List<int[]> m;
    static int[][] solution(int n) {
        tower = new Stack[4];
        for (int i=1; i<=3; i++) {
            tower[i] = new Stack<Integer>();
        }
        for (int i=1; i<=n; i++) {
            tower[1].push(i);
        }
        m = new LinkedList<int[]>();
        hanoi(n, 1, 2, 3);
        for (int i=0; i<m.size(); i++) {
            System.out.println(Arrays.toString(m.get(i)));
        }
        int[][] answer = new int[m.size()][2];
        for (int i=0; i<m.size(); i++) {
            answer[i] = m.get(i);
        }
        return answer;
    }

    static void hanoi(int n, int from, int mid, int to) {
        if (n==0) {
            return;
        }
        hanoi(n-1, from, to, mid);
        tower[to].push(tower[from].pop());
        m.add(new int[]{from, to});
        // System.out.println(tower[1]+" "+tower[2]+" "+tower[3]);
        hanoi(n-1, mid, from, to);
    }
}
