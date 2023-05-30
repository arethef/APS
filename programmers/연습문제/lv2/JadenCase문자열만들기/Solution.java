package 연습문제.lv2.JadenCase문자열만들기;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
        System.out.println(solution("for the last week"));
    }
    static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        s = s.toUpperCase();
        int n = s.length();
        answer.append(s.charAt(0));
        for (int i=1; i<n; i++) {
            if (s.charAt(i-1)==' ') {
                answer.append(s.charAt(i));
            } else {
                answer.append(String.valueOf(s.charAt(i)).toLowerCase());
            }
        }
        return answer.toString();
    }
}
