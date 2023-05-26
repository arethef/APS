package Practice.lv3.부대복귀;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int n = 5;
        int[][] roads = {
                {1,2},
                {1,4},
                {2,4},
                {2,5},
                {4,5}
        };
        int[] sources = {1, 3, 5};
        int destination = 5;
        System.out.println(Arrays.toString(solution(n, roads, sources, destination)));
    }

    static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] r : roads){
            adj.get(r[0]).add(r[1]);
            adj.get(r[1]).add(r[0]);
        }

        HashMap<Integer, Integer> dist = new HashMap<>();
        dist.put(destination, 0);

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(destination, 0));

        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (int i=0; i<adj.get(curr.no).size(); i++) {
                int no = adj.get(curr.no).get(i);
                if (!dist.containsKey(no)) {
                    dist.put(no, curr.d+1);
                    q.add(new Node(no, curr.d+1));
                }
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int s : sources) {
            answer.add(dist.getOrDefault(s, -1));
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    static class Node {
        int no, d;
        Node(int no, int d) {
            this.no = no;
            this.d = d;
        }
    }
}
