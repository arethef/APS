package Practice.lv0.배열만들기4;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,4,2,5,3};
        System.out.println(Arrays.toString(solution(arr)));
    }
    static int[] solution(int[] arr) {
        List<Integer> stk = new ArrayList<>(List.of());
        int i = 0;
        while (i<arr.length) {
            if (stk.isEmpty()) {
                stk.add(arr[i]);
                i += 1;
            } else {
                if (stk.get(stk.size()-1)<arr[i]) {
                    stk.add(arr[i]);
                    i += 1;
                } else {
                    stk.remove(stk.size()-1);
                }
            }
        }
        return stk.stream().mapToInt(Integer::intValue).toArray();
    }
}
