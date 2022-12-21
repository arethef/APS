package s1_2841_AlienPlayingGuitar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int F = Integer.parseInt(st.nextToken());
        int answer = 0;

        Stack<Integer>[] s = new Stack[7];
        for (int i=0; i<7; i++) s[i] = new Stack<Integer>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int cs = Integer.parseInt(st.nextToken());
            int cf = Integer.parseInt(st.nextToken());

            while (!s[cs].isEmpty() && s[cs].peek()>cf) {
                s[cs].pop();
                answer++;
            }
            if (s[cs].isEmpty() || s[cs].peek()<cf) {
                s[cs].push(cf);
                answer++;
            }

        }
        System.out.println(answer);
    }
}
