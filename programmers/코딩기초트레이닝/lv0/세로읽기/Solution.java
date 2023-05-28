package 코딩기초트레이닝.lv0.세로읽기;

public class Solution {
    public static void main(String[] args) {
        String my_string = "ihrhbakrfpndopljhygc";
        int m = 4;
        int c = 2;
        System.out.println(solution(my_string, m, c));
    }
    static String solution(String my_string, int m, int c) {
        StringBuilder answer = new StringBuilder();
        for (int i=c-1; i<my_string.length(); i+=m) {
            answer.append(my_string.charAt(i));
        }
        return answer.toString();
    }
}
