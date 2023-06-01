package 연습문제.lv1.자연수뒤집어배열로만들기;

import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(34512)));
    }
    static int[] solution(long n) {
//        String[] arr = String.valueOf(n).split("");
//        return IntStream.range(0, arr.length)
//                .map((i) -> Integer.parseInt(arr[arr.length-1-i]))
//                .toArray();
        return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
    }
}
