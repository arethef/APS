package Practice.lv2.뒤에있는큰수찾기;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 3, 3, 5})));
        System.out.println(Arrays.toString(solution(new int[]{9, 1, 5, 3, 6, 2})));
    }

    static public int[] solution(int[] numbers) {
        int N = numbers.length;
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[N];
        stack.push(0);
        for (int i=1; i<N; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()]<numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        return answer;
    }
}
