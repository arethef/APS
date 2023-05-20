package KakaoInternship2020.보석쇼핑;

import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(Arrays.toString(solution(gems)));
        String[] gems2 = {"AA", "AB", "AC", "AA", "AC"};
        System.out.println(Arrays.toString(solution(gems2)));
        String[] gems3 = {"XYZ", "XYZ", "XYZ"};
        System.out.println(Arrays.toString(solution(gems3)));
    }
    static int[] solution(String[] gems) {
        int[] answer = {};
        int N = gems.length;
        List<String> kind = Arrays.stream(gems)
                .distinct()
                .collect(Collectors.toList());
        int K = kind.size();
        Map<String, Integer> map = new HashMap<>();
        for (String gem : kind) {
            map.put(gem, 0);
        }

        int head = 0, tail = 0;
        int minSectionHead = 0, minSectionTail = 0;

        for (int i=0; i<N; i++) {
            String currGem = gems[i];
            map.put(currGem, map.get(currGem)+1);
            tail = i;
            if (map.get(currGem)==1) {
                minSectionHead = head;
                minSectionTail = tail;
            } else {
                for (int j=head; j<i; j++) {
                    String tempGem = gems[j];
                    if (map.get(tempGem)>1) {
                        map.put(tempGem, map.get(tempGem)-1);
                    } else {
                        head = j;
                        if ((tail-head)<(minSectionTail-minSectionHead)) {
                            minSectionHead = head;
                            minSectionTail = tail;
                        }
                        break;
                    }
                }
            }
        }

        answer = new int[]{minSectionHead+1, minSectionTail+1};
        return answer;
    }
}
