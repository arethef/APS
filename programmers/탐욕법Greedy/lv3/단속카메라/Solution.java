package 탐욕법Greedy.lv3.단속카메라;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] routes = {
                {-20,-15},
                {-14,-5},
                {-18,-13},
                {-5,-3}
        };
        System.out.println(solution(routes));
    }
    static int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b) -> a[1]-b[1]);
        int c = -30001;
        for (int[] r : routes) {
            if (r[0]<=c) {
                continue;
            }
            answer++;
            c = r[1];
        }
        return answer;
    }
}
