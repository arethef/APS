package boj.s4_10610_30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class dokyung {

    static long tmp;
    static int MAXIMUM = Integer.MIN_VALUE;
    static PriorityQueue<String> pqueue = new PriorityQueue<String>(Collections.reverseOrder());

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        int strLength = N.length();

        char[] arr = new char[strLength];
        char[] output = new char[strLength];
        boolean[] visited = new boolean[strLength];

        arr = N.toCharArray();

        permutation(arr, output, visited, 0, strLength);

        if(pqueue.size() == 0) {
            System.out.println(-1);
        }else {
            System.out.println(pqueue.poll());
        }
    }
    static void permutation(char[] arr, char[] output, boolean[] visited, int depth, int n) {
        if(depth == n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(output[i]);
            }
            tmp = Long.parseLong(sb.toString());
            System.out.println(tmp);
            if(tmp % 30 == 0) {
                pqueue.offer(sb.toString());
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visited, depth+1, n);
                visited[i] = false;
            }
        }
    }
}

//3333333333330