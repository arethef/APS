package s4_10610_30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        if (!N.contains("0")) { // 10의 배수
            System.out.println(-1);
            return;
        }
        int len = N.length();
        int[] arri = new int[len];
        int check = 0;
        for (int i=0; i<len; i++) {
            arri[i] = N.charAt(i)-'0';
            check += arri[i]-'0';
        }
        Arrays.sort(arri);
        StringBuilder answer = new StringBuilder();
        if (check%3!=0) {   // 3의 배수
            System.out.println(-1);
        } else {
            for (int i=len-1; i>=0; i--) answer.append(arri[i]);
            System.out.println(answer.toString());
        }
    }
}
