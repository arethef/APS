package g5_1669_StrokingPuppy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());   // 원숭이 키
        int Y = Integer.parseInt(st.nextToken());   // 멍멍이 키
        int d = Y-X;
        int answer = 0;
        double root = Math.sqrt((double) d);

        if (d!=0){
            if (root%1==0) {
                answer = ((int) root)*2-1;
            } else {
                // boundary value
                int bv = (int) ((Math.pow(Math.floor(root), 2) +
                        Math.pow(Math.ceil(root), 2)) / 2);
                if (d<=bv) answer = 2 * (int) Math.floor(root);
                else answer = 2 * (int) Math.floor(root) + 1;
            }
        }

        System.out.println(answer);
    }
}
