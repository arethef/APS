package kakaoBlindRecruitment2019.FailureRate;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(solution(4, new int[]{4, 4, 4, 4, 4})));
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        // 도전자 수 담는 배열
        int[] challengers = new int[N+2];
        // 실패자 수 담는 배열
        int[] losers = new int[N+2];
        for (int i=0; i<stages.length; i++) {
            for (int j=1; j<=stages[i]; j++) {
                challengers[j] += 1;
            }
            losers[stages[i]] += 1;
        }

        // 실패율 담는 배열 rates[i][0]: stage, rates[i][1]: 실패율
        double[][] rates = new double[N][2];
        for (int i=0; i<N; i++) {
            if (challengers[i+1]!=0) {
                rates[i][1] = (double) losers[i+1]/challengers[i+1];
            }
            rates[i][0] = i+1;
        }

        Arrays.sort(rates, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return o1[1]==o2[1] ?
                        o1[0]<o2[0] ? -1 : 1 :
                        o1[1]<o2[1] ? 1 : -1;
            }
        });

        for (int i=0; i<N; i++) {
            answer[i] = (int) rates[i][0];
        }

        return answer;
    }

}
