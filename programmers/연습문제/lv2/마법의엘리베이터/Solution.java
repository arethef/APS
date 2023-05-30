package 연습문제.lv2.마법의엘리베이터;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(16));
        System.out.println(solution(2554));
        System.out.println(solution(678));
        System.out.println(solution(5555));
        System.out.println(solution(5000));
        System.out.println(solution(4555));
        System.out.println(solution(54555));
        System.out.println(solution(999));
    }
    static public int solution(int storey) {
        int answer = 0;
        while (storey>0) {
            int r = storey%10;
            storey /= 10;
            if (r<5) {
                answer += r;
            } else if (r>5) {
                answer += 10-r;
                storey += 1;
            } else  {
                answer += 5;
                if (storey%10>=5) {
                    storey += 1;
                }
            }
        }
        return answer;
    }
}
