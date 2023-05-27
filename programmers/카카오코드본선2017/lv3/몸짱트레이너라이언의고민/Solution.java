package 카카오코드본선2017.lv3.몸짱트레이너라이언의고민;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        int n = 3;
        int m = 2;
        int[][] timetable = {
                {1170,1210},
                {1200,1260}
        };
        System.out.println(solution(n, m, timetable));
        n = 2;
        m = 1;
        timetable = new int[][]{
                {840,900}
        };
        System.out.println(solution(n, m, timetable));
        n = 2;
        m = 2;
        timetable = new int[][]{
                {600,630},
                {630,700}
        };
        System.out.println(solution(n, m, timetable));
        n = 4;
        m = 5;
        timetable = new int[][]{
                {1140,1200},
                {1150,1200},
                {1100,1200},
                {1210,1300},
                {1220,1280},
        };
        System.out.println(solution(n, m, timetable));
    }
    static int solution(int n, int m, int[][] timetable) {
        int answer = 0;
        int maxPeopleCount = 0;

//        Arrays.sort(timetable, (t1, t2) -> t1[0]==t2[0] ? t1[1]-t2[1] : t1[0]-t2[0]);
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        int peopleCount = 0;
//        for (int i=0; i<m; i++) {
//            int start = timetable[i][0];
//            int end = timetable[i][1];
//            while (!pq.isEmpty() && pq.peek()<start) {
//                pq.poll();
//                peopleCount--;
//            }
//            pq.add(end);
//            peopleCount++;
//            if (peopleCount>maxPeopleCount) {
//                maxPeopleCount = peopleCount;
//            }
//        }
        // (73.19ms, 107MB)

        int[] peopleCount = new int[1321];
        for (int[] t : timetable) {
            int start = t[0];
            int end = t[1];
            for (int i=start; i<=end; i++) {
                peopleCount[i]++;
                maxPeopleCount = Math.max(maxPeopleCount, peopleCount[i]);
            }
        }
        // (43.68ms, 97.5MB)

        if (maxPeopleCount<=1) {
            return answer;
        }

        ArrayList<Pos> list = new ArrayList<>();
        // 거리 최대~최소
        for (int d=2*(n-1); d>=1; d--) {
            // 첫 행에서 처음 시작 지점 0~n열
            for (int j=0; j<n; j++) {
                int setCount = 0;
                list.clear();
                for (int r=0; r<n; r++) {
                    for (int c=0; c<n; c++) {
                        if (r==0 && c<j) {
                            continue;
                        }
                        boolean possible = true;
                        for (Pos p : list) {
                            if (Math.abs(p.r-r)+Math.abs(p.c-c)<d) {
                                possible = false;
                                break;
                            }
                        }
                        if (possible) {
                            if (++setCount==maxPeopleCount) {
                                return d;
                            }
                            list.add(new Pos(r, c));
                        }
                    }
                }
            }
        }

        return answer;
    }

    static class Pos {
        int r, c;
        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
