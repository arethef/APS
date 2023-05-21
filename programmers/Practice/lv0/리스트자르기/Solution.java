package Practice.lv0.리스트자르기;

import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        int n = 3;
        int[] slicer = {1, 5, 2};
        int[] num_list = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(solution(n, slicer, num_list)));
        int n2 = 4;
        System.out.println(Arrays.toString(solution(n2, slicer, num_list)));
    }
    static int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer = {};
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        switch (n) {
            case 1 -> answer = Arrays.copyOfRange(num_list, 0, b + 1);
            case 2 -> answer = Arrays.copyOfRange(num_list, a, num_list.length);
            case 3 -> answer = Arrays.copyOfRange(num_list, a, b + 1);
            case 4 -> answer = IntStream.rangeClosed(a, b)
                    .filter((i) -> (i - a) % c == 0)
                    .map((i) -> num_list[i])
                    .toArray();
        }
        return answer;
    }
}
