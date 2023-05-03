package 완전탐색.lv2.카펫;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int brown = 10;
        int yellow = 2;
        System.out.println(Arrays.toString(solution(brown, yellow)));
    }

    public static int[] solution(int brown, int yellow) {
        // area = brown+yellow
        // round = brown+4
        // x*y = area
        // 2(x+y) = round
        // y = area/x
        // x+y = round/2
        // y = round/2-x
        // area/x = round/2-x
        // area = (round/2)x-x^2
        // x^2-(round/2)x+area = 0
        int b = (brown+4)/2;
        int c = brown+yellow;
        int r = (int) Math.sqrt(Math.pow(b, 2)-4*c);
        return new int[]{(b+r)/2, (b-r)/2};
    }
}
