package boj.s4_10610_30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_timeover {
    static String answer;
    static char[] arrN, candi;
    static boolean found;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        arrN = new char[N.length()];
        candi = new char[N.length()];
        int check = 0;
//        for (int i=0; i<N.length(); i++) {
//            arrN[i] = N.charAt(i);
//            check += arrN[i]-'0';
//        }
        List<Character> listN = new ArrayList<>();
        for (int i=0; i<N.length(); i++) {
            listN.add(N.charAt(i));
        }
        arrN = new char[N.length()];
        candi = new char[N.length()];
        listN.sort((a, b)->b-a);
        for (int i=0; i<N.length(); i++) {
            arrN[i] = listN.get(i);
            check += arrN[i]-'0';
        }
        if (check%3!=0 || !N.contains("0")) {
            System.out.println(-1);
        }else {
            perm(0, 0, N.length());
            if (found) System.out.println(answer);
            else System.out.println(-1);
        }

    }
    static void perm(int curr, int flag, int len) {
        if (curr==len) {
            System.out.println(Arrays.toString(candi));
            StringBuilder sb = new StringBuilder();
            for (char n:candi) {
                sb.append(n);
            }
            if (Long.parseLong(sb.toString())%30==0) {
                found = true;
                answer = sb.toString();
            }
            return;
        }
        for (int i=0; i<len; i++) {
            if ((flag & 1<<i)!=0) continue;
            candi[curr] = arrN[i];
//            candi[curr] = arrN[len-i-1];
            perm(curr+1, flag | 1<<i, len);
            if (found) return;
        }
    }
}
