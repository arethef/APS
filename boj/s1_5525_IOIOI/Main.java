package s1_5525_IOIOI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // O의 개수
        int M = Integer.parseInt(br.readLine());    // 문자열 길이
        int pflag = 0;
        for (int i=0; i<N*2+1; i++) {
            if (i%2==0) pflag += Math.pow(2, i);
        }
        int sflag = 0;
        char[] s = br.readLine().toCharArray();
        for (int i=0; i<M; i++) {
            if (s[i]=='I') {
                sflag += Math.pow(2, M-i);
            }
        }
        int answer = 0;
        for (int i=0; i<M-N*2; i++) {
            System.out.println("sflag: "+sflag+", sflag>>"+(M-i-N*2)+": "+(sflag>>(M-i+N*2)));
            System.out.println("binary sflag: "+Integer.toBinaryString(sflag));
            if (sflag>>(M-i-N*2)==pflag) {
                System.out.println("[answer] sflag>>"+(M-i-N*2)+": "+(sflag>>(M-i+N*2))+", pflag: "+pflag);
                answer++;
                sflag -= Math.pow(2, M-i);
//                System.out.println("sflag>>"+(M-i-N*2-1)+": "+(sflag>>(M-i+N*2-1))+", pflag: "+pflag);
            } else {
                if (s[i]=='I') {
                    sflag -= Math.pow(2, M-i);
                }
            }
        }

        System.out.println(answer);
    }
}
