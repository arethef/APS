package g5_2174_RobotSimulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int A, B, N, M;
  static int[][] land;
  static Robot[] robots;
  static Order[] orders;

  // 우하좌상 동남서북
  static int[] dy = { 0, 1, 0, -1 };
  static int[] dx = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());
    land = new int[B][A];
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    robots = new Robot[N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken()) - 1;
      int y = B - Integer.parseInt(st.nextToken());
      String direction = st.nextToken();
      int d = direction.equals("S") ? 1 : direction.equals("W") ? 2 : direction.equals("N") ? 3 : 0;
      robots[i] = new Robot(y, x, d);
      land[y][x] = i + 1;
    }
    orders = new Order[M];
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int idx = Integer.parseInt(st.nextToken()) - 1;
      String o = st.nextToken();
      int r = Integer.parseInt(st.nextToken());
      orders[i] = new Order(idx, o, r);
    }
    // 입력 끝

    StringBuilder sb = new StringBuilder();
    // 명령 순차 실행
    for (int m = 0; m < M; m++) {
      sb = new StringBuilder();
      int rIdx = orders[m].idx;
      String order = orders[m].o;
      int repeat = orders[m].r;
      String result = "OK";
      while (repeat > 0) {
        if (order.equals("L"))
          rotateLeft(rIdx);
        else if (order.equals("R"))
          rotateRight(rIdx);
        else if (order.equals("F")) {
          result = moveForward(rIdx);
          if (!result.equals("OK")) {
            break;
          }
        }
        repeat--;
      }
      if (!result.equals("OK")) {
        sb.append("Robot ");
        sb.append(rIdx + 1);
        sb.append(result);
        break;
      }
    }
    if (sb.length() == 0) {
      System.out.println("OK");
    } else {
      System.out.println(sb.toString());
    }
    br.close();
  }

  static void rotateLeft(int rIdx) {
    robots[rIdx].d = (robots[rIdx].d + 3) % 4;
  }

  static void rotateRight(int rIdx) {
    robots[rIdx].d = (robots[rIdx].d + 1) % 4;
  }

  static String moveForward(int rIdx) {
    int ny = robots[rIdx].y + dy[robots[rIdx].d];
    int nx = robots[rIdx].x + dx[robots[rIdx].d];
    if (ny < 0 || ny >= B || nx < 0 || nx >= A) {
      return " crashes into the wall";
    } else {
      if (land[ny][nx] != 0) {
        return " crashes into robot " + (land[ny][nx]);
      } else {
        land[robots[rIdx].y][robots[rIdx].x] = 0;
        land[ny][nx] = rIdx + 1;
        robots[rIdx].y = ny;
        robots[rIdx].x = nx;
        return "OK";
      }
    }
  }

  static class Order {
    int idx;
    String o;
    int r;

    Order(int idx, String o, int r) {
      this.idx = idx;
      this.o = o;
      this.r = r;
    }
  }

  static class Robot {
    int y, x, d;

    Robot(int y, int x, int d) {
      this.y = y;
      this.x = x;
      this.d = d;
    }

    @Override
    public String toString() {
      return "Robot [ y: " + y + ", x: " + x + ", d: " + d + " ]";
    }
  }
}
