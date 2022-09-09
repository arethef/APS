package s3_14425_StringSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] tgt = new String[N];
        String[] src = new String[M];
        for (int i=0; i<N; i++) {
            tgt[i] = br.readLine();
        }
        for (int i=0; i<M; i++) {
            src[i] = br.readLine();
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<N; i++) {
            map.put(tgt[i], map.getOrDefault(tgt[i], 0)+1);
        }
        int answer = 0;
        for (int i=0; i<M; i++) {
            if (map.containsKey(src[i])) answer++;
        }
        System.out.println(answer);
    }
}
