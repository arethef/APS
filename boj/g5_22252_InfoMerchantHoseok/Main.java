package g5_22252_InfoMerchantHoseok;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int Q = Integer.parseInt(br.readLine());
        Map<String, PriorityQueue<Integer>> map = new HashMap<>();
        long answer = 0;
        for (int q=0; q<Q; q++) {
            st = new StringTokenizer(br.readLine());
            String infoKinds = st.nextToken();
            String name = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            switch (infoKinds) {
                case "1":
                    if (!map.containsKey(name)) map.put(name, new PriorityQueue<>((e1, e2) -> e2-e1));
                    for (int i=0; i<n; i++) {
                        map.get(name).add(Integer.parseInt(st.nextToken()));
                    }
                    break;
                case "2":
                    if (!map.containsKey(name)) break;
                    for (int i=0; i<n; i++) {
                        if (map.get(name).size()==0) break;
                        answer += map.get(name).poll();
                    }
                    break;
            }
        }
        System.out.println(answer);
    }
}
