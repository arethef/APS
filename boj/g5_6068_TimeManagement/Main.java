package g5_6068_TimeManagement;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Todo[] input = new Todo[N];
        StringTokenizer st = null;
        int sum = 0;
        int last = 0;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            Todo todo = new Todo(t, s);
            input[i] = todo;
            sum += t;
            last = Math.max(last, s);
        }
        Arrays.sort(input, new Comparator<Todo>() {
            @Override
            public int compare(Todo o1, Todo o2) {
                return o1.s==o2.s ? o2.t-o1.t : o1.s-o2.s;
            }
        });

        int answer = Integer.MAX_VALUE;

        int prev = 0;
        for (int i=0; i<N; i++) {
            int curr = prev + input[i].t;
            if (input[i].s<curr) {
                answer = -1;
                break;
            }
            answer = Math.min(answer, input[i].s-curr);
            prev = curr;
        }

        System.out.println(answer);
    }
    static class Todo {
        int t, s;
        Todo (int t, int s) {
            this.t = t;
            this.s = s;
        }

        @Override
        public String toString() {
            return "Todo{" +
                    "t=" + t +
                    ", s=" + s +
                    '}';
        }
    }
}
