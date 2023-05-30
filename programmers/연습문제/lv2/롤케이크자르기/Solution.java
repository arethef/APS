package 연습문제.lv2.롤케이크자르기;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}));
    }

    static int solution(int[] topping) {
        int answer = 0;
        int N = topping.length;
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        int[] a = new int[N];
        int[] b = new int[N];
        for (int i=0; i<N; i++) {
            setA.add(topping[i]);
            setB.add(topping[N-1-i]);
            a[i] = setA.size();
            b[N-1-i] = setB.size();
        }
        for (int i=0; i<N-1; i++) {
            if (a[i]==b[i+1]) {
                answer++;
            }
        }

        return answer;
    }
}
