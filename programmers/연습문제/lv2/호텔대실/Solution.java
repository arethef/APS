package 연습문제.lv2.호텔대실;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[][] book_time = {
                {"15:00", "17:00"},
                {"16:40", "18:20"},
                {"14:20", "15:20"},
                {"14:10", "19:20"},
                {"18:20", "21:20"}
        };
        System.out.println(solution(book_time));
    }
    static int solution(String[][] book_time) {
        int answer = 0;
        int N = book_time.length;
        // 시작시간, 짧은 순
        PriorityQueue<int[]> books = new PriorityQueue<>((b1, b2) -> b1[0]==b2[0] ? (b1[1]-b1[0])-(b2[1]-b2[0]) : b1[0]-b2[0]);
        for (int i=0; i<N; i++) {
            String[] start = book_time[i][0].split(":");
            String[] end = book_time[i][1].split(":");
            int s = Integer.parseInt(start[0])*60+Integer.parseInt(start[1]);
            int e = Integer.parseInt(end[0])*60+Integer.parseInt(end[1]);
            int[] book = new int[]{s, e};
            books.offer(book);
        }
        // 끝나는 시간
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        rooms.offer(books.poll()[1]+10);
        while (!books.isEmpty()) {
            int[] curr = books.poll();
            int end = rooms.peek();
            if (rooms.isEmpty()) {
                rooms.offer(curr[1]+10);
                continue;
            }
            if (end<=curr[0]) {
                rooms.poll();
            }
            rooms.offer(curr[1]+10);
        }
        return rooms.size();
    }
}
