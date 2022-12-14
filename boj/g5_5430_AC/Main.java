package g5_5430_AC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    static int T;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder(br.readLine());
            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length()-1);
            String[] arr = sb.toString().split(",");
            Deque<String> q = new ArrayDeque<>(Arrays.asList(arr));
            String answer = "";
            int cntR = 0;
            for (int i=0; i<p.length(); i++) {
                char func = p.charAt(i);
                if (func=='R') {
                    cntR++;
                } else if (func=='D') {
                    if (n==0) {
                        answer = "error";
                        break;
                    }
                    if (cntR%2==0) {
                        q.pollFirst();
                    } else {
                        q.pollLast();
                    }
                    n--;
                }
            }
            if (answer.equals("")) {
                sb = new StringBuilder();
                if (!q.isEmpty()){
                    String[] res = new String[q.size()];
                    if (cntR%2==1) {
                        for (int i=0; i<res.length; i++) {
                            res[i] = q.pollLast();
                        }
                    } else {
                        for (int i=0; i<res.length; i++) {
                            res[i] = q.pollFirst();
                        }
                    }
                    for (int i=0; i<res.length; i++) {
                        sb.append(res[i]).append(",");
                    }
                    sb.deleteCharAt(sb.length()-1);
                }
                sb.insert(0, "[");
                sb.append("]");
                answer = sb.toString();
            }
            System.out.println(answer);
        }
    }
}
