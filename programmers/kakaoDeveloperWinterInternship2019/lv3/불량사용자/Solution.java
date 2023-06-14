package kakaoDeveloperWinterInternship2019.lv3.불량사용자;

import java.util.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
        System.out.println(solution(user_id, banned_id));
        banned_id = new String[] {"*rodo", "*rodo", "******"};
//        System.out.println(solution(user_id, banned_id));
        user_id = new String[]{"12345", "12453", "aaaaa"};
        banned_id = new String[]{"*****", "*****"};
//        System.out.println(solution(user_id, banned_id));
    }


    static int UN, BN;
    static ArrayList<ArrayList<String>> list = new ArrayList<>();
    static HashSet<HashSet<String>> set;
    static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        UN = user_id.length;
        BN = banned_id.length;
        for (String bid : banned_id) {
            ArrayList<String> temp = new ArrayList<>();
            for (String uid : user_id) {
                if (bid.length()!=uid.length()) continue;
                if (Pattern.matches("^[\\*]*$", bid)) {
                    temp.add(uid);
                    continue;
                }
                boolean isMatch = true;
                for (int k=0; k<bid.length(); k++) {
                    if (bid.charAt(k)=='*') continue;
                    if (bid.charAt(k)!=uid.charAt(k)) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
                    temp.add(uid);
                }
            }
            list.add(temp);
        }
        set = new HashSet<>();
        dfs(0, new HashSet<>());
        answer = set.size();
        return answer;
    }
    static void dfs(int currIdx, HashSet<String> tgt) {
        if (currIdx==BN) {
            if (tgt.size()==BN) {
                set.add(new HashSet<>(tgt));
            }
            return;
        }
        for (String uid : list.get(currIdx)) {
            if (tgt.contains(uid)) continue;
            tgt.add(uid);
            dfs(currIdx+1, tgt);
            tgt.remove(uid);
        }
    }
}
