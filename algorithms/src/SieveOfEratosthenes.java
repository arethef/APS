import java.util.*;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getPrimes(100)));
    }

    static int[] getPrimes(int n) {
        int[] arr = new int[n+1];
        for (int i=2; i<=n; i++) {
            arr[i] = i;
        }
        for (int i=2; i<=n; i++) {
            if (arr[i]==0) continue;
            for (int j=2*i; j<=n; j+=i) {
                arr[j] = 0;
            }
        }
        return Arrays.stream(arr)
                .filter((i) -> i!=0)
                .toArray();
    }
}
