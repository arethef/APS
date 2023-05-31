package 힙Heap.lv3.이중우선순위큐;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        System.out.println(Arrays.toString(solution(operations)));
        operations = new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(Arrays.toString(solution(operations)));
    }
    static int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> maxq = new PriorityQueue<>((i1, i2) -> i2-i1);
        PriorityQueue<Integer> minq = new PriorityQueue<>((i1, i2) -> i1-i2);
        for (String operation : operations) {
            String[] o = operation.split(" ");
            int num = Integer.parseInt(o[1]);
            if (o[0].equals("I")) {
                maxq.add(num);
                minq.add(num);
            } else {
                if (num==1) {
                    minq.remove(maxq.poll());
                } else {
                    maxq.remove(minq.poll());
                }
            }
        }
        if (maxq.isEmpty()) {
            return answer;
        }
        answer[0] = maxq.poll();
        answer[1] = minq.poll();
        return answer;
    }
}
