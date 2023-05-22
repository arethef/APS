package 코딩기초트레이닝.lv0.문자열이몇번등장하는지세기;

import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("banana", "ana"));
    }
    static int solution(String myString, String pat) {
        int N = myString.length();
        return (int) IntStream.range(0, N)
                .filter((i) -> myString.substring(i).startsWith(pat))
                .count();
    }
}
