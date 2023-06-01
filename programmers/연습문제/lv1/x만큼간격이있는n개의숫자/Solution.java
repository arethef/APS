package 연습문제.lv1.x만큼간격이있는n개의숫자;

import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2, 5)));
        System.out.println(Arrays.toString(solution(4, 3)));
        System.out.println(Arrays.toString(solution(-4, 2)));
    }
    static long[] solution(int x, int n) {
        return LongStream.iterate(x, (i) -> i+x)
                .limit(n)
                .toArray();
    }
}
