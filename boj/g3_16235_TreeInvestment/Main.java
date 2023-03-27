package g3_16235_TreeInvestment;

import java.util.*;
import java.io.*;

public class Main {
  static int N, M, K;
  static int[][] A, land;

  static PriorityQueue<Tree> trees = new PriorityQueue<>((t1, t2) -> t1.age - t2.age);

  // 우 우하 하 좌하 좌 좌상 상 우상
  static int[] dr = { 0, 1, 1, 1, 0, -1, -1, -1 };
  static int[] dc = { 1, 1, 0, -1, -1, -1, 0, 1 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    A = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken()) - 1;
      int c = Integer.parseInt(st.nextToken()) - 1;
      int age = Integer.parseInt(st.nextToken());
      Tree t = new Tree(r, c, age);
      trees.add(t);
    }
    land = new int[N][N];
    for (int k = 0; k < K; k++) {
      // spring
      PriorityQueue<Tree> survived = new PriorityQueue<>((t1, t2) -> t1.age - t2.age);
      ArrayDeque<Tree> dead = new ArrayDeque<>();
      while (!trees.isEmpty()) {
        Tree curr = trees.poll();
        if (land[curr.r][curr.c] - curr.age >= -5) {
          land[curr.r][curr.c] -= curr.age;
          curr.age += 1;
          // authmn
          if (curr.age % 5 == 0) {
            for (int d = 0; d < 8; d++) {
              int nr = curr.r + dr[d];
              int nc = curr.c + dc[d];
              if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                continue;
              }
              Tree t = new Tree(nr, nc, 1);
              survived.add(t);
            }
          }
          survived.add(curr);
        } else {
          dead.add(curr);
        }
      }
      trees = survived;
      // summer
      while (!dead.isEmpty()) {
        Tree curr = dead.poll();
        land[curr.r][curr.c] += curr.age / 2;
      }
      // winter
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          land[i][j] += A[i][j];
        }
      }

    }
    System.out.println(trees.size());
  }

  static class Tree {
    int r, c, age;

    Tree(int r, int c, int age) {
      this.r = r;
      this.c = c;
      this.age = age;
    }

    @Override
    public String toString() {
      return "Tree {r:" + r + ", c:" + c + ", age:" + age + "}";
    }
  }
}
