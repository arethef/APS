package kakaoIntenrship2021.NumericStringsAndEnglishWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String s = "one4seveneight";
        System.out.println(solution(s));
    }
    public static int solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        while (s.length()>0) {
            boolean check = false;
            for (int i=0; i<10; i++) {
                if (s.startsWith(num[i])) {
                    sb.append(i);
                    s = s.substring(num[i].length());
                    check = true;
                    break;
                }
            }
            if (!check) {   // 숫자로 시작한다면
                sb.append(s.charAt(0));
                s = s.substring(1);
            }
        }
        return Integer.parseInt(sb.toString());
    }

}
