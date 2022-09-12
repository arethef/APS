package s2_1141_Prefix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/*
if map에 현재 인덱스 단어의 접두어가 되는 단어 존재
    map에 현재 인덱스 단어 넣기
    map에서 해당 접두어 제거하기
else
    map에 현재 인덱스 단어 넣기
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] prefixes = new String[N];
        for (int i=0; i<N; i++) {
            prefixes[i] = br.readLine();
        }
//        Arrays.sort(prefixes, (e1, e2)-> Integer.compare(e1.length(),e2.length()));
        Arrays.sort(prefixes, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (int i=0; i<N; i++) {
            boolean check = false;
            for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
                if (prefixes[i].startsWith(entry.getKey())) {
                    map.put(prefixes[i], new ArrayList<>());
                    map.remove(entry.getKey());
                    break;
                }
            }
            if (!check) {
                map.put(prefixes[i], new ArrayList<String>());
            }
        }
        System.out.println(map.size());
    }
}
