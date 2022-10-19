package DevMatching2021WebBackend.Lotto;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        System.out.println(Arrays.toString(solution(lottos, win_nums)));
        lottos = new int[]{0, 0, 0, 0, 0, 0};
        win_nums = new int[]{38, 19, 20, 40, 15, 25};
        System.out.println(Arrays.toString(solution(lottos, win_nums)));
        lottos = new int[]{45, 4, 35, 20, 3, 9};
        win_nums = new int[]{20, 9, 3, 45, 4, 35};
        System.out.println(Arrays.toString(solution(lottos, win_nums)));

    }
    public static int[] solution(int[] lottos, int[] win_nums) {
        int erased = 0;
        for (int l : lottos) {
            if (l==0) {
                erased++;
            }
        }
        int[] revealed = new int[6-erased];
        int idx = 0;
        for (int l=0; l<lottos.length; l++) {
            if (lottos[l]!=0) {
                revealed[idx] = lottos[l];
                idx++;
            }
        }
        int matched = 0;
        for (int l=0; l<revealed.length; l++) {
            for (int w=0; w<win_nums.length; w++) {
                if (revealed[l]==win_nums[w]) {
                    matched++;
                    break;
                }
            }
        }
        int max = matched+erased<1 ? 6 : 7-(matched+erased);
        int min = matched<=1 ? 6 : 7-matched;
        int[] answer = new int[]{max, min};

        return answer;
    }
}
