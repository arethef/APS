package s1_15954_StuffedToys;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 인형 수, 1이상 500이하 정수
    int K = Integer.parseInt(st.nextToken()); // 연속된 위치의 인형 수 1이상 N이하 정수
    int[] t = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      t[i] = Integer.parseInt(st.nextToken());
    }
    double answer = Double.MAX_VALUE;
    double std = 0.0;
    for (int j = K; j < N + 1; j++) {
      for (int i = 0; i < N - j + 1; i++) {
        double avg = getAvg(t, i, j);
        std = getStd(t, avg, i, j);
        answer = Math.min(answer, std);
      }
    }
    bw.write(String.format("%.11f", answer) + "\n");
    bw.flush();
    bw.close();
    br.close();
  }

  // 평균
  static double getAvg(int[] arr, int start, int K) {
    double sum = 0.0;
    for (int i = 0; i < K; i++) {
      sum += arr[start + i];
    }
    return sum / K;
  }

  // 표준편차
  static double getStd(int[] arr, double avg, int start, int K) {
    double sum = 0.0;
    for (int i = 0; i < K; i++) {
      sum += Math.pow(arr[start + i] - avg, 2);
    }
    return Math.sqrt(sum / K);
  }
}
