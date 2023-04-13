package kakaoDeveloperWinterInternship2019.lv3.징검다리건너기;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] stones = new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.println(solution(stones, k));
    }

    public static int solution(int[] stones, int k) {
        int N = stones.length;
        int low = 1, high = 200000000;
        while (low<=high) {
            int mid = (low+high)/2;
            int jump = 0;
            int[] temp = Arrays.copyOf(stones, N);
            for (int i=0; i<N; i++) {
                temp[i] -= mid;
                if (temp[i]<=0) {
                    jump++;
                } else {
                    jump = 0;
                }
                if (jump>=k) {
                    break;
                }
            }
            if (jump>=k) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
}
