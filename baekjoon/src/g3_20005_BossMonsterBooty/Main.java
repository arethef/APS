package g3_20005_BossMonsterBooty;

import java.util.*;
import java.io.*;

public class Main {
  static int N, M, P, HP;
  static int monsterY, monsterX;
  static char[][] map;
  static ArrayList<Player> players;
  static int[] dists;

  static boolean[][] visited;

  // 우하좌상
  static int[] dy = { 0, 1, 0, -1 };
  static int[] dx = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    P = Integer.parseInt(st.nextToken());
    map = new char[N][M];
    monsterY = 0;
    monsterX = 0;
    players = new ArrayList<>();
    dists = new int[P];
    for (int i = 0; i < N; i++) {
      String row = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = row.charAt(j);
        if (map[i][j] == 'B') {
          monsterY = i;
          monsterX = j;
        } else if (map[i][j] != '.' && map[i][j] != 'X') {
          Player p = new Player(String.valueOf(map[i][j]), i, j);
          players.add(p);
        }
      }
    }
    for (int i = 0; i < P; i++) {
      st = new StringTokenizer(br.readLine());
      String id = st.nextToken();
      int dps = Integer.parseInt(st.nextToken());
      players.forEach(((t) -> {
        if (t.id.equals(id)) {
          t.setDps(dps);
        }
      }));
    }
    HP = Integer.parseInt(br.readLine());
    visited = new boolean[N][M];

    move(monsterY, monsterX);
    int[] attack = new int[P];
    int time = 0;
    while (HP > 0) {
      time++;
      for (int i = 0; i < P; i++) {
        if (dists[i] > time) {
          continue;
        }
        HP -= players.get(i).dps;
        attack[i] += players.get(i).dps;
      }
    }
    int answer = 0;
    for (int i = 0; i < P; i++) {
      if (attack[i] != 0) {
        answer++;
      }
    }
    System.out.println(answer);
  }

  static void move(int sy, int sx) {
    ArrayDeque<Pos> queue = new ArrayDeque<>();
    queue.offer(new Pos(sy, sx, 0));
    visited[sy][sx] = true;
    int cnt = 0;
    while (!queue.isEmpty()) {
      Pos curr = queue.poll();
      if (map[curr.y][curr.x] != 'X' && map[curr.y][curr.x] != '.') {
        for (int i = 0; i < P; i++) {
          Player p = players.get(i);
          if ((p.sy == curr.y) && (p.sx == curr.x)) {
            dists[i] = curr.d;
          }
        }
        if (cnt == P) {
          break;
        }
        cnt++;
      }
      for (int d = 0; d < 4; d++) {
        int ny = curr.y + dy[d];
        int nx = curr.x + dx[d];
        if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx] || map[ny][nx] == 'X') {
          continue;
        }
        Pos n = new Pos(ny, nx, curr.d + 1);
        queue.offer(n);
        visited[ny][nx] = true;
      }
    }
  }

  static class Pos {
    int y, x, d;

    Pos(int y, int x, int d) {
      this.y = y;
      this.x = x;
      this.d = d;
    }
  }

  static class Player {
    String id;
    int sy, sx;
    int dps;

    Player(String id, int sy, int sx) {
      this.id = id;
      this.sy = sy;
      this.sx = sx;
    }

    void setDps(int dps) {
      this.dps = dps;
    }
  }
}
