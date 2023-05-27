package s1_2002_Overtaking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> in = new LinkedList<>();
        List<String> out = new LinkedList<>();
        for (int i=0; i<N; i++) {
            in.add(br.readLine());
        }
        for (int i=0; i<N; i++) {
            out.add(br.readLine());
        }

        List<String> suspect = new LinkedList<>();

        while (out.size()!=0) {
            String icar = in.get(0);
            String ocar = out.get(0);
            if (!icar.equals(ocar)) suspect.add(ocar);
            in.remove(ocar);
            out.remove(ocar);
        }

        System.out.println(suspect.size());
    }
}
