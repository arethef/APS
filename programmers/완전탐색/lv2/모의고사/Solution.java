package 완전탐색.lv2.모의고사;

import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solution(answers)));
        int[] answers2 = {1, 3, 2, 4, 2};
        System.out.println(Arrays.toString(solution(answers2)));

    }
    static int[] solution(int[] answers) {
        int N = answers.length;
        HashMap<Integer, int[]> fork = new HashMap<>();
        fork.put(0, new int[]{1,2,3,4,5});
        fork.put(1, new int[]{2,1,2,3,2,4,2,5});
        fork.put(2, new int[]{3,3,1,1,2,2,4,4,5,5});
        int[] same = new int[3];
        int max = Integer.MIN_VALUE;
        for (int i=0; i<N; i++) {
            for (int j=0; j<3; j++) {
                int len = fork.get(j).length;
                if (answers[i]==fork.get(j)[i%len]) {
                    same[j]++;
                    max = Math.max(max, same[j]);
                }
            }
        }
        int finalMax = max;
        return IntStream.range(0, 3)
                .filter((i) -> same[i]== finalMax)
                .map((i) -> i+1)
                .toArray();
    }
}
