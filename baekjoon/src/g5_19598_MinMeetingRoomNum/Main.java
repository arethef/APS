package g5_19598_MinMeetingRoomNum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st;
    PriorityQueue<Meeting> pq = new PriorityQueue<>((m1, m2) -> m1.s == m2.s ? m1.e - m2.e : m1.s - m2.s);
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      pq.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }
    PriorityQueue<Integer> room = new PriorityQueue<>();
    room.add(pq.poll().e);
    while (!pq.isEmpty()) {
      Meeting m = pq.poll();
      if (room.peek() <= m.s) {
        room.poll();
      }
      room.add(m.e);
    }
    System.out.println(room.size());
  }

  public static class Meeting {
    int s, e; // start, end

    public Meeting(int s, int e) {
      this.s = s;
      this.e = e;
    }
  }
}
