package 코딩기초트레이닝.lv0.배열만들기2;

import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        int l = 5, r = 555;
        System.out.println(Arrays.toString(solution(l, r)));
    }
    static int[] solution(int l, int r) {
        int[] result =  IntStream.rangeClosed(l, r)
                .filter((i) -> {
                    int d = 10;
                    while (i>1) {
                        if (i%d==0 || i%d==5) {
                            i/=d;
                        } else {
                            break;
                        }
                    }
                    return i < 1;
                })
                .sorted()
                .toArray();
        if (result.length==0) {
            return new int[]{-1};
        } else {
            return result;
        }
    }
}
