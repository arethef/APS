package 코딩기초트레이닝.lv0.콜라츠수열만들기;

import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10)));
    }
    static int[] solution(int n) {
        return IntStream.concat(
                IntStream.iterate(n, i -> i>1, i -> i%2==0 ? i/2 : i*3+1),
                IntStream.of(1)
        ).toArray();
    }
}
