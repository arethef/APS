package KakaoBlindRecruitment2023.lv1.개인정보수집유효기간;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        System.out.println(Arrays.toString(solution(today, terms, privacies)));

    }
    static int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> dict = new HashMap<>();
        for (String term : terms) {
            String[] tArr = term.split(" ");
            dict.put(tArr[0], Integer.parseInt(tArr[1])*28);
        }

        String[] t = today.split("\\.");
        int daysToday = (Integer.parseInt(t[0])-2000)*12*28 + (Integer.parseInt(t[1])-1)*28 + Integer.parseInt(t[2]);

        for (int i=0; i<privacies.length; i++) {
            String[] pArr = privacies[i].split(" ");
            String[] c = pArr[0].split("\\.");
            int daysCurr = (Integer.parseInt(c[0])-2000)*12*28 + (Integer.parseInt(c[1])-1)*28 + Integer.parseInt(c[2]);
            if (daysToday-daysCurr >= dict.get(pArr[1])) {
                answer.add(i+1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
