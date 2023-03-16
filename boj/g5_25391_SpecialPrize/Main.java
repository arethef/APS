package g5_25391_SpecialPrize;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 총 학생 수
    int M = Integer.parseInt(st.nextToken()); // 특별상 수여할 학생 수 (주최자가 수여)
    int K = Integer.parseInt(st.nextToken()); // 본상 수여할 학생 수 (심판이 수여)
    ArrayList<Student> hostScores = new ArrayList<>();
    ArrayList<Student> refereeScores = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()); // 주최자가 매긴 점수
      int b = Integer.parseInt(st.nextToken()); // 심판이 매긴 점수
      Student s = new Student(i, a, b);
      hostScores.add(s);
      refereeScores.add(s);
    }
    Collections.sort(hostScores, new Comparator<Student>() {
      @Override
      public int compare(Student s1, Student s2) {
        return s2.a - s1.a;
      }
    });
    Collections.sort(refereeScores, new Comparator<Student>() {
      @Override
      public int compare(Student s1, Student s2) {
        return s2.b - s1.b;
      }
    });
    boolean[] awarded = new boolean[N];
    long answer = 0;
    for (int i = 0; i < K; i++) {
      Student s = refereeScores.get(i);
      answer += s.a;
      awarded[s.idx] = true;
    }
    int idx = 0, cnt = 0;
    while (cnt++ < M) {
      Student s = hostScores.get(idx);
      if (awarded[s.idx]) {
        cnt--;
      } else {
        answer += s.a;
      }
      idx++;
    }
    System.out.println(answer);
  }

  static class Student {
    int idx, a, b;

    Student(int idx, int a, int b) {
      this.idx = idx;
      this.a = a;
      this.b = b;
    }
  }
}
