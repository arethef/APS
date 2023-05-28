package 코딩기초트레이닝.lv0.배열의길이를2의거듭제곱으로만들기;

import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(solution(arr)));
        arr = new int[]{58, 172, 746, 89};
        System.out.println(Arrays.toString(solution(arr)));
    }
    static int[] solution(int[] arr) {
//        int n = (int) Math.pow(2, IntStream.iterate(0, i -> i+1)
//                .filter((i) -> Math.pow(2, i)>=arr.length)
//                .findFirst()
//                .getAsInt());
        int n = (int) Math.pow(2, Math.ceil(Math.log(arr.length)/Math.log(2)));
        return Arrays.copyOf(arr, n);
    }
}
