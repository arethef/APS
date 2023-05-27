package s2_14426_FindPrefix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
//        String[] s = new String[N];
        Trie trie = new Trie();
        for (int i=0; i<N; i++) {
            trie.insert(br.readLine());
//            s[i] = br.readLine();
        }
        int answer = 0;
        for (int m=0; m<M; m++) {
            String str = br.readLine();
            if (trie.has(str)) {
                answer++;
                break;
            }
        }
//        for (int m=0; m<M; m++) {
//            String str = br.readLine();
//            for (int n=0; n<N; n++) {
//                if (str.equals(s[n].substring(0, str.length()))) {
//                    answer++;
//                    break;
//                }
//            }
//        }
        System.out.println(answer);
    }
}

class Trie {
    Node root;
    Trie() {
        root = new Node();
    }
    void insert(String str) {
        Node currNode = this.root;
        for (int i=0; i<str.length(); i++) {
            currNode = currNode.children.computeIfAbsent(str.charAt(i), c-> new Node());
        }
        currNode.isLast = true;
    }
    boolean has(String str) {
        Node currNode = this.root;
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            Node n = currNode.children.get(c);
            if (n==null) return false;
            currNode = n;
        }
        return currNode.isLast;
    }
}

class Node {
    Map<Character, Node> children = new HashMap<>();
    boolean isLast;
}