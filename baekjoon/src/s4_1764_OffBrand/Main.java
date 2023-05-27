package s4_1764_OffBrand;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //듣도 못한 사람의 수
        int M = Integer.parseInt(st.nextToken());   //보도 못한 사람의 수
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<N+M; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0)+1);
        }
        Queue<String> pq = new PriorityQueue<>();
        map.forEach((key, value) -> {
            if (value==2) {
                pq.add(key);
            }
        });
        System.out.println(pq.size());
        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
