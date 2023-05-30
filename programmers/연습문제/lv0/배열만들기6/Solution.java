package 연습문제.lv0.배열만들기6;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{0,1,1,1,0})));
        System.out.println(Arrays.toString(solution(new int[]{0,1,0,1,0})));
        System.out.println(Arrays.toString(solution(new int[]{0,1,1,0})));
    }
    static int[] solution(int[] arr) {
        int[] answer = {-1};
        int N = arr.length;
        List<Integer> stk = new ArrayList<>(List.of());
        int i = 0;
        while (i<N) {
            if (stk.isEmpty()) {
                stk.add(arr[i]);
                i += 1;
            } else {
                if (stk.get(stk.size()-1)==arr[i]) {
                    stk.remove(stk.size()-1);
                    i += 1;
                } else {
                    stk.add(arr[i]);
                    i += 1;
                }
            }
        }
        if (stk.isEmpty()) {
            return answer;
        } else {
            return stk.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
